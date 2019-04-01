name := "nandemo-kafka-streams-scala"

version := "0.1"

scalaVersion := "2.12.8"

val KafkaStreamsVersion = "0.1.0"

libraryDependencies ++= Seq("com.lightbend" %% "kafka-streams-scala" % KafkaStreamsVersion)
