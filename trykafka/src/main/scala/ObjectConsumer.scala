import java.util

import org.apache.kafka.clients.consumer.KafkaConsumer
import java.util.Properties

import org.slf4j.LoggerFactory

import scala.util.{Failure, Try}
import org.slf4j.Logger

import scala.jdk.CollectionConverters._
import io.circe.generic.extras._
import io.circe.syntax._
import io.circe._
import io.circe.generic.semiauto.deriveDecoder
import io.circe.parser._
import model.{PrabhuMessage, RoutingMessage}

object ObjectConsumer {
    var log:Logger = LoggerFactory.getLogger("StreamerConsumer")

    def main(args: Array[String]): Unit = {
        log.info("Starting consumer")
        consumeFromKafka("quickstart-events")
    }



    implicit class LogTryNew[T](res: Try[T]) {

        def logFailure[T](result: Try[T], desc: String): Unit =
            result match {
                case Failure(ex) => log.error(s"$desc is a failure with ${ex.getMessage()}", ex)
                case _           => ()
            }

        def withFailureLogging(desc: String): Try[T] = {
            logFailure(res, desc)
            res
        }
    }

    private def deserializeTo[T](json: Json)(implicit decoder: Decoder[T]): T =
        json.as[T] match {
            case Right(decodedObj) => decodedObj
            case Left(err) =>
                throw new Exception("Unable to decode the json to an object", err)
        }

    private def processRoutingMessage(key: String, value: Json): Unit = {
        log.info(s" Processing routing message ${value.asJson.noSpaces}")
        (for {
            message <- Try(deserializeTo[RoutingMessage](value))
            _ = message.setTrackingInMdc()
            _ <- Try(reportingMessageHandler(message))
            _ = message.unSetTrackingInMdc()

        } yield ()).withFailureLogging(s"Processing routing message ")
    }

    private def reportingMessageHandler(message: RoutingMessage): Unit =
        message match {
            case p: PrabhuMessage =>
                log.info("Got the message: " + p.mediaType + "," + p.state + ", UID: " + p.trackingId)

            case _ => log.error("Not implemented for this type")
        }

    def consumeFromKafka(topic: String) = {
        val props = new Properties()
        props.put("bootstrap.servers", "localhost:9092")
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
        props.put("auto.offset.reset", "latest")
        props.put("group.id", "consumer-group2")
        val consumer: KafkaConsumer[String, String] = new KafkaConsumer[String, String](props)
                consumer.subscribe(util.Arrays.asList(topic))
        while (true) {
            val record = consumer.poll(1000).asScala
            for (data <- record.iterator) {
                log.info(("Got message: " + data.value()))
                parse(data.value()) match {
                    case Left(failure) => log.error("Unable to parse json")
                    case Right(json) => processRoutingMessage(data.key(), json)
                }

            }
        }
    }
}
