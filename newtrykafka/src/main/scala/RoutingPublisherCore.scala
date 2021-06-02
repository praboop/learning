import org.apache.kafka.clients.producer._
import org.slf4j.{ Logger, LoggerFactory }

import java.util.Properties

object RoutingPublisherCore {
  var log: Logger = LoggerFactory.getLogger("StreamerProducer")

  val kafkaHost: String  = "kafka:9092"
  val kafkaTopic: String = "ccc_agentnotifs"

  def main(args: Array[String]): Unit =
    writeToKafka()

  def writeToKafka(): Unit = {
    val props = new Properties()
    props.put("bootstrap.servers", kafkaHost)
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    val producer = new KafkaProducer[String, String](props)
    1.to(100).foreach { i =>
      //val message: String = s"""eventType":"RoutingMessage","interactionId":"${i}","orgId":"fbe122dc-814e-4bdf-b445-8ab9d1671d5d","fcScriptId":"AXRTz1Ig9ic5vAs7SEej","mediaMgr":"cmm","mediaType":"Voice","mediaChannel":"web","mediaResourceId":"Y2lzY29zcGFyazovL3VzL1JPT00vNWE1ZGUwZTAtMDhhNS0xMWViLTg4MWItNWIxY2Y1NWNhZDIx","ani":"*******","dn":"*******************************","details":{"taskToBeSelfServiced":"false","customerName":"ABC","ani":"*******","entryPointId":"AXRTz1Ig9ic5vAs7SEej","templateName":"intgus1 Chat ESR- Do not delete","reasonCode":"Credit","templateId":"8e719d60-eddc-11ea-944d-4b033640a974","roomTitle":"Help ABC with Credit","guestId":"Y2lzY29zcGFyazovL3VzL1BFT1BMRS9mNGZjNmFmZS1iY2Y0LTQwYjYtYTZiNy1jYmFkMmU3ODBmNDA","category":"Credit","mediaChannel":"web"},"trackingId":"93f3081d-2984-4bfd-9ea0-14d628763cdc","agentId":null,"contactDirection":{"type":"INBOUND"},"outboundType":null,"type":"ContactNew"}"""
      val message  = "Hello-world-" + i
      val key: Int = i % 3

      val partNo: Int = key match {
        case 0 | 1 => 2
        case 2     => 1
      }
      val record = new ProducerRecord[String, String](kafkaTopic, partNo, s"${key}", message)
      producer.send(record)
      val pairMessage   = message + "-Pair"
      val record1       = new ProducerRecord[String, String](kafkaTopic, s"${key}", pairMessage)
      val numPartitions = 3
      // Utils.abs(Utils.murmur2(key + "".getBytes())) % numPartitions

      log.info(s"Sent message Exp. Partition ${partNo} with key ${key}. Message: ${pairMessage}")
      producer.send(record1)
      Thread.sleep(1000)
    }
    producer.close()
  }
}
