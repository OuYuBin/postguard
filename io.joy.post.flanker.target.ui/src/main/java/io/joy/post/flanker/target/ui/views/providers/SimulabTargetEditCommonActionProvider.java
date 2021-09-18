package io.joy.post.flanker.target.ui.views.providers;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.CommonViewer;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonViewerSite;
import org.eclipse.ui.navigator.ICommonViewerWorkbenchSite;

import io.joy.post.flanker.target.ui.actions.SimulabTargetDeleteAction;

/**
 * 
 * @author robin
 *
 */
public class SimulabTargetEditCommonActionProvider extends CommonActionProvider {
	
	SimulabTargetDeleteAction deleteSimulabTargetAction;

	public SimulabTargetEditCommonActionProvider() {
	}

	@Override
	public void init(ICommonActionExtensionSite aSite) {
		super.init(aSite);
		ICommonViewerSite site = aSite.getViewSite();
		if( site instanceof ICommonViewerWorkbenchSite ) {
				deleteSimulabTargetAction=new SimulabTargetDeleteAction("删除",((ICommonViewerWorkbenchSite)site).getSelectionProvider());
		}
		
	}

	@Override
	public void fillContextMenu(IMenuManager menu) {
		super.fillContextMenu(menu);
		menu.add(deleteSimulabTargetAction);
	}

}
