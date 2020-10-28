package app

import io.prometheus.client.Counter

object MinimalApplication  extends   cask.MainRoutes  with PrometheusMetrics   {

  override def port: Int = 9091

  override def host: String = "0.0.0.0"

  val cpuLoader = new CpuLoader

  val req = Counter.build()
    .name("my_library_requests_total").help("Total requests.").labelNames("path").register();

  @cask.get("/")
  def hello() = {
    print ("Got a GET")
   // req.inc()
    incrementCounter("testorg","testclassifier","testcalls")
    "Hello World - NNew!"
  }

  @cask.post("/do-thing")
  def doThing(request: cask.Request) = {
    print ("Got a POST")
    new String(request.readAllBytes()).reverse
  }

  @cask.get("/prometheus/metrics")
  def getMetrics(request: cask.Request) = {
    print ("Got a Metrics request with request: ~!" + request.text())
    getScrapingResponse(Some(request.text()))
  }

  @cask.get("/cpustart")
  def goBusy(request: cask.Request) = {
    print ("Going busy: ~!" + request.text())
    cpuLoader.busyDuration = 10000
    cpuLoader.idleDuration = 5000
    cpuLoader.start()
    "Going Busy1"
  }

  @cask.get("/cpustop")
  def goNormal(request: cask.Request) = {
    print ("Going normal: ~!" + request.text())
    cpuLoader.stop()
    "Going Normal"
  }

  initialize()
  initMetrics()


  print("*** App started ***")
}