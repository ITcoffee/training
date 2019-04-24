package com.zhouyun.training.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/** 
 * 线程池
 *
 * @author  周云
 * @version 2019年2月18日
 */
public class CustomThreadPoolExecutor {

	private ThreadPoolExecutor pool = null;
	
	/**
	 * 线程池初始化方法
	 * 
	 * corePoolSize 核心线程池大小
	 * maximumPoolSize 最大线程池大小
	 * keepAliveTime 线程池中超过corePoolSize数目的空闲线程最大存活时间
	 * TimeUnit keepAliveTime时间单位
	 * workQueue 阻塞队列
	 * threadFactory 新建线程工厂
	 * rejectedExecutionHandler 当提交任务数超过maxmumPoolSize+workQueue之和时,
	 * 							即当提交第maxmumPoolSize+workQueue+1个任务时,
	 * 						          任务会交给RejectedExecutionHandler来处理
	 */
	public void init(int corePoolSize, int maximumPoolSize, long keepAliveTime, int workQueueSize) {
		pool = new ThreadPoolExecutor(
				corePoolSize,
				maximumPoolSize,
				keepAliveTime,
				TimeUnit.SECONDS,
				new ArrayBlockingQueue<Runnable>(workQueueSize),
				new CustomThreadFactory(),  
                new CustomRejectedExecutionHandler());
	}
	
	public void destroy() {
		if (pool != null) {
			pool.shutdownNow();
		}
	}
	
	private class CustomThreadFactory implements ThreadFactory {  
		  
        private AtomicInteger count = new AtomicInteger(0);  
          
        @Override  
        public Thread newThread(Runnable r) {  
            Thread t = new Thread(r);  
            String threadName = CustomThreadPoolExecutor.class.getSimpleName() + count.addAndGet(1);  
            t.setName(threadName);  
            System.out.println(threadName);  
            return t;  
        }  
    }  
      
    private class CustomRejectedExecutionHandler implements RejectedExecutionHandler {  
  
        @Override  
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {  
        	try {
				executor.getQueue().put(r);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }  
    } 
	
	public ExecutorService getCustomThreadPoolExecutor() {
		return this.pool;
	}
	
	public static void main(String[] args) {
		CustomThreadPoolExecutor executor = new CustomThreadPoolExecutor();
		executor.init(10, 20, 60 * 60, 10);
		
		ExecutorService pool = executor.getCustomThreadPoolExecutor();
		for (int i = 0; i < 1000; i++) {
			System.out.println("第" + (i + 1) + "个线程！");
			final int j = i + 1;
			pool.execute(new Runnable() {
				
				@Override
				public void run() {
					System.out.println("test-" + j + "，threadName=" + Thread.currentThread().getName());
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
	
}
