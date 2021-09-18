package com.gesila.test.guard.navigator.ui.views.actions;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.ui.actions.RenameResourceAction;

/**
 * 
 * @author robin
 *
 */
public class PostFlankerRenameAction extends RenameResourceAction {

	IPath newPath;

	public PostFlankerRenameAction(IShellProvider shellProvider) {
		super(shellProvider);
	}

	@Override
	public void run() {
		super.run();
	}

	protected String queryNewResourceName(final IResource resource) {
		return super.queryNewResourceName(resource);
	}
}
