package io.joy.post.flanker.target.ui.views.providers;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.CommonViewer;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonViewerSite;
import org.eclipse.ui.navigator.ICommonViewerWorkbenchSite;

import io.joy.post.flanker.target.ui.actions.SimulabTargetActiveDevNodeAction;

/**
 * 
 * @author robin
 *
 */
public class SimulabTargetActiveDevNodeCommonActionProvider extends
		CommonActionProvider {

	SimulabTargetActiveDevNodeAction simulabTargetActiveDevNodeAction;
	
	public SimulabTargetActiveDevNodeCommonActionProvider() {
	}

	@Override
	public void init(ICommonActionExtensionSite site) {
		super.init(site);
		ICommonViewerSite commonViewerSite = site.getViewSite();
		if (commonViewerSite instanceof ICommonViewerWorkbenchSite) {
			simulabTargetActiveDevNodeAction = new SimulabTargetActiveDevNodeAction("激活环境", commonViewerSite.getSelectionProvider());
			CommonViewer commonViewer = (CommonViewer) site.getStructuredViewer();
			commonViewer.addSelectionChangedListener(simulabTargetActiveDevNodeAction);
		}
	}
	
	public void fillContextMenu(IMenuManager menu) {
		super.fillContextMenu(menu);
		menu.add(simulabTargetActiveDevNodeAction);
	}
	
	

}
