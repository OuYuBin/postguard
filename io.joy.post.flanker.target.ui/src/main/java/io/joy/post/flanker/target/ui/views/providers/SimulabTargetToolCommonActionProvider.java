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
public class SimulabTargetToolCommonActionProvider extends CommonActionProvider {

	private static final String TOOL_NMEU_NAME = "simulab.target.tools.menu";
	
	private WizardActionGroup wizardActionGroup;
	
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
		IMenuManager subMenu = new MenuManager("Tools", TOOL_NMEU_NAME);
		wizardActionGroup.setContext(getContext());
		wizardActionGroup.fillContextMenu(subMenu);
		
		menu.insertAfter(ICommonMenuConstants.GROUP_EDIT, subMenu);
	}

}
