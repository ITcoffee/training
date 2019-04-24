package com.zhouyun.training.multithreading;

/** 
 * 2个线程一个加1、一个减1，交替执行
 *
 * @author  周云
 * @version 2017年5月20日
 */
public class AddSubThread2 {

	public static void main(String[] args) {
		
		AddSubThread2 addSubThread2 = new AddSubThread2();
		Count count = addSubThread2.new Count();
		AddThread addThread = addSubThread2.new AddThread(count);
		SubThread subThread = addSubThread2.new SubThread(count);
		
		addThread.start();
		subThread.start();
	}
 
	private class Count {
		int i = 0;
		boolean flag = false;
	}
	
	private class AddThread extends Thread {
		
		Count count;
		
		public AddThread(Count count) {
			this.count = count;
		}
		
		@Override
		public void run() {
			while (true) {
				synchronized (count) {
					if (count.flag) {
						try {
							count.wait();
						} catch (Exception e) {
							
						}
					} else {
						count.i++;
						System.out.println(count.i);
						count.flag = true;
						count.notifyAll();
					}
				}
			}
		}
	}
	
	private class SubThread extends Thread {
		
		Count count;
		
		public SubThread(Count count) {
			this.count = count;
		}
		
		@Override
		public void run() {
			while (true) {
				synchronized (count) {
					if (!count.flag) {
						try {
							count.wait();
						} catch (Exception e) {
							
						}
					} else {
						count.i--;
						System.out.println(count.i);
						count.flag = false;
						count.notifyAll();
					}
				}
			}
		}
	}
	
}
