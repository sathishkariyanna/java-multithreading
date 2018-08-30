package com.sathish.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.sathish.threadpool.service.RejectedExecutionHandlerImpl;
import com.sathish.threadpool.service.WorkerThread;

/**
 * 
 * @author Sathish
 *
 */
public class ThreadPoolExecutorExample {
	private static int MIN_POOL_SIZE = 2; // initial pool size
	private static int MAX_POOL_SIXE = 4;
	private static int BLOCKING_QUEUE_SIZE = 10;

	public static void main(String args[]) throws InterruptedException {
		// RejectedExecutionHandler implementation
		RejectedExecutionHandlerImpl rejectionHandler = new RejectedExecutionHandlerImpl();

		// creating the ThreadPoolExecutor
		// if we use RejectedExecutionHandler, then some waiting thread will go to
		// rejected status
		// ThreadPoolExecutor executorPool = new ThreadPoolExecutor(MIN_POOL_SIZE,
		// MAX_POOL_SIXE, BLOCKING_QUEUE_SIZE,
		// TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2), threadFactory,
		// rejectionHandler);
		ThreadPoolExecutor executorPool = new ThreadPoolExecutor(MIN_POOL_SIZE, MAX_POOL_SIXE, BLOCKING_QUEUE_SIZE,
				TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2), new ThreadPoolExecutor.CallerRunsPolicy());
		// submit work to the thread pool

		for (int i = 0; i < 10; i++) {
			executorPool.execute(new WorkerThread("cmd" + i));
		}

		Thread.sleep(30000);
		// shut down the pool
		executorPool.shutdown();
		while (!executorPool.isTerminated()) {
		}
		System.out.println("Finished all threads");

	}

}
