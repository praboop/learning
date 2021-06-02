import sbt._
import Keys._

object Dependencies {

  val akka25Version      = "2.5.23"
  val akkaHttpVersion    = "10.0.10"
  val apacheSparkVersion = "1.6.1"
  val kafkaVersion       = "2.7.0"

  val akka25Actor     = "com.typesafe.akka" %% "akka-actor"           % akka25Version
  val akka25SLF4J     = "com.typesafe.akka" %% "akka-slf4j"           % akka25Version
  val akka25TestKit   = "com.typesafe.akka" %% "akka-testkit"         % akka25Version % Test
  val akkaStream      = "com.typesafe.akka" %% "akka-stream"          % akka25Version
  val akkaHttp        = "com.typesafe.akka" %% "akka-http"            % akkaHttpVersion
  val akkaHttpJson    = "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion
  val akkaHttpTestKit = "com.typesafe.akka" %% "akka-http-testkit"    % akkaHttpVersion % Test
  val typesafeConfig  = "com.typesafe"      % "config"                % "1.3.1"

  val akkaHttpSession = "com.softwaremill.akka-http-session" %% "core" % "0.3.0"

  val ciTokenUtil = "com.cisco.oauth2" % "oauth2-tokenutil" % "3.1.0"

  val bwXSD = "com.cisco.broadsoft" % "bwschema" % "23.0"

  val cassandraDriver = "com.datastax.cassandra" % "cassandra-driver-core" % "3.9.0"
  val cassandraUnit   = "org.cassandraunit"      % "cassandra-unit"        % "3.11.2.0" % Test

  val javaMail     = "com.sun.mail"       % "javax.mail"    % "1.6.1"
  val commonsCodec = "commons-codec"      % "commons-codec" % "1.10"
  val commonsLang3 = "org.apache.commons" % "commons-lang3" % "3.5"
  val commonsCsv   = "org.apache.commons" % "commons-csv"   % "1.4"
  val commonsNet   = "commons-net"        % "commons-net"   % "3.5"

  val commonValidator = "commons-validator" % "commons-validator" % "1.6"

  val csSDK    = "com.cisco.thunderhead" % "context-service-sdk"           % "2.0.5"
  val csSDKExt = "com.cisco.thunderhead" % "context-service-sdk-extension" % "2.0.6-SNAPSHOT" classifier "unsigned"

  val embeddedRedis = "eu.monniot.redis" % "embedded-redis" % "1.2.2" % Test

  val fasterXmlUUID = "com.fasterxml.uuid" % "java-uuid-generator" % "3.1.4"

  val jsonLens = "net.virtual-void" %% "json-lenses" % "0.6.2"
  val ficus    = "com.iheart"       %% "ficus"       % "1.4.3"

  val findbugs = "com.google.code.findbugs" % "jsr305" % "3.0.1"

  val gatling2Bundle = "io.gatling" % "gatling-bundle" % "2.3.0" artifacts Artifact("gatling-bundle",
                                                                                    "zip",
                                                                                    "zip",
                                                                                    "bundle")
  val gatling2Charts = "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.3.0"
  val gatling2TestFW = "io.gatling"            % "gatling-test-framework"    % "2.3.0"

  val gatlingBundle = "io.gatling" % "gatling-bundle" % "3.0.1.1" artifacts Artifact("gatling-bundle",
                                                                                     "zip",
                                                                                     "zip",
                                                                                     "bundle")
  val gatlingCharts = "io.gatling.highcharts" % "gatling-charts-highcharts" % "3.0.1.1"
  val gatlingTestFW = "io.gatling"            % "gatling-test-framework"    % "3.0.1.1"

  val guava = "com.google.guava" % "guava" % "25.1-jre"

  val hdrHistogram = "org.hdrhistogram" % "HdrHistogram" % "2.1.9"

  val javaWebsocket = "org.java-websocket" % "Java-WebSocket" % "1.5.1"

  val jedis   = "redis.clients" % "jedis"        % "2.9.0"
  val lettuce = "io.lettuce"    % "lettuce-core" % "5.3.0.RELEASE"

  val jerseyBundle = "com.sun.jersey" % "jersey-bundle" % "1.19.3"

