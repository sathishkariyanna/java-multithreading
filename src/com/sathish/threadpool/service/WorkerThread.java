package com.sathish.threadpool.service;

import java.util.Date;

/**
 * 
 * @author Sathish
 *
 */
public class WorkerThread implements Runnable {

	private String thNumber;

	public WorkerThread(String s) {
		this.thNumber = s;
	}

	@Override
	public void run() {
		System.out.println(new Date() + "\t" + Thread.currentThread().getName() + " Start..." + thNumber);
		processBusinessLogic();
		System.out.println(new Date() + "\t" + Thread.currentThread().getName() + " End.");
	}

	private void processBusinessLogic() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return this.thNumber;
	}
}
