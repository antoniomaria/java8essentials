package essential.concurrency;

public class SynchronizedCounterTest {
	public static void main(String a[]){
		new TaskRunner(new SynchronizedCounter()).start();
	}
}
