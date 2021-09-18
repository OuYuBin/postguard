package com.keliangtek.simulab.target.core.listeners;

import com.keliangtek.simulab.target.core.models.ISimulabTarget;

/**
 * 
 * @author robin
 *
 */
public interface ISimulabTargetLifeCycleListener {

	public void fireTargetAdd(ISimulabTarget simulabTarget);
	
	public void fireTargetRemove(ISimulabTarget simulabTarget);
	
	public void fireTargetActiveDevNode(ISimulabTarget simulabTarget);
	
	public void fireTargetChange(ISimulabTarget simulabTarget);
	
}
