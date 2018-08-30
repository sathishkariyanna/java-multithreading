package com.sathish.thread;

/**
 * 
 * @author Sathish
 *
 */
class ThreadExample extends Thread {
	private Thread t;
	private String threadName;

	/**
	 * 
	 * @param name
	 */
	ThreadExample(String name) {
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

	// The start method is optional, most of the time we never use
	public void start() {
		System.out.println("Starting " + threadName);
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}
}

public class ExtendThreadExample {

	public static void main(String args[]) {
		ThreadExample T1 = new ThreadExample("Thread-1");
		T1.start();

		ThreadExample T2 = new ThreadExample("Thread-2");
		T2.start();
	}
}