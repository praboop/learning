import io.circe.syntax.EncoderOps
import model.{ PrabhuMessage, RoutingMessage }
import org.apache.kafka.clients.producer._
import org.slf4j.{ Logger, LoggerFactory }

import java.util.Properties

object StreamProducer {
  var log: Logger = LoggerFactory.getLogger("StreamerProducer")

  def main(args: Array[String]): Unit =
    writeToKafka("quickstart-events")

  def writeToKafka(topic: String): Unit = {
    val props = new Properties()
    props.put("bootstrap.servers", "192.168.29.196:9092")
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    val producer                = new KafkaProducer[String, String](props)
    val message: RoutingMessage = PrabhuMessage("READY", "test")
    val record                  = new ProducerRecord[String, String](topic, "Hello", message.asJson.toString())
    log.info("Sent message")
    producer.send(record)
    producer.close()
  }
}
