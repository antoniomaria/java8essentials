package essential.concurrency;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TaskRunner {

	ConcurrentMap<String, CounterTask> threadMap;
	private Counter counter;

	public static final int THREAD_COUNT = 200;
	public static final int OPERATIONS_EACH_THREAD = 10000;

	long startTime;

	TaskRunner(Counter counter) {
		this.counter = counter;
	}

	public void start() {
		// create threads
		threadMap = new ConcurrentHashMap<String, CounterTask>(THREAD_COUNT);
		for (int i = 0; i < THREAD_COUNT; i++) {
			CounterTask runner = new CounterTask(this, counter, OPERATIONS_EACH_THREAD);
			threadMap.put(runner.getName(), runner);
		}
		startTime = System.currentTimeMillis();
		Collection<CounterTask> threads = threadMap.values();
		for (Thread t : threads)
			t.start();
	}

	private void end() {
		long endTime = System.currentTimeMillis();
		System.out.println("all threads finished. Counter value is " + counter.getValue());
		long expected = THREAD_COUNT * OPERATIONS_EACH_THREAD;
		if (counter.getValue() == expected)
			System.out.println("Test successful.");
		else
			System.out.println("Test FAILED.");
		System.out.println("Execution lasted: " + (endTime - startTime) + " ms.");
	}

	public void notifyRunnerFinished(CounterTask aRunner) {
		threadMap.remove(aRunner.getName());
		if (threadMap.isEmpty())
			end();
	}
}
