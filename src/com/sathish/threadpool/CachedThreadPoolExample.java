package com.sathish.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.sathish.threadpool.service.WorkerThread;

/**
 * 
 * @author Sathish
 *
 */
/*
 * Cached thread pool executor – Creates a thread pool that creates new threads
 * as needed, but will reuse previously constructed threads when they are
 * available. DO NOT use this thread pool if tasks are long running. It can
 * bring down the system if number of threads goes beyond what system can handle
 */
public class CachedThreadPoolExample {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		for (int i = 0; i < 14; i++) {
			Runnable worker = new WorkerThread("" + i);
			executor.execute(worker);
		}
		executor.shutdown();
		// the below while will be completed once all the thread executions are
		// terminated
		while (!executor.isTerminated()) {
		}
		System.out.println("Finished all threads");
	}
}
