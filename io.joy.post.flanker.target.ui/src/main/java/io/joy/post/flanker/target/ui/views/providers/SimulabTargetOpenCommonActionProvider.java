package io.joy.post.flanker.target.ui.views.providers;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.CommonViewer;
import org.eclipse.ui.navigator.ICommonActionConstants;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonViewerSite;
import org.eclipse.ui.navigator.ICommonViewerWorkbenchSite;

import io.joy.post.flanker.target.ui.actions.SimulabTargetOpenAction;

/**
 * 
 * @author robin
 *
 */
public class SimulabTargetOpenCommonActionProvider extends CommonActionProvider {

	SimulabTargetOpenAction simulabTargetOpenAction;

	public SimulabTargetOpenCommonActionProvider() {
	}

	@Override
	public void init(ICommonActionExtensionSite site) {
		super.init(site);
		ICommonViewerSite commonViewerSite = site.getViewSite();
		if (commonViewerSite instanceof ICommonViewerWorkbenchSite) {
			IWorkbenchWindow workbenchWindow = ((ICommonViewerWorkbenchSite) commonViewerSite).getWorkbenchWindow();
			simulabTargetOpenAction = new SimulabTargetOpenAction("Open", commonViewerSite.getSelectionProvider());
			CommonViewer commonViewer = (CommonViewer) site.getStructuredViewer();
			commonViewer.addSelectionChangedListener(simulabTargetOpenAction);

		}
	}

	@Override
	public void fillContextMenu(IMenuManager menu) {
		super.fillContextMenu(menu);
		menu.add(new Separator());
		menu.appendToGroup("group.new", simulabTargetOpenAction);

	}

	@Override
	public void fillActionBars(IActionBars actionBars) {
		super.fillActionBars(actionBars);
		actionBars.setGlobalActionHandler(ICommonActionConstants.OPEN, simulabTargetOpenAction);
	}

}
