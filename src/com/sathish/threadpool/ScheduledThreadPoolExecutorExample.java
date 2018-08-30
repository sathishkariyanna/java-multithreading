package com.sathish.threadpool;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author Sathish
 *
 */
public class ScheduledThreadPoolExecutorExample {
	public static void main(String[] args) {
		ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(5);

		Task task = new Task("Repeat Task");
		System.out.println("Created : " + task.getName());
		// scheduleWithFixedDelay(Runnable command, long initialDelay, long delay,
		// TimeUnit unit)
		executor.scheduleWithFixedDelay(task, 2, 2, TimeUnit.SECONDS);
	}
}

class Task implements Runnable {
	private String name;

	public Task(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void run() {
		System.out.println("Executing : " + name + ", Current Seconds : " + new Date().getSeconds());
	}
}
