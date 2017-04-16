package test.kafkastream;

import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.processor.ProcessorSupplier;

public class ProcessMessage implements ProcessorSupplier<String, String> {

	public Processor<String, String> get() {
		return new Processor<String, String>() {
			private ProcessorContext context;
			// private KeyValueStore<String, Integer> kvStore;

			public void init(ProcessorContext context) {
				this.context = context;
				// this.context.schedule(1000);
				// this.kvStore = (KeyValueStore<String, Integer>)
				// context.getStateStore("Counts");
			}

			public void process(String dummy, String line) {
				System.out.println(line);
				context.commit();
			}

			public void punctuate(long timestamp) {
				// try (KeyValueIterator<String, Integer> iter =
				// this.kvStore.all()) {
				// System.out.println("----------- " + timestamp + " -----------
				// ");
				//
				// while (iter.hasNext()) {
				// KeyValue<String, Integer> entry = iter.next();
				//
				// System.out.println("[" + entry.key + ", " + entry.value +
				// "]");
				//
				// context.forward(entry.key, entry.value.toString());
				// }
				// }
			}

			public void close() {
			}
		};
	}
}