  val jodaConvert = "org.joda"  % "joda-convert" % "1.8.1"
  val jodaTime    = "joda-time" % "joda-time"    % "2.9.7"

  val joseJWT         = "com.nimbusds"           % "nimbus-jose-jwt" % "7.7"
  val bouncyCastleKix = "org.bouncycastle"       % "bcpkix-jdk15on"  % "1.64"
  val bouncyCastleRov = "org.bouncycastle"       % "bcprov-jdk15on"  % "1.64"
  val jerichoHtml     = "net.htmlparser.jericho" % "jericho-html"    % "3.4"

  val specs2 = "org.specs2" %% "specs2" % "3.7" % Test

  val specs2Core    = "org.specs2" %% "specs2-core"    % "4.0.3" % Test
  val specs2Mockito = "org.specs2" %% "specs2-mock"    % "4.0.3" % Test
  val specs2Matcher = "org.specs2" %% "specs2-matcher" % "4.0.3" % Test

  val KMSSDK = "com.cisco.wx2" % "kms-sdk" % "2.0.60"

  val logbackClassic         = "ch.qos.logback"                   % "logback-classic"          % "1.2.3"
  val logbackLogstashEncoder = "net.logstash.logback"             % "logstash-logback-encoder" % "6.3"
  val jacksonCore            = "com.fasterxml.jackson.core"       % "jackson-core"             % "2.10.2"
  val jacksonDatabind        = "com.fasterxml.jackson.core"       % "jackson-databind"         % "2.10.2"
  val jacksonDataFormat      = "com.fasterxml.jackson.dataformat" % "jackson-dataformat-cbor"  % "2.10.2"
  val jacksonScalaModule     = "com.fasterxml.jackson.module"     %% "jackson-module-scala"    % "2.10.2"
  val jakartaWs              = "jakarta.ws.rs"                    % "jakarta.ws.rs-api"        % "2.1.5"
  val pagerDuty              = "com.squareup.pagerduty"           % "pagerduty-incidents"      % "1.1.1"

  val junit         = "junit"                  % "junit"                        % "4.12" % Test
  val scalaTest     = "org.scalatest"          %% "scalatest"                   % "3.0.1" % Test
  val scalaTestIt   = "org.scalatest"          %% "scalatest"                   % "3.0.1" % IntegrationTest
  val scalaTestMock = "org.scalamock"          %% "scalamock-scalatest-support" % "3.4.2" % Test
  val scalaXml      = "org.scala-lang.modules" %% "scala-xml"                   % "1.1.0"
  val specs2Mock    = "org.specs2"             %% "specs2-mock"                 % "3.8.6" % Test
  val mockitoAll    = "org.mockito"            % "mockito-all"                  % "1.10.19" % Test

  val scalaParserCombinator = "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.5"

  val scOpt       = "com.github.scopt" %% "scopt"       % "3.5.0"
  val slf4j       = "org.slf4j"        % "slf4j-api"    % "1.7.22"
  val slf4jSimple = "org.slf4j"        % "slf4j-simple" % "1.7.22"

  val statsDClient = "com.timgroup" % "java-statsd-client" % "3.1.0"

  val prometheusCllient = "io.prometheus" % "simpleclient"         % "0.8.1"
  val prometheusCommon  = "io.prometheus" % "simpleclient_common"  % "0.8.1"
  val prometheusJVM     = "io.prometheus" % "simpleclient_hotspot" % "0.8.1"
  val prometheusGuava   = "io.prometheus" % "simpleclient_guava"   % "0.8.1"
  val prometheusLogback = "io.prometheus" % "simpleclient_logback" % "0.8.1"

  val vaultDriver = "com.bettercloud" % "vault-java-driver" % "2.0.0"

  val prettyprint           = "com.lihaoyi"   %% "pprint"                 % "0.5.0" % Test
  val amazonKinesisClient   = "com.amazonaws" % "amazon-kinesis-client"   % "1.8.5"
  val amazonKinesisProducer = "com.amazonaws" % "amazon-kinesis-producer" % "0.12.5"
  val amazonKinesisSDK      = "com.amazonaws" % "aws-java-sdk-kinesis"    % "1.11.228"

  val rateLimitJ = "es.moki.ratelimitj" % "ratelimitj-inmemory" % "0.4.1"

