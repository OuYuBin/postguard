package com.keliangtek.simulab.target.core.services;

/**
 * 
 * @author robin
 *
 */
public interface ITargetDetectService {
	
	public static final int TARGET_OFFLINE_CHECK_COUNT=10;

	public void detectRequest();
	
	public void detectResponse();
	
	
}
