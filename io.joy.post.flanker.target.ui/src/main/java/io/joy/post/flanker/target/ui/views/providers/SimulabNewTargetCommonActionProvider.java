package io.joy.post.flanker.target.ui.views.providers;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonMenuConstants;
import org.eclipse.ui.navigator.ICommonViewerWorkbenchSite;
import org.eclipse.ui.navigator.WizardActionGroup;


/**
 * 
 * @author robin
 *
 */
public class SimulabNewTargetCommonActionProvider extends CommonActionProvider {
	
	private static final String NEW_NMEU_NAME = "simulab.target.new.menu";
	
	private WizardActionGroup wizardActionGroup;

	public SimulabNewTargetCommonActionProvider() {
		
		
	}

	
	@Override
	public void init(ICommonActionExtensionSite aSite) {
		super.init(aSite);
		if (getActionSite().getViewSite() instanceof ICommonViewerWorkbenchSite) {
			IWorkbenchWindow window = ((ICommonViewerWorkbenchSite) getActionSite()
					.getViewSite()).getWorkbenchWindow();
			wizardActionGroup = new WizardActionGroup(window, PlatformUI
					.getWorkbench().getNewWizardRegistry(),
					WizardActionGroup.TYPE_NEW,
					getActionSite().getContentService());
		}
	}



	@Override
	public void fillContextMenu(IMenuManager menu) {
		super.fillContextMenu(menu);
		IMenuManager subMenu = new MenuManager("New", NEW_NMEU_NAME);
		wizardActionGroup.setContext(getContext());
		wizardActionGroup.fillContextMenu(subMenu);

		menu.insertAfter(ICommonMenuConstants.GROUP_NEW, subMenu);
	}

	
}
