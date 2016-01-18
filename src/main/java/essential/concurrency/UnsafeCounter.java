package essential.concurrency;

public class UnsafeCounter implements Counter {
	private int value;

	public UnsafeCounter() {
		value = 0;
	}

	@Override
	public int getValue() {
		return value;
	}

	@Override
	public void increase() {
		value++;
	}

}
