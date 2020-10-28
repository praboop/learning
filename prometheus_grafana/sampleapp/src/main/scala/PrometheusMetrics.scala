package app

import java.io.StringWriter
import java.net.URLDecoder
import java.util

import io.prometheus.client.{CollectorRegistry, Counter, Gauge, Histogram}
import io.prometheus.client.exporter.common.TextFormat
import io.prometheus.client.hotspot.DefaultExports

import scala.util.Try
import scala.util.Properties.{envOrElse, propOrEmpty}

trait PrometheusMetrics {

  var appName:String = "TRY-PROM"

  val appCounters = envOrElse("metric_counters", "testcalls")

  def makeCounter(name: String): Counter =
    Counter
      .build()
      .name(name)
      .help(s"Counter for $name")
      .labelNames("appName", "orgId", "classifier")
      .register()

  val counters: Map[String, Counter] =
    appCounters.split(',').map(_.trim()).filter(!_.isEmpty).map(x => (x -> makeCounter(x))).toMap

  def incrementCounter(orgId: String, classifier: String, counterName: String): Unit =
    Try(counters(counterName))
      .map(_.labels(appName, orgId, classifier).inc())





  def getScrapingResponse(query: Option[String]): String = {
    val sw      = new StringWriter()
    val samples = CollectorRegistry.defaultRegistry.filteredMetricFamilySamples(parseQuery(query))
    TextFormat.write004(sw, samples)
    sw.toString
  }

  protected def parseQuery(q: Option[String]): util.Set[String] = {
    val names = new util.HashSet[String]()

    q.map { query =>
      val pairs = query.split("&")
      for (pair <- pairs) {
        val idx = pair.indexOf("=")
        if (idx != -1 && URLDecoder.decode(pair.substring(0, idx), "UTF-8") == "name[]")
          names.add(URLDecoder.decode(pair.substring(idx + 1), "UTF-8"))
      }
    }
    names
  }

  def initMetrics(): Unit = DefaultExports.initialize()
}
