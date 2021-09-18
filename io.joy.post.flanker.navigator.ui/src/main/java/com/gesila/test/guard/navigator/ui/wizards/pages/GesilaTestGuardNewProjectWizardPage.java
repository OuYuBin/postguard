package com.gesila.test.guard.navigator.ui.wizards.pages;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;

import com.gesila.test.guard.navigator.ui.Activator;

/**
 * 
 * @author robin
 *
 */

public class GesilaTestGuardNewProjectWizardPage extends WizardNewProjectCreationPage {

	public GesilaTestGuardNewProjectWizardPage(String pageName) {
		super(pageName);
		setTitle("创建新的PostFlanker项目");
		setDescription("输入PostFlanker项目名称");
		setImageDescriptor(Activator.getDefault().getImageRegistry().getDescriptor("projectWizd"));
	}

	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
	}

}
