package com.sathish.thread;

/**
 * 
 * @author Sathish
 *
 */
public class ThreadNotifyWaitExample {

	public static void main(String[] args) {
		WorkerThread wt = new WorkerThread();
		wt.start();

		synchronized (wt) {
			try {
				System.out.println("Waiting for worker thread to complete...");
				wt.wait();
				// wt.wait(5000);//we can also have wait for these many milliseconds and
				// continue if the notify is not triggered by that time
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("Total is: " + wt.total);
		}
	}
}

class WorkerThread extends Thread {
	int total;

	@Override
	public void run() {
		synchronized (this) {
			for (int i = 0; i < 10; i++) {
				total += i;
			}
			notify();
		}
	}
}