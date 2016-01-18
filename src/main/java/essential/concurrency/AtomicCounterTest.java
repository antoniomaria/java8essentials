package essential.concurrency;

public class AtomicCounterTest {
	public static void main(String a[]) {
		new TaskRunner(new AtomicCounter()).start();
	}
}
