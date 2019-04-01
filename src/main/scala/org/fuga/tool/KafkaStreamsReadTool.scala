package org.fuga.tool

import java.util.{Properties, UUID}

import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.{KafkaStreams, StreamsBuilder, StreamsConfig, Topology}

object KafkaStreamsReadTool extends App {
  val config = {
    val properties = new Properties()
    properties.put(StreamsConfig.APPLICATION_ID_CONFIG, s"kafka-streams-${UUID.randomUUID()}")
    properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
    properties.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass)
    properties.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass)
    properties
  }
  val builder: StreamsBuilder = new StreamsBuilder()
  val sourceStream = builder.stream("test-event")
  sourceStream.to("test-event-copy")
  val topology: Topology = builder.build()

  val streams = new KafkaStreams(topology, config)
  streams.start()
}
