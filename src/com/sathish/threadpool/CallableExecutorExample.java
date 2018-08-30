package com.sathish.threadpool;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 
 * @author Sathish
 *
 */
public class CallableExecutorExample implements Callable<String> {

	@Override
	public String call() throws Exception {
		Thread.sleep(5000);
		// return the thread name executing this callable task
		return Thread.currentThread().getName();
	}

	public static void main(String args[]) {
		// Get ExecutorService from Executors utility class, thread pool size is 10
		ExecutorService executor = Executors.newFixedThreadPool(4);

		// create a list to hold the Future object associated with Callable
		List<Future<String>> taskList = new ArrayList<Future<String>>();

		// Create CallableExecutorExample instance
		Callable<String> callable = new CallableExecutorExample();
		for (int i = 0; i < 100; i++) {
			// submit Callable tasks to be executed by thread pool
			Future<String> future = executor.submit(callable);
			// add Future to the list, we can get return value using Future
			taskList.add(future);
		}
		for (Future<String> fut : taskList) {
			try {
				// print the return value of Future, notice the output delay in console
				// because Future.get() waits for task to get completed
				System.out.println(new Date() + ":" + fut.get());
			} catch (InterruptedException | ExecutionException e) {
				System.out.println("Exception in getting future objext");
				e.printStackTrace();
			}
		}
		// shut down the executor service now
		executor.shutdown();
	}

}