  val apacheEmail = "org.apache.commons" % "commons-email" % "1.5"

  val uuid                = "com.eaio.uuid"             % "uuid"                  % "3.2"
  val analyzerCacheClient = "com.broadsoft.ccone"       % "analyzer-cache-client" % "2.1.0"
  val tamCommon           = "com.transerainc"           % "tam-common"            % "1.12"
  val tamXbindings        = "com.transerainc"           % "tam-common-xbbindings" % "1.3"
  val tideClient          = "com.transerainc"           % "tide-client"           % "8.1.0.1"
  val orgApacheClient     = "org.apache.httpcomponents" % "httpclient"            % "4.5.6"
  val orgApacheCommon     = "commons-io"                % "commons-io"            % "2.3"
  val hazelcast           = "com.hazelcast"             % "hazelcast"             % "3.9.1"
  val hazelcastClient     = "com.hazelcast"             % "hazelcast-client"      % "3.9.1"
  val apacheCollections   = "org.apache.commons"        % "commons-collections4"  % "4.1"

  val libRoutingModel = "com.cisco.ccc" %% "routing-model"    % "1.0-SNAPSHOT"
  val libCccCoreAkka  = "com.cisco.ccc" %% "ccc-core-akka"    % "1.0-SNAPSHOT"
  val libTestCore     = "com.cisco.ccc" %% "test-core"        % "1.0-SNAPSHOT" % Test classifier "tests"
  val libTestCoreIt   = "com.cisco.ccc" %% "test-core"        % "1.0-SNAPSHOT" % IntegrationTest classifier "tests"
  val stompClient     = "com.cisco.ccc" % "stomp-client_2.12" % "1.0-SNAPSHOT"

  val sttpCore      = "com.softwaremill.sttp" %% "core"       % "1.3.8"
  val sttpSprayJson = "com.softwaremill.sttp" %% "spray-json" % "1.3.8"

  val scalaj = "org.scalaj" %% "scalaj-http" % "2.4.1"

  val circeCore          = "io.circe"          %% "circe-core"           % "0.11.1"
  val circeGeneric       = "io.circe"          %% "circe-generic"        % "0.11.1"
  val circeParser        = "io.circe"          %% "circe-parser"         % "0.11.1"
  val circeShapes        = "io.circe"          %% "circe-shapes"         % "0.11.1"
  val circeGenericExtras = "io.circe"          %% "circe-generic-extras" % "0.11.1"
  val circeOptics        = "io.circe"          %% "circe-optics"         % "0.11.0"
  val akkaHttpCirce      = "de.heikoseeberger" %% "akka-http-circe"      % "1.25.2"

  val h2db = "com.h2database" % "h2" % "1.4.199"

  val play = "com.typesafe.play" %% "play-json" % "2.6.7"

  val xtract = "com.lucidchart" %% "xtract" % "2.0.0"

  val slick     = "com.typesafe.slick" %% "slick"          % "3.3.0"
  val slickTest = "com.typesafe.slick" %% "slick-testkit"  % "3.3.0" % "test"
  val junitTest = "com.novocode"       % "junit-interface" % "0.10" % "test"

  /**
    * Kakfa Dependencies
    */
  lazy val JakartaRs = Vector(
    ExclusionRule("javax.ws.rs", "javax.ws.rs-api")
  )
  val kafkaClients = "org.apache.kafka" % "kafka-clients"        % kafkaVersion withExclusions JakartaRs
  val kafkaStreams = "org.apache.kafka" %% "kafka-streams-scala" % kafkaVersion withExclusions JakartaRs

  /**
    * Kafka Test Dependencies
    */
  val embeddedKafka = "io.github.embeddedkafka" %% "embedded-kafka"          % kafkaVersion % "test"
  val ksTestUtil    = "org.apache.kafka"        % "kafka-streams-test-utils" % kafkaVersion % Test

  lazy val StunExclusions = Vector(
    ExclusionRule("net.java.stun4j", "stun4j")
  )

  val sipUnit = "org.mobicents.sipunit" % "sipunit" % "2.0.5" % Test withExclusions (StunExclusions)
  val dnsJava = "dnsjava"               % "dnsjava" % "2.1.9"

