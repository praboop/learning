package model

import java.util.UUID


import io.circe.generic.extras._
import io.circe._
import io.circe.generic.semiauto._
import org.slf4j.MDC

object RoutingMessage {

  implicit val decodeFoo: Decoder[RoutingMessage] = deriveDecoder[RoutingMessage]
  val EventType                         = "eventType"

  val EventTypeField =
    Json.fromJsonObject(JsonObject((EventType, Json.fromString("RoutingMessage"))))

  implicit val rmEncoder: Encoder[RoutingMessage] = deriveEncoder[RoutingMessage]
    .mapJson(_.deepMerge(EventTypeField))
}

sealed trait RoutingMessage {
  val TrackingUUID                      = "TrackingUUID"

  def trackingId: UUID = UUID.randomUUID()

  def setTrackingInMdc() = {
    MDC.put(TrackingUUID, trackingId.toString)
  }

  def unSetTrackingInMdc() =
    Seq(TrackingUUID).foreach(MDC.remove)
}


case class PrabhuMessage(
                          state: String,
                          mediaType: String
                        ) extends RoutingMessage



//object PrabhuMessage{}
