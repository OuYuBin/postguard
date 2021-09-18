package com.keliangtek.simulab.target.core;

import java.util.List;

import com.keliangtek.simulab.target.core.models.ISimulabTarget;
import com.keliangtek.simulab.target.core.models.SimulabTargetTopology;

/**
 * 控制目标机模型静态对象
 * 
 * @author robin
 *
 */
public class SimulabTargetCore {

	public static SimulabTargetResourceManager getResourceManager() {
		return SimulabTargetResourceManager.getInstance();
	}

	/**
	 * 初始配置获取(文本)
	 * 
	 * @return
	 */
	public static List<ISimulabTarget> loadSimulabTargets() {
		return getResourceManager().getTargets();
	}

	/**
	 * 拓扑结构获取(内存)
	 * 
	 * @return
	 */
	public static SimulabTargetTopology loadSimulabTargetTopology() {
		return getResourceManager().getSimulabTargetTopology();
	}
	
	public static void setHost(String targetName,String address) {
		getResourceManager().setHost(targetName,address);
	}
	

	public static void activeDevSimulabTarget(ISimulabTarget simulabTarget) {
		getResourceManager().activeDevNodeOfTarget(simulabTarget);
	}

	public static ISimulabTarget getSimulabTargetOfDev() {
		return getResourceManager().getSimulabTargetOfDev();
	}
	
	

}
