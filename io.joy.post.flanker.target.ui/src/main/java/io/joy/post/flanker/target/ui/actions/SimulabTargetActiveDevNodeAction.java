package io.joy.post.flanker.target.ui.actions;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.actions.SelectionListenerAction;

import com.keliangtek.simulab.target.core.SimulabTargetCore;
import com.keliangtek.simulab.target.core.models.ISimulabTarget;

import io.joy.post.flanker.target.ui.Activator;

/**
 * 
 * @author robin
 *
 */
public class SimulabTargetActiveDevNodeAction extends SelectionListenerAction {

	ISelectionProvider selectionProvider;

	public SimulabTargetActiveDevNodeAction(String text,
			ISelectionProvider selectionProvider) {
		super(text);
		this.selectionProvider = selectionProvider;
		this.setImageDescriptor(Activator
				.getImageDescriptor("icons/devTarget.gif"));
	}

	@Override
	public void run() {
		super.run();
		try {
			ISelection selection = selectionProvider.getSelection();
			if (selection instanceof IStructuredSelection) {
				Object object = ((IStructuredSelection) selection)
						.getFirstElement();
				if (object instanceof ISimulabTarget) {
					SimulabTargetCore.activeDevSimulabTarget((ISimulabTarget) object);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
