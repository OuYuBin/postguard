package com.keliangtek.simulab.target.core.models;

import org.eclipse.core.runtime.IAdaptable;

/**
 * 
 * @author robin
 *
 */
public interface ISimulabTarget extends IAdaptable {

	public String getName();

	public String getHost();
	
	public void setHost(String host);

	public boolean isDevTarget();

	public void setDevTarget(boolean isDevTarget);

	public void saveSimulabTarget();

	public String getPlatform();

	public void setPlatform(String platform);

	public int getNumberOfCPU();

	public void setNumberOfCPU(int numberOfCPU);

	public void setStatus(String status);

	public String getStatus();

	public int getStatusTimer();

	public void setStatusTimer(int statusTimer);
	
	public void accept(ISimulabTargetVistor simulabTargetVistor);
	
	public SimulabTargetInfomation getSimulabTargetInfomation();

	
	
}
