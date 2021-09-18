package io.joy.post.flanker.target.ui.actions;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.SelectionListenerAction;

import com.keliangtek.simulab.target.core.SimulabTargetResourceManager;
import com.keliangtek.simulab.target.core.models.ISimulabTarget;

/**
 * 
 * @author robin
 *
 */
public class SimulabTargetDeleteAction extends SelectionListenerAction {

	ISelectionProvider selectionProvider;

	public SimulabTargetDeleteAction(String text,
			ISelectionProvider selectionProvider) {
		super(text);
		this.selectionProvider = selectionProvider;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		ISharedImages images = PlatformUI.getWorkbench().getSharedImages();
		return images.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE);
	}

	@Override
	public void run() {
		super.run();
		ISelection selection = selectionProvider.getSelection();
		if (selection instanceof IStructuredSelection) {
			Object object = ((IStructuredSelection) selection)
					.getFirstElement();
			if (object instanceof ISimulabTarget) {
				SimulabTargetResourceManager.getInstance().closeTarget(
						(ISimulabTarget) object);
				IResource resource = (IResource) ((ISimulabTarget) object)
						.getAdapter(IResource.class);
				try {
					if (resource.exists())
						resource.delete(true, new NullProgressMonitor());
					SimulabTargetResourceManager.getInstance().removeTarget(
							(ISimulabTarget) object);
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