  val embeddedKafka220 = "io.github.embeddedkafka" %% "embedded-kafka" % "2.2.0" % Test

  val intermediateConfigReaderVersion = "com.cisco"     %% "configreader"  % "1.0-SNAPSHOT"
  val intermediateCccCoreAkkaVersion  = "com.cisco.ccc" %% "ccc-core-akka" % "1.0-SNAPSHOT"

  val xspTcpClientLib = "com.cisco.ccc" %% "xsp-tcp-client" % "1.0-SNAPSHOT"

  val scalaLogging  = "com.typesafe.scala-logging" %% "scala-logging"        % "3.9.2"
  val circeCore1    = "io.circe"                   %% "circe-core"           % "0.13.0"
  val circeGeneric1 = "io.circe"                   %% "circe-generic"        % "0.13.0"
  val circeParser1  = "io.circe"                   %% "circe-parser"         % "0.13.0"
  val circeExtra1   = "io.circe"                   %% "circe-generic-extras" % "0.13.0"

  val log4jSlf4j = "org.apache.logging.log4j" % "log4j-slf4j-impl" % "2.14.1"

  val log4jApi  = "org.apache.logging.log4j" % "log4j-api"  % "2.14.1"
  val log4jCore = "org.apache.logging.log4j" % "log4j-core" % "2.14.1"

//  val prodConsExample =
//    Seq(circeCore1, circeGeneric1, circeParser1, circeExtra1, kafkaClients, kafkaStreams, log4jEmbeddedKafka)

  val prodConsExample =
    Seq(logbackClassic, circeCore1, circeGeneric1, circeParser1, circeExtra1, kafkaClients, kafkaStreams)

  val cccCoreAkka = Seq(
    libraryDependencies ++= Seq(
      akka25Actor,
      scalaTest,
      scalaTestMock,
      scalaXml,
      mockitoAll,
      specs2Core,
      akkaStream,
      akkaHttp,
      akkaHttpJson,
      akkaHttpTestKit,
      kafkaClients,
      kafkaStreams,
      prometheusCllient,
      prometheusCommon,
      prometheusJVM,
      prometheusGuava,
      prometheusLogback,
      embeddedKafka,
      log4jEmbeddedKafka,
      guava,
      rateLimitJ,
      logbackClassic,
      logbackLogstashEncoder,
      jacksonScalaModule,
      jacksonCore,
      jacksonDatabind,
      commonsLang3,
      findbugs,
      statsDClient,
      joseJWT,
      jodaTime,
      jodaConvert,
      pagerDuty,
      commonsCodec,
      jedis,
      lettuce,
      embeddedRedis,
      tamCommon,
      tamXbindings,
      tideClient,
      circeCore,
      circeParser,
      intermediateConfigReaderVersion,
      ciTokenUtil
    )
  )

  val routingModel = Seq(
    libraryDependencies ++= Seq(
      scalaTest,
      scalaTestMock,
      scalaXml,
      kafkaStreams,
      jodaTime,
      jakartaWs,
      circeCore,
      circeGeneric,
      circeParser,
      circeShapes,
      circeGenericExtras
    ) // .map(_ exclude ("javax.ws.rs", "javax.ws.rs-api"))
  )

  val cccCoreAkkaWithoutLettuce = cccCoreAkka ++ Seq(libraryDependencies --= Seq(lettuce))

  val cccScheduler = Seq(
    libraryDependencies ++= Seq(
      akka25Actor,
      scalaTest,
      scalaTestMock,
      akkaStream,
      akkaHttp,
      akkaHttpJson,
      akkaHttpTestKit,
      kafkaClients,
      kafkaStreams,
      embeddedKafka,
      log4jEmbeddedKafka,
      logbackClassic,
      logbackLogstashEncoder,
      commonsLang3,
      findbugs,
      statsDClient,
      jodaTime,
      jodaConvert,
      pagerDuty,
      commonsCodec,
      embeddedRedis,
      cassandraDriver
    )
  )

