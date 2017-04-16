package test.kafkastream;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.streams.processor.TimestampExtractor;

public class MyEventTimeExtractor implements TimestampExtractor {

	  public long extract(final ConsumerRecord<Object, Object> record, final long previousTimestamp) {
	    // `Foo` is your own custom class, which we assume has a method that returns
	    // the embedded timestamp (milliseconds since midnight, January 1, 1970 UTC).
	    long timestamp = -1;
	    System.out.println(record.value());
//	    final Foo myPojo = (Foo) record.value();
//	    if (myPojo != null) {
//	      timestamp = myPojo.getTimestampInMillis();
//	    }
//	    if (timestamp < 0) {
//	      // Invalid timestamp!  Attempt to estimate a new timestamp,
//	      // otherwise fall back to wall-clock time (processing-time).
//	      if (previous >= 0) {
//	        return previous;
//	      } else {
	        return System.currentTimeMillis();
//	      }
//	    }
	  }

	@Override
	public long extract(ConsumerRecord<Object, Object> arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	}
