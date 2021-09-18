package com.keliangtek.simulab.target.core.models;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.keliangtek.simulab.target.core.SimulabTargetResourceManager;

/**
 * 目标机对象
 * 
 * @author robin
 *
 */
public class SimulabTarget extends AbstractSimulabTarget {

	private Logger logger = LoggerFactory.getLogger(SimulabTarget.class);

	/**
	 * 名称
	 */
	String name;

	/**
	 * ip地址
	 */
	String host;

	/**
	 * 是否为开发节点
	 */
	boolean isDevTarget;

	/**
	 * 平台
	 */
	String platform;

	/**
	 * cpu核数
	 */
	int numberOfCPU;

	/**
	 * 下位机状态
	 */
	String status;

	/**
	 * 下位机资源信息
	 */
	SimulabTargetInfomation simulabTargetInfomation;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public void saveSimulabTarget() {
		SimulabTargetResourceManager.getInstance().addTarget(this);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isDevTarget() {
		return isDevTarget;
	}

	public void setDevTarget(boolean isDevTarget) {
		this.isDevTarget = isDevTarget;
	}

	@Override
	public void accept(ISimulabTargetVistor simulabTargetVistor) {
		simulabTargetVistor.vist(this);
	}

	public int getNumberOfCPU() {
		return numberOfCPU;
	}

	public void setNumberOfCPU(int numberOfCPU) {
		this.numberOfCPU = numberOfCPU;
	}

	public SimulabTargetInfomation getSimulabTargetInfomation() {
		return simulabTargetInfomation;
	}

	public void setSimulabTargetInfomation(SimulabTargetInfomation simulabTargetInfomation) {
		this.simulabTargetInfomation = simulabTargetInfomation;
	}

	public Object getAdapter(Class adapter) {
		if (adapter.equals(IResource.class)) {
			IProject targetsProject = ResourcesPlugin.getWorkspace().getRoot().getProject("Targets");
			logger.info(targetsProject.getProject().getFullPath().toOSString());
			return targetsProject.getFile(getName() + ".tfg");
		}
		return super.getAdapter(adapter);
	}
}
