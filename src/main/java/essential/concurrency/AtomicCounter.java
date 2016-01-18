package essential.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter implements Counter {
	private AtomicInteger value;

	public AtomicCounter() {
		value = new AtomicInteger(0);
	}

	@Override
	public int getValue() {
		return value.get();
	}

	@Override
	public void increase() {
		value.incrementAndGet();
	}
}
