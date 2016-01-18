package essential.concurrency;

public class SynchronizedCounter implements Counter {
	private int value;
	private Object lock;

	public SynchronizedCounter() {
		value = 0;
		lock = new Object();
	}

	@Override
	public int getValue() {
		return value;
	}

	@Override
	public void increase() {
		synchronized (lock) {
			value++;
		}
	}
}