  val config = Seq(
    libraryDependencies ++= Seq(
      akka25Actor,
      akka25SLF4J,
      akka25TestKit,
      akkaStream,
      akkaHttp,
      akkaHttpJson,
      akkaHttpTestKit,
      scalaTest,
      jodaTime,
      jodaConvert,
      joseJWT,
      bouncyCastleKix,
      bouncyCastleRov,
      KMSSDK,
      commonsCodec,
      cassandraDriver,
      cassandraUnit,
      jerseyBundle,
      hdrHistogram,
      kafkaClients,
      embeddedKafka,
      log4jEmbeddedKafka,
      specs2Mock,
      intermediateConfigReaderVersion
    )
  )

  val configReader = Seq(
    libraryDependencies ++= Seq(
      typesafeConfig,
      ficus,
      logbackClassic,
      commonsLang3,
      jsonLens,
      scalaTest,
      scalaTestMock,
      guava,
      vaultDriver,
      commonsCodec
    )
  )

  // Legacy version of log4j required for embeddedKafka
  val log4jEmbeddedKafka = "log4j" % "log4j" % "1.2.16" % Test

  val notifs = Seq(
    libraryDependencies ++= Seq(
      akka25Actor,
      akka25SLF4J,
      akka25TestKit,
      akkaStream,
      akkaHttp,
      akkaHttpJson,
      akkaHttpTestKit,
      mockitoAll,
      scalaTest,
      jodaTime,
      jodaConvert,
      jedis,
      lettuce,
      embeddedRedis,
      hdrHistogram,
      embeddedKafka,
      log4jEmbeddedKafka,
      intermediateConfigReaderVersion
    )
  )

  val qnr = Seq(
    libraryDependencies ++= Seq(
      akka25Actor,
      akka25SLF4J,
      akka25TestKit,
      akkaStream,
      akkaHttp,
      akkaHttpJson,
      akkaHttpTestKit,
      scalaTest,
      scalaTestMock,
      jodaTime,
      jodaConvert,
      cassandraDriver,
      cassandraUnit,
      embeddedRedis,
      mockitoAll,
      jerseyBundle,
      hdrHistogram,
      embeddedKafka,
      log4jEmbeddedKafka,
      intermediateConfigReaderVersion
    )
  )

  val flowcontrol = Seq(
    libraryDependencies ++= Seq(
      akka25Actor,
      akka25SLF4J % "compile",
      akka25TestKit,
      akkaStream,
      akkaHttp,
      akkaHttpJson,
      akkaHttpTestKit,
      scalaTest,
      scalaTestMock,
      scalaXml,
      jodaTime,
      jodaConvert,
      mockitoAll,
      kafkaStreams,
      akkaHttpCirce,
      ksTestUtil,
      libTestCore,
      ciTokenUtil
    ) // .map(_ exclude ("javax.ws.rs", "javax.ws.rs-api"))
  )

  val ur = Seq(
    libraryDependencies ++= Seq(
      akka25Actor,
      akka25SLF4J % "compile",
      akka25TestKit,
      akkaStream,
      akkaHttp,
      akkaHttpJson,
      akkaHttpTestKit,
      scalaTest,
      scalaTestMock,
      scalaXml,
      jodaTime,
      jodaConvert,
      mockitoAll,
      jerseyBundle,
      hdrHistogram,
      kafkaStreams,
      ksTestUtil,
      akkaHttpCirce,
      jakartaWs,
      ciTokenUtil
    ) // .map(_ exclude ("javax.ws.rs", "javax.ws.rs-api"))
  )

  val urFT = Seq(
    libraryDependencies ++= Seq(
      akka25Actor,
      akka25SLF4J % "compile, it",
      akkaHttp,
      akkaHttpJson,
      scalaTest,
      scalaTestMock,
      scalaTestIt,
      jodaTime,
      jodaConvert,
      mockitoAll,
      jerseyBundle,
      akkaHttpCirce,
      libCccCoreAkka,
      libRoutingModel,
      libTestCore,
      libTestCoreIt,
      ciTokenUtil
    ) // .map(_ exclude ("javax.ws.rs", "javax.ws.rs-api"))
  )

