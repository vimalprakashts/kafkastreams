# kafkastreams

```java
package test.kafkamesos;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.ByteArraySerializer;

public class Producer {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Map<String, Object> producerConfig = new HashMap<String, Object>();
		producerConfig.put("bootstrap.servers", "192.168.2.38:45983,192.168.2.112:45635,192.168.2.116:39571");
		//producerConfig.put("bootstrap.servers", "localhost:9092");
		
		// optional:
		producerConfig.put("metadata.fetch.timeout.ms", "3000");
		producerConfig.put("request.timeout.ms", "3000");
		// ... other options:
		// http://kafka.apache.org/documentation.html#producerconfigs
		ByteArraySerializer serializer = new ByteArraySerializer();
		KafkaProducer<byte[], byte[]> kafkaProducer = new KafkaProducer<byte[], byte[]>(producerConfig, serializer,
				serializer);

		int i = 0;
		while (true) {
			String message = "{data:success,g:" + i + "}";
			ProducerRecord<byte[], byte[]> record = new ProducerRecord<byte[], byte[]>("topic6", message.getBytes());
			kafkaProducer.send(record).get();
			System.out.println("sending " + message);
			Thread.sleep(1000);
			i++;
		}
	}
}

```
