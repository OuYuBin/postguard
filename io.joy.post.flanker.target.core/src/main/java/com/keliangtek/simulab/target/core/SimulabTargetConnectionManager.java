package com.keliangtek.simulab.target.core;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/**
 * 目标机连接管理
 * 
 * @author robin
 *
 */
public class SimulabTargetConnectionManager {

	private static SimulabTargetConnectionManager INSTANCE = new SimulabTargetConnectionManager();

	private ScheduledExecutorService sendExecute;
	
	private ScheduledExecutorService receiveExecute;

	private SimulabTargetConnectionManager() {
		//--周期性发送任务
		sendExecute = Executors.newScheduledThreadPool(1, new ThreadFactory() {
			
			@Override
			public Thread newThread(Runnable runnable) {
				// TODO Auto-generated method stub
				Thread thread=new Thread(runnable);
				thread.setDaemon(true);
				return thread;
			}
		});
		//--周期性接收任务
		receiveExecute=Executors.newScheduledThreadPool(1, new ThreadFactory() {
			
			@Override
			public Thread newThread(Runnable runnable) {
				// TODO Auto-generated method stub
				Thread thread=new Thread(runnable);
				thread.setDaemon(true);
				return thread;
			}
		});
	}

	public ScheduledExecutorService getSendExecute() {
		return sendExecute;
	}

	public ScheduledExecutorService getReceiveExecute() {
		return receiveExecute;
	}

	public static SimulabTargetConnectionManager getInstance() {
		return INSTANCE;
	}
	
	
}