  val aqm = Seq(
    libraryDependencies ++= Seq(
      akka25Actor,
      akka25SLF4J % "compile, it",
      akka25TestKit,
      akkaHttp,
      scalaTest,
      scalaTestIt,
      scalaXml,
      jodaTime,
      akkaHttpTestKit,
      kafkaStreams,
      ksTestUtil,
      circeParser,
      akkaHttpCirce % "compile",
      slick,
      slickTest,
      junitTest,
      h2db,
      jakartaWs,
      circeOptics,
      xtract,
      play,
      mockitoAll,
      libTestCore,
      commonsCsv,
      ciTokenUtil,
      cassandraDriver
    ) // .map(_ exclude ("javax.ws.rs", "javax.ws.rs-api"))
  )

  val aqmFT = Seq(
    libraryDependencies ++= Seq(
      akka25Actor,
      akka25SLF4J % "compile, it",
      akkaHttp,
      akkaHttpJson,
      scalaTest,
      scalaTestMock,
      scalaTestIt,
      jodaTime,
      jodaConvert,
      mockitoAll,
      jerseyBundle,
      akkaHttpCirce,
      libCccCoreAkka,
      libRoutingModel,
      libTestCore,
      libTestCoreIt,
      ciTokenUtil
    )
  )

  val notifsFT = Seq(
    libraryDependencies ++= Seq(
      akka25Actor,
      akkaHttp,
      akkaHttpJson,
      scalaTest,
      scalaTestMock,
      scalaTestIt,
      jodaTime,
      jodaConvert,
      fasterXmlUUID,
      jerseyBundle,
      javaWebsocket,
      commonsNet,
      libTestCore,
      libTestCoreIt
    )
  )

  val sqmFT = Seq(
    libraryDependencies ++= Seq(
      akka25Actor,
      akka25SLF4J % "compile, it",
      akka25TestKit,
      akkaHttp,
      scalaTest,
      scalaTestIt,
      scalaXml,
      jodaTime,
      akkaHttpTestKit,
      kafkaStreams,
      ksTestUtil,
      circeParser,
      circeOptics,
      akkaHttpCirce % "compile, it",
      xtract,
      mockitoAll,
      libCccCoreAkka,
      libRoutingModel,
      libTestCore,
      libTestCoreIt,
      ciTokenUtil
    )
  )

  val reporterFT = Seq(
    libraryDependencies ++= Seq(
      akka25Actor,
      akka25SLF4J % "compile, it",
      akka25TestKit,
      akkaHttp,
      scalaTest,
      scalaTestIt,
      jodaTime,
      akkaHttpTestKit,
      kafkaStreams,
      ksTestUtil,
      circeParser,
      embeddedKafka,
      circeOptics,
      akkaHttpCirce,
      mockitoAll,
      libCccCoreAkka,
      libRoutingModel,
      libTestCore,
      libTestCoreIt
    )
  )

  val routingApi = Seq(
    libraryDependencies ++= Seq(
      akka25Actor,
      akka25SLF4J % "compile, it",
      akka25TestKit,
      akkaHttp,
      scalaTest,
      scalaTestIt,
      scalaXml,
      jodaTime,
      akkaHttpTestKit,
      kafkaStreams,
      ksTestUtil,
      circeParser,
      circeOptics,
      akkaHttpCirce % "compile, it",
      mockitoAll,
      libTestCore,
      libTestCoreIt,
      ciTokenUtil,
      cassandraDriver
    )
  )

  val routingApiFT = Seq(
    libraryDependencies ++= Seq(
      akka25Actor,
      akka25SLF4J % "compile, it",
      akka25TestKit,
      akkaHttp,
      scalaTest,
      scalaTestIt,
      scalaXml,
      jodaTime,
      akkaHttpTestKit,
      kafkaStreams,
      ksTestUtil,
      circeParser,
      circeOptics,
      akkaHttpCirce % "compile, it",
      mockitoAll,
      libCccCoreAkka,
      libRoutingModel,
      libTestCore,
      libTestCoreIt,
      ciTokenUtil,
      cassandraDriver
    )
  )

  def forIntegTest(itName: String): Seq[Def.Setting[Seq[ModuleID]]] =
    integTestMap.get(itName).getOrElse(Seq.empty)

  val integTestMap = Map("ur-ft" -> urFT,
                         "aqm-ft"         -> aqmFT,
                         "notifs-ft"      -> notifsFT,
                         "routing-api-ft" -> routingApiFT,
                         "reporter-ft"    -> reporterFT,
                         "sqm-ft"         -> sqmFT)

