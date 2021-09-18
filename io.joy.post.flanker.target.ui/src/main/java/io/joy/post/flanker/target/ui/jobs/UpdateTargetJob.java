package io.joy.post.flanker.target.ui.jobs;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

import com.keliangtek.simulab.target.core.models.ISimulabTarget;
import com.keliangtek.simulab.target.core.models.SimulabTargetTopology;

/**
 * 
 * @author robin
 *
 */
public class UpdateTargetJob extends Job {

	// List<ISimulabTarget> simulabTargets=new ArrayList<ISimulabTarget>();

	SimulabTargetTopology simulabTargetTopology;

	public UpdateTargetJob(SimulabTargetTopology simulabTargetTopology) {
		super("获取环境信息");
		this.simulabTargetTopology = simulabTargetTopology;
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		if (simulabTargetTopology != null) {
			List<ISimulabTarget> simulabTargets = simulabTargetTopology
					.getSimulabTargets();
			if (!simulabTargets.isEmpty()) {
				for (ISimulabTarget simulabTarget : simulabTargets) {
					monitor.subTask(simulabTarget.getName());
				}
			}
		}
		return Status.OK_STATUS;
	}

}
