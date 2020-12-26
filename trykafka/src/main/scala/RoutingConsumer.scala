import java.util

import org.apache.kafka.clients.consumer.KafkaConsumer
import java.util.Properties

import org.slf4j.{Logger, LoggerFactory}

import scala.jdk.CollectionConverters._

object RoutingConsumer {
  var log:Logger = LoggerFactory.getLogger("RoutingConsumer")

  def main(args: Array[String]): Unit = {
    consumeFromKafka("ccc_routing")
  }
  def consumeFromKafka(topic: String) = {
    val props = new Properties()
    props.put("bootstrap.servers", "localhost:9092")
    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    props.put("group.id", "consumer-group1")
    val consumer: KafkaConsumer[String, String] = new KafkaConsumer[String, String](props)
    consumer.subscribe(util.Arrays.asList(topic))
    while (true) {
      log.info("Waiting for event")
      val record = consumer.poll(0).asScala
      for (data <- record.iterator)
        log.info("GOT Event: " + data.value())
    }
  }
}