  val reporter = Seq(
    akka25Actor,
    akka25SLF4J % "compile, it",
    akka25TestKit,
    akkaHttp,
    scalaTest,
    scalaTestIt,
    jodaTime,
    akkaHttpTestKit,
    kafkaStreams,
    ksTestUtil,
    circeParser,
    embeddedKafka,
    circeOptics,
    akkaHttpCirce,
    mockitoAll,
    libTestCore,
    libTestCoreIt
  )

  val sqm = Seq(
    libraryDependencies ++= Seq(
      akka25Actor,
      akka25SLF4J % "compile, it",
      akka25TestKit,
      akkaHttp,
      scalaTest,
      scalaTestIt,
      scalaXml,
      jodaTime,
      akkaHttpTestKit,
      kafkaStreams,
      ksTestUtil,
      circeParser,
      circeOptics,
      akkaHttpCirce % "compile, it",
      xtract,
      mockitoAll,
      libTestCore,
      libTestCoreIt,
      ciTokenUtil
    )
  )

  val qma = Seq(
    libraryDependencies ++= Seq(
      akka25Actor,
      akka25SLF4J % "compile, it",
      akka25TestKit,
      akkaStream,
      akkaHttp,
      akkaHttpJson,
      akkaHttpTestKit,
      scalaTest,
      scalaTestIt,
      hdrHistogram,
      prettyprint,
      fasterXmlUUID,
      jacksonDataFormat,
      analyzerCacheClient,
      embeddedKafka,
      log4jEmbeddedKafka,
      embeddedRedis,
      vaultDriver,
      scalaXml,
      tamCommon,
      tamXbindings,
      tideClient,
      orgApacheClient,
      orgApacheCommon,
      hazelcast,
      hazelcastClient,
      apacheCollections,
      intermediateConfigReaderVersion,
      cassandraDriver
    )
  )

  val integTest = Seq(
    libraryDependencies ++= Seq(
      scalaTest,
      log4jEmbeddedKafka,
      slf4j,
      commonsLang3,
      commonsNet,
      csSDK,
      csSDKExt,
      jerseyBundle,
      javaWebsocket,
      scalaj,
      circeParser,
      akkaHttpCirce,
      akka25TestKit,
      akkaStream,
      akkaHttp,
      akkaHttpJson,
      akkaHttpTestKit,
      intermediateConfigReaderVersion,
      xspTcpClientLib
    )
  )

  val sparkJobServer = Seq(
    libraryDependencies ++= Seq(
      akka25Actor,
      akka25SLF4J,
      akkaHttp,
      akkaHttpJson,
      akkaHttpTestKit,
      logbackClassic,
      scalaTest,
      intermediateConfigReaderVersion
    )
  )

  val cjpCoreLoadConfigTool = Seq(
    libraryDependencies ++= Seq(
      akka25Actor,
      akka25SLF4J,
      akkaHttp,
      akkaHttpJson,
      akkaHttpTestKit,
      logbackClassic,
      scalaTest,
      commonValidator
    )
  )

  val cccProvisioning = Seq(
    libraryDependencies ++= Seq(
      akkaHttp,
      akkaHttpCirce,
      circeGenericExtras,
      scalaTest
    )
  )

  val agentSimulator = Seq(
    libraryDependencies ++= Seq(
      akka25Actor,
      akka25SLF4J,
      akkaStream,
      akkaHttp,
      akkaHttpJson,
      intermediateConfigReaderVersion
    )
  )

  val gatling_kafka_extension = Seq(
    libraryDependencies ++= Seq(
      gatling2Bundle,
      kafkaClients
    )
  )

  val loadr_old = Seq(
    libraryDependencies ++= Seq(
      akka25Actor,
      akka25SLF4J,
      akkaStream,
      akkaHttp,
      akkaHttpJson,
      akkaHttpTestKit,
      scalaTest,
      stompClient,
      jerseyBundle,
      fasterXmlUUID,
      jodaTime,
      jodaConvert,
      gatling2Charts,
      gatling2TestFW,
      gatling2Bundle,
      libRoutingModel,
      intermediateConfigReaderVersion
    )
  )

