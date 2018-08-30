package com.sathish.thread;

/**
 * 
 * @author Sathish
 *
 */
class RunnableThread implements Runnable {
	private Thread t;
	private String threadName;

	RunnableThread(String name) {
		threadName = name;
		System.out.println("Creating " + threadName);
	}

	public void run() {
		try {
			for (int i = 0; i < 5; i++) {
				System.out.println("Thread: " + Thread.currentThread().getName() + ", " + i);
				// Let the thread sleep for a sec.
				Thread.sleep(1000);
				// Current thread yields to other thread
				Thread.yield();
			}
			// to get the thread priority
			System.out.println("Thread priority: " + Thread.currentThread().getPriority());

		} catch (InterruptedException e) {
			System.out.println("Thread " + Thread.currentThread().getName() + " interrupted.");
		}
		// to check the thread isAlive
		System.out.println(
				"Thread " + Thread.currentThread().getName() + " is alive " + Thread.currentThread().isAlive());
		System.out.println("Thread " + Thread.currentThread().getName() + " exiting.");
	}

	// this start method is optional, most of the we never use
	/*
	 * public void start() { System.out.println("Starting " + threadName); if (t ==
	 * null) { t = new Thread(this, threadName); t.start(); } }
	 */
}

public class ThreadOperationsExample {
	public static void main(String args[]) {
		Thread th1 = new Thread(new RunnableThread("Thread-1"));
		Thread th2 = new Thread(new RunnableThread("Thread-2"));
		Thread th3 = new Thread(new RunnableThread("Thread-3"));
		// to set the name for the thread
		th1.setName("Thread-1");
		th2.setName("Thread-2");
		th3.setName("Thread-3");

		// to set the thread priority // Default 5
		// if the processor is busy, then the priority 10 will be executed first
		th1.setPriority(10);
		th2.setPriority(1);
		th3.setPriority(6);

		th1.start();
		th3.start();

		try {
			th1.join();
			// we can also use some milliseconds time
			// th3.join(2000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		// th2 will not start until th1 is dead/completed
		// this can be used when something needs to be completed from the thread1, then
		// only thread2 should start
		th2.start();
	}

}
