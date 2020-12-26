import java.util

import org.apache.kafka.clients.consumer.KafkaConsumer
import java.util.Properties

import org.slf4j.{Logger, LoggerFactory}

import scala.jdk.CollectionConverters._

object SimpleConsumer {
  var log:Logger = LoggerFactory.getLogger("StreamerConsumer")

  def main(args: Array[String]): Unit = {
    consumeFromKafka("quickstart-events")
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
      val record = consumer.poll(1000).asScala
      for (data <- record.iterator)
        log.info("GOT Event: " + data.value())
    }
  }
}