package com.keliangtek.simulab.target.core;

import java.util.List;

import com.keliangtek.simulab.target.core.models.ISimulabTarget;

/**
 * 控制目标机模型静态对象
 * 
 * @author robin
 *
 */
public class TargetCore {

	public static SimulabTargetResourceManager getResourceManager() {
		return SimulabTargetResourceManager.getInstance();
	}

	public static List<ISimulabTarget> loadSimulabTargets() {
		return getResourceManager().getTargets();
	}
}
