import java.util
import org.apache.kafka.clients.consumer.{ConsumerConfig, KafkaConsumer, RangeAssignor}

import java.util.Properties
import org.slf4j.{Logger, LoggerFactory}

import scala.jdk.CollectionConverters._

object RoutingConsumerCore {
  var log:Logger = LoggerFactory.getLogger("RoutingConsumer")

//  val kafkaHost: String = "kafka.service.consul:9092"
//  val kafkaTopic: String = "core-reporterLoad-ccc_routing"

  val kafkaHost: String = "kafka:9092"
  //val kafkaTopic: String = "load-ccc_agentnotifs"// load-ccc_routing"
//  val kafkaTopic: String = "ccc_routing"// "
 // val kafkaTopic: String = "ccc_sqm"// "
val kafkaTopic: String = "ccc_agentnotifs"

  def main(args: Array[String]): Unit = {
    consumeFromKafka()
  }
  def consumeFromKafka() = {
    val props = new Properties()
    props.put("bootstrap.servers", kafkaHost)
    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    props.put(ConsumerConfig.PARTITION_ASSIGNMENT_STRATEGY_CONFIG, "org.apache.kafka.clients.consumer.RangeAssignor")
    props.put("group.id", "consumer-group2")
    val consumer: KafkaConsumer[String, String] = new KafkaConsumer[String, String](props)
    consumer.subscribe(util.Arrays.asList(kafkaTopic))
    log.info(s"Partition assignment strategy: ${props.get(ConsumerConfig.PARTITION_ASSIGNMENT_STRATEGY_CONFIG)}")
    log.info(s"Waiting for event on topic ${kafkaTopic}")
    while (true) {
      //log.info("Waiting for event")
      val record = consumer.poll(500).asScala
      for (data <- record.iterator) {
        log.info(s"Partition: ${data.partition()}, GOT Event key: ${data.key()} Message: ${data.value()}")
      }
    }
  }
}