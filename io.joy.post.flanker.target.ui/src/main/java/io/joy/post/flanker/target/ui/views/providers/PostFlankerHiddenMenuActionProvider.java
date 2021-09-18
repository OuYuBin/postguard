package io.joy.post.flanker.target.ui.views.providers;

import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.navigator.CommonActionProvider;

/**
 * 
 * @author robin
 *
 */
public class PostFlankerHiddenMenuActionProvider extends CommonActionProvider {

	boolean initMenu = true;

	public PostFlankerHiddenMenuActionProvider() {
	}

	@Override
	public void fillContextMenu(IMenuManager menu) {
		super.fillContextMenu(menu);

		if (initMenu) {
			menu.addMenuListener(new IMenuListener() {
				public void menuAboutToShow(IMenuManager manager) {
					manager.remove("org.eclipse.debug.ui.contextualLaunch.run.submenu");
					manager.remove("org.eclipse.debug.ui.contextualLaunch.debug.submenu");
					manager.remove("org.eclipse.debug.ui.contextualLaunch.profile.submenu");
				}
			});

			initMenu = false;
		}
	}
}
