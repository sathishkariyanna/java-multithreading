package com.sathish.thread;

/**
 * 
 * @author Sathish
 *
 */
class RunnableThreadExample implements Runnable {
	private Thread t;
	private String threadName;

	RunnableThreadExample(String name) {
		threadName = name;
		System.out.println("Creating " + threadName);
	}

	public void run() {
		try {
			for (int i = 0; i < 5; i++) {
				System.out.println("Thread: " + threadName + ", " + i);
				// Let the thread sleep for a sec.
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println("Thread " + threadName + " interrupted.");
		}
		System.out.println("Thread " + threadName + " exiting.");
	}

	// this start method is optional, most of the we never use
	public void start() {
		System.out.println("Starting " + threadName);
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}
}

public class ImplementsRunnableExample {
	public static void main(String args[]) {
		RunnableThreadExample R1 = new RunnableThreadExample("Thread-1");
		R1.start();

		RunnableThreadExample R2 = new RunnableThreadExample("Thread-2");
		R2.start();
	}

}
