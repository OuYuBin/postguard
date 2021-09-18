package io.joy.post.flanker.target.ui.views.providers;

import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import com.keliangtek.simulab.target.core.SimulabTargetCore;
import com.keliangtek.simulab.target.core.models.ISimulabTarget;
import com.keliangtek.simulab.target.core.models.SimulabTargetTopology;

/**
 * 
 * @author robin
 *
 */
public class SimulabTargetTreeContentProvider implements ITreeContentProvider {

	@Override
	public void dispose() {

	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

	@Override
	public Object[] getElements(Object inputElement) {
		SimulabTargetTopology simulabTargetTopology = SimulabTargetCore
				.loadSimulabTargetTopology();
		if (simulabTargetTopology != null) {
			return new Object[] { simulabTargetTopology };
		}
		return new Object[0];
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof SimulabTargetTopology) {
			List<ISimulabTarget> targets = ((SimulabTargetTopology) parentElement)
					.getSimulabTargets();
			if (!targets.isEmpty()) {
				return targets.toArray(new ISimulabTarget[0]);
			}
		}
		return new Object[0];
	}

	@Override
	public Object getParent(Object element) {
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		return getChildren(element).length > 0;
	}

}
