package io.joy.post.flanker.target.ui.actions;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.SelectionListenerAction;

import com.keliangtek.simulab.target.core.SimulabTargetResourceManager;
import com.keliangtek.simulab.target.core.models.ISimulabTarget;

/**
 * 
 * @author robin
 *
 */
public class SimulabTargetOpenAction extends SelectionListenerAction {

	ISelectionProvider selectionProvider;

	public SimulabTargetOpenAction(String text, ISelectionProvider selectionProvider) {
		super(text);
		this.selectionProvider = selectionProvider;
	}

	@Override
	public void run() {
		super.run();
		try {
			ISelection selection = selectionProvider.getSelection();
			if (selection instanceof IStructuredSelection) {
				Object object = ((IStructuredSelection) selection).getFirstElement();
				if (object instanceof ISimulabTarget) {
					SimulabTargetResourceManager.getInstance().openTarget((ISimulabTarget) object);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
