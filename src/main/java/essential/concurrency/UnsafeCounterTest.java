package essential.concurrency;

public class UnsafeCounterTest {
	public static void main(String a[]) {
		new TaskRunner(new UnsafeCounter()).start();
	}
}
