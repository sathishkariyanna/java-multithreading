package com.sathish.thread;

/**
 * 
 * @author sathish
 *
 */
/*
 * Deadlock describes a situation where two or more threads are blocked forever,
 * waiting for each other.
 * 
 */
public class DeadLockExample {

	String resource1 = "Any resource1";
	String resource2 = "Any resource2";

	Thread td1 = new Thread("Thread 1") {
		public void run() {
			int j = 0;
			while (true) {
				synchronized (resource1) {
					synchronized (resource2) {
						System.out.println(resource1 + "\t" + resource2 + "\t j:" + j++);
					}
				}
			}
		}
	};

	Thread td2 = new Thread("Thread 2") {
		public void run() {
			int i = 0;
			while (true) {
				synchronized (resource2) {
					synchronized (resource1) {
						System.out.println(resource2 + "\t" + resource1 + "\t i: " + i++);
					}
				}
			}
		}
	};

	public static void main(String[] args) {
		DeadLockExample ddl = new DeadLockExample();
		ddl.td1.start();
		ddl.td2.start();
	}
}
