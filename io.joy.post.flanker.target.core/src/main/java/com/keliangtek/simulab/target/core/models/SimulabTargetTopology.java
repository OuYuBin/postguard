package com.keliangtek.simulab.target.core.models;

import java.util.ArrayList;
import java.util.List;

/**
 * 拓扑结构
 * 
 * @author robin
 *
 */
public class SimulabTargetTopology {

	List<ISimulabTarget> simulabTargets = new ArrayList<ISimulabTarget>();

	public SimulabTargetTopology() {

	}

	public List<ISimulabTarget> getSimulabTargets() {
		return simulabTargets;
	}

	public void setSimulabTargets(List<ISimulabTarget> simulabTargets) {
		this.simulabTargets = simulabTargets;
	}

	public void addSimulabTarget(ISimulabTarget simulabTarget) {
		simulabTargets.add(simulabTarget);
	}

	public void removeSimulabTarget(ISimulabTarget simulabTarget) {
		simulabTargets.remove(simulabTarget);
	}

	public void acitveDevNodeSimulabTarget(ISimulabTarget simulabTarget) {
		simulabTargets.stream().forEach(target -> {
			if (target.getName().equals(simulabTarget.getName()))
				target.setDevTarget(true);
			else
				target.setDevTarget(false);
		});

	}

	public ISimulabTarget getSimulabTarget(String hostName) {
		return simulabTargets.stream()
				.filter(target -> target.getHost().equals(hostName)).count() == 0 ? null
				: (ISimulabTarget) simulabTargets.stream()
						.filter(target -> target.getHost().equals(hostName))
						.toArray()[0];
	}
}
