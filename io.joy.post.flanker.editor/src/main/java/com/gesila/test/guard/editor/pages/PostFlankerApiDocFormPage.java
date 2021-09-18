package com.gesila.test.guard.editor.pages;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

import com.gesila.test.guard.editor.PostFlankerFormEditor;

/**
 * 
 * @author robin
 * 
 */
public class PostFlankerApiDocFormPage extends FormPage{

	PostFlankerFormEditor sysConfigFormPageEditor;

	PostFlankerApiDocMasterDetailsBlock sysConfigMasterDetailsBlock;

	public PostFlankerApiDocFormPage(FormEditor editor, String id, String title) {
		super(editor, id, title);
	}

	public PostFlankerApiDocFormPage(FormEditor sysConfigFormPageEditor) {
		this(sysConfigFormPageEditor, "postFlank", "API Doc");

	}

	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
	}

	@Override
	protected void createFormContent(IManagedForm managedForm) {
		ScrolledForm scrolledForm = managedForm.getForm();
		scrolledForm.setText("文档");
//		scrolledForm.setImage(Activator.getDefault().getImageRegistry()
//				.get("HostConfig"));
		FormToolkit formToolKit = managedForm.getToolkit();
		Form form = scrolledForm.getForm();
		formToolKit.decorateFormHeading(form);
//		form.getToolBarManager().add(
//				new SysConfigUploadAction("UploadAction", getEditor()));
//		form.getToolBarManager().add(
//				new SysConfigConvertAttrAction("ConvertAction"));
//		form.getToolBarManager().add(
//				new SysConfigConvertAttrAction("RunAction", getEditor()));

		form.getToolBarManager().update(true);
		sysConfigMasterDetailsBlock = new PostFlankerApiDocMasterDetailsBlock(this,
				getEditor());
		sysConfigMasterDetailsBlock.createContent(managedForm);
	}

	public PostFlankerApiDocMasterDetailsBlock getSysConfigMasterDetailsBlock() {
		return sysConfigMasterDetailsBlock;
	}

//	@Override
//	public TreeViewer getCurrentViewer() {
//		return sysConfigMasterDetailsBlock.getTreeViewer();
//	}

}
