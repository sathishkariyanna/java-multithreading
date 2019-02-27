package com.sathish.thread;

/**
 * 
 * @author Sathish
 *
 */
/*
 * changing the order of the locks prevent the program in going into a deadlock
 * situation
 */
public class DeadLockSolution {

	String resource1 = "Any resource1";
	String resource2 = "Any resource2";

	Thread td1 = new Thread("Thread 1") {
		public void run() {
			synchronized (resource1) {
				System.out.println("Thread 1: Holding resource 1...");

				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
				}
				System.out.println("Thread 1: Waiting for resource 2...");

				synchronized (resource2) {
					System.out.println("Thread 1: Holding resource 1 & 2...");
				}
			}
		}

	};

	Thread td2 = new Thread("Thread 2") {
		public void run() {
			synchronized (resource1) {
				System.out.println("Thread 2: Holding resource 1...");

				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
				}
				System.out.println("Thread 2: Waiting for resource 2...");

				synchronized (resource2) {
					System.out.println("Thread 2: Holding resource 1 & 2...");
				}
			}
		}
	};

	public static void main(String[] args) {
		DeadLockSolution ddl = new DeadLockSolution();
		ddl.td1.start();
		ddl.td2.start();

	}

}
