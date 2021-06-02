import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.common.TopicPartition
import org.slf4j.{ Logger, LoggerFactory }

import java.time.Duration
import java.util.{ Date, Properties }
import java.{ lang, util }
import scala.jdk.CollectionConverters._
import scala.util.control._

object TopicJanitor {
  var log: Logger = LoggerFactory.getLogger("TopicJanitor")

  val kafkaHost: String  = "kafka:9092"
  val kafkaTopic: String = "ccc_agentnotifs"

  def main(args: Array[String]): Unit =
    cleanupTopic()

  def cleanupTopic(): Unit = {
    val props = new Properties()
    props.put("bootstrap.servers", kafkaHost)
    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    val consumer: KafkaConsumer[String, String]           = new KafkaConsumer[String, String](props)
    val partitions                                        = consumer.partitionsFor(kafkaTopic).asScala
    val topicPartitionsMap                                = partitions.map(data => new TopicPartition(kafkaTopic, data.partition())).asJava
    val endOffsetMap: util.Map[TopicPartition, lang.Long] = consumer.endOffsets(topicPartitionsMap)

    val DAY_IN_MS             = 1000 * 60 * 60 * 24
    val DAYS_OLDER_FROM_TODAY = 2

    log.info("Total partitions: " + partitions.size)

    val timestamp: java.lang.Long = new Date(System.currentTimeMillis - (DAYS_OLDER_FROM_TODAY * DAY_IN_MS)).getTime

    partitions.map { data =>
      val topicPartition          = new TopicPartition(kafkaTopic, data.partition())
      val (_, offsetAndTimestamp) = consumer.offsetsForTimes(Map(topicPartition -> timestamp).asJava).asScala.head

      log.info(s" offsetAndTimestamp $offsetAndTimestamp for partition ${topicPartition.partition()}")

      val offset: Long = if (offsetAndTimestamp == null) {
        endOffsetMap.get(topicPartition)
      } else {
        offsetAndTimestamp.offset()
      }
      val loop = new Breaks

      log.info(s"offset for partition ${topicPartition.partition()} offset $offset")
      val startOffset = 0L
      val endOffset   = offset
      consumer.assign(List(topicPartition).asJava)
      consumer.seek(topicPartition, startOffset)
      val records = consumer.poll(Duration.ofMillis(2000))
      loop.breakable {
        records.forEach { a =>
          if (a.offset() >= endOffset) {
            loop.break
          } else {
            log.info(s"producing record for key ${a.key()}")
            // producer.send(new ProducerRecord[String, String](kafkaTopic, a.key(), null))
          }
        }
      }
    }
  }
}
