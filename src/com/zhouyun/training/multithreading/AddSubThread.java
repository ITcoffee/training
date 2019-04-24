package com.zhouyun.training.multithreading;

/** 
 * 2个线程一个加1、一个减1，共用同一把同步锁
 *
 * @author  周云
 * @version 2017年5月20日
 */
public class AddSubThread {

	private Integer count = 0;
	// 同步锁
	private Object lock = new Object();
	
	public static void main(String[] args) {

		AddSubThread addSubThread = new AddSubThread();
		
		for (int i = 0; i < 100; i++) {
			AddThread addThread = addSubThread.new AddThread();
			addThread.start();
		}
		for (int i = 0; i < 100; i++) {
			SubThread subThread = addSubThread.new SubThread();
			subThread.start();
		}
 	}
	
	// 加1线程
	private class AddThread extends Thread {
		
		@Override
		public void run() {
			synchronized (lock) {
				count++;
				System.out.println("add:" + count + ";");
			}
		}
		
	}
	
	// 减1线程
	private class SubThread extends Thread {
		
		@Override
		public void run() {
			synchronized (lock) {
				count--;
				System.out.println("sub:" + count + ";");
			}
		}
		
	}
	
}
