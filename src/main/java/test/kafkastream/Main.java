package test.kafkastream;

import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.processor.TopologyBuilder;

public class Main {

	public static void main(String[] args) {
		Properties props = new Properties();
		props.put(StreamsConfig.APPLICATION_ID_CONFIG, "streams-wordcount-processor");
		//props.put(ConsumerConfig.GROUP_ID_CONFIG, "streams-wordcount-processor");
		
		props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.2.38:45983,192.168.2.112:45635,192.168.2.116:39571");
		//props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		
		props.put(StreamsConfig.KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
		props.put(StreamsConfig.VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
		//props.put(StreamsConfig.TIMESTAMP_EXTRACTOR_CLASS_CONFIG, MyEventTimeExtractor.class);

		
		// setting offset reset to earliest so that we can re-run the demo code
		// with the same pre-loaded data
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

		TopologyBuilder builder = new TopologyBuilder();

		builder.addSource("Source", "topic6");

		builder.addProcessor("Process", new ProcessMessage(), "Source");

		KafkaStreams streams = new KafkaStreams(builder, props);
		streams.start();
	}

}