  val loadr = Seq(
    libraryDependencies ++= Seq(
      akka25Actor,
      akka25SLF4J,
      akkaStream,
      akkaHttp,
      akkaHttpJson,
      akkaHttpTestKit,
      scalaTest,
      jerseyBundle,
      kafkaStreams,
      fasterXmlUUID,
      jodaTime,
      jodaConvert,
      gatlingCharts,
      gatlingTestFW,
      gatlingBundle,
      akkaHttpCirce,
      embeddedKafka,
      log4jEmbeddedKafka,
      intermediateConfigReaderVersion,
      libRoutingModel
    ) // .map(_ exclude ("javax.ws.rs", "javax.ws.rs-api"))
  )

  val schemaMigrationTool = Seq(
    libraryDependencies ++= Seq(
      cassandraDriver,
      cassandraUnit,
      scalaTest,
      scalaTestMock,
      jodaTime,
      jodaConvert,
      fasterXmlUUID,
      scOpt
    )
  )

  val testCore = Seq(
    libraryDependencies ++= Seq(
      akka25Actor,
      akkaHttp,
      akkaHttpJson,
      scalaTest,
      fasterXmlUUID,
      logbackClassic,
      slf4j,
      javaMail,
      javaWebsocket,
      sipUnit,
      dnsJava,
      akkaHttpTestKit,
      joseJWT,
      intermediateCccCoreAkkaVersion exclude ("com.nimbusds", "nimbus-jose-jwt"),
      intermediateConfigReaderVersion exclude ("com.nimbusds", "nimbus-jose-jwt")
    )
  )

  val coreE2ETest = Seq(
    libraryDependencies ++= Seq(
      scalaTest,
      slf4j,
      commonsLang3,
      commonsNet,
      csSDK,
      csSDKExt,
      jerseyBundle,
      javaWebsocket,
      scalaj,
      circeParser,
      akkaHttpCirce,
      akka25TestKit,
      akkaStream,
      akkaHttp,
      akkaHttpJson,
      akkaHttpTestKit,
      libCccCoreAkka,
      libRoutingModel,
      libTestCore,
      xtract
    )
  )

  val fcJsonStore = Seq(
    libraryDependencies ++= Seq(
      scalaTest,
      slf4j,
      commonsLang3,
      commonsNet,
      csSDK,
      csSDKExt,
      jerseyBundle,
      javaWebsocket,
      scalaj,
      circeParser,
      akkaHttpCirce,
      akka25TestKit,
      akkaStream,
      akkaHttp,
      akkaHttpJson,
      akkaHttpTestKit,
      libCccCoreAkka,
      libRoutingModel,
      intermediateConfigReaderVersion,
      libTestCore,
      xtract
    )
  )

  val ftInfra = Seq(
    libraryDependencies ++= Seq(
      akka25Actor,
      akkaHttp,
      akkaHttpJson,
      jodaTime,
      jodaConvert,
      fasterXmlUUID,
      jerseyBundle,
      akka25SLF4J,
      logbackClassic,
      vaultDriver,
      libTestCore,
      ciTokenUtil,
      cassandraDriver
    )
  )

  val qnrFT = Seq(
    libraryDependencies ++= Seq(
      akka25Actor,
      akkaHttp,
      akkaHttpJson,
      scalaTest,
      jodaTime,
      jodaConvert,
      fasterXmlUUID,
      csSDK,
      csSDKExt,
      jerseyBundle,
      vaultDriver,
      sttpCore,
      sttpSprayJson,
      cassandraDriver
    )
  )

  val configFT = Seq(
    libraryDependencies ++= Seq(
      akka25Actor,
      akkaHttp,
      akkaHttpJson,
      scalaTest,
      jodaTime,
      jodaConvert,
      fasterXmlUUID,
      jerseyBundle,
      cassandraDriver
    )
  )

  val loadDriver = Seq(
    libraryDependencies ++= Seq(
      akka25Actor,
      akka25SLF4J,
      akka25TestKit,
      akkaStream,
      akkaHttp,
      akkaHttpJson,
      akkaHttpTestKit,
      scalaTest,
      scalaTestMock,
      gatlingCharts,
      gatlingTestFW,
      gatlingBundle,
      commonsNet
    )
  )
}
