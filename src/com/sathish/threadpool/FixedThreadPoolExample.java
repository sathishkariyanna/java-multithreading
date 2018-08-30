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
 * Fixed thread pool executor – Creates a thread pool that reuses a fixed number
 * of threads to execute any number of tasks. If additional tasks are submitted
 * when all threads are active, they will wait in the queue until a thread is
 * available. It is best fit for most off the real-life usecases.
 */
public class FixedThreadPoolExample {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(4);
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
