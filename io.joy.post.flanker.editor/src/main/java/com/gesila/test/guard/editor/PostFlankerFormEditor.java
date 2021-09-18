package com.gesila.test.guard.editor;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.EventObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.part.FileEditorInput;

import com.gesila.test.guard.common.editor.IPostFlankerEditor;
import com.gesila.test.guard.common.listeners.manager.IGesilaTestGuardModelElementChangeListener;
import com.gesila.test.guard.common.listeners.manager.PostGuardModelElementManager;
import com.gesila.test.guard.editor.pages.PostFlankerApiDocFormPage;
import com.gesila.test.guard.editor.pages.PostFlankerFormPage;
import com.gesila.test.guard.editor.pages.PostGuardDescFormPage;
import com.gesila.test.guard.model.testGuard.TestGuard;

import io.joy.post.flanker.ui.views.property.GesilaTestGuardProperty;
import io.joy.post.flanker.ui.views.viewPage.GesilaTestGuardPage;
import io.joy.post.flanker.ui.views.viewPage.IGesilaTestGuardPage;

/**
 * 
 * 
 * @author robin
 *
 */
public class PostFlankerFormEditor extends FormEditor
		implements IPostFlankerEditor, IGesilaTestGuardModelElementChangeListener {

	private EditingDomain editingDomain;

	private Resource resource;

	@Override
	protected void createPages() {
		super.createPages();
	}

	public PostFlankerFormEditor() {
		PostGuardModelElementManager.getInstance().addGesilaTestGuardModelElementListener(this);
	}

	@Override
	public void testGuardModelElementChange() {

	}

	public void resourceChanged(IResourceChangeEvent event) {
		IResourceDelta delta = event.getDelta();
		delta = delta.findMember(new Path(this.getTitleToolTip()));
		if (delta == null)
			return;

		if (delta.getKind() == IResourceDelta.REMOVED) {
			if ((delta.getFlags() & IResourceDelta.MOVED_TO) != 0) {
				IPath newPath = delta.getMovedToPath();
				IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(newPath);
				this.setInput(new FileEditorInput(file));
				setPartName(newPath.lastSegment());
			}
		}
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {

			@Override
			protected void execute(IProgressMonitor monitor)
					throws org.eclipse.core.runtime.CoreException, InvocationTargetException, InterruptedException {
				List<Resource> resources = editingDomain.getResourceSet().getResources();
				Map<Object, Object> saveOptions = new HashMap<Object, Object>();
				saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED,
						Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
				resources.stream().forEach(resource -> {
					try {
						resource.save(saveOptions);
					} catch (IOException e) {
						e.printStackTrace();
					}
				});
			}
		};

		try {
			try {
				new ProgressMonitorDialog(getSite().getShell()).run(true, false, operation);
				((BasicCommandStack) editingDomain.getCommandStack()).saveIsDone();
				firePropertyChange(IEditorPart.PROP_DIRTY);
			} catch (InvocationTargetException | InterruptedException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doSaveAs() {

	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		super.init(site, input);
		// setSite(site);
		// setInput(input);
		setPartName(input.getName());
		initializedEditingDomain();
	}

	private void initializedEditingDomain() {
		CommandStack commandStack = new BasicCommandStack();
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		commandStack.addCommandStackListener(new CommandStackListener() {

			@Override
			public void commandStackChanged(EventObject event) {
				getContainer().getDisplay().asyncExec(new Runnable() {

					@Override
					public void run() {
						firePropertyChange(IEditorPart.PROP_DIRTY);
						// --同时对监视视图进行刷新
						if (gesilaTestGuardPage != null)
							gesilaTestGuardPage.refresh();
					}
				});

			}
		});
		editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack);
	}

	@Override
	public boolean isDirty() {
		return ((BasicCommandStack) editingDomain.getCommandStack()).isSaveNeeded();
	}

	@Override
	public boolean isSaveAsAllowed() {
		return true;
	}

	// @Override
	// public void createPartControl(Composite parent) {
	// Composite composite = new Composite(parent, SWT.BORDER);
	// GridLayout gridLayout = new GridLayout(5, false);
	// gridLayout.marginWidth = 5;
	// gridLayout.marginHeight = 5;
	// gridLayout.verticalSpacing = 0;
	// gridLayout.horizontalSpacing = 0;
	// composite.setLayout(gridLayout);
	//
	// Label label = new Label(composite, SWT.NONE);
	// label.setText("Request Method:");
	// label.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
	// Combo combo = new Combo(composite, SWT.NONE);
	// String[] requestMethods = new String[] { "GET", "POST" };
	// combo.setItems(requestMethods);
	// combo.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
	// combo.select(1);
	// Label urlLabel = new Label(composite, SWT.NONE);
	// urlLabel.setText("URL:");
	// urlLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
	// Text urlText = new Text(composite, SWT.BORDER);
	// urlText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
	//
	// Button sendButton = new Button(composite, SWT.BUTTON1);
	// sendButton.setText("Send");
	// sendButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
	// false));
	// Label reponseLabel = new Label(composite, SWT.NONE);
	// reponseLabel.setText("Response:");
	// reponseLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true,
	// false, 5,
	// 1));
	// Text responseText = new Text(composite, SWT.BORDER | SWT.MULTI |
	// SWT.READ_ONLY|SWT.WRAP);
	// responseText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true,
	// 5,
	// 1));
	//
	// sendButton.addSelectionListener(new SelectionListener() {
	//
	// @Override
	// public void widgetSelected(SelectionEvent e) {
	// try {
	// HttpClient httpClient = HttpClients.createDefault();
	// String url = urlText.getText();
	// HttpPost httpPost = new HttpPost(url);
	// httpPost.setEntity(new StringEntity("{\"_method\":\"GET\"}"));
	// HttpResponse response = httpClient.execute(httpPost);
	// HttpEntity entity = response.getEntity();
	// ByteArrayOutputStream outStream = new ByteArrayOutputStream();
	// byte[] data = new byte[4096];
	// int count = -1;
	// while ((count = entity.getContent().read(data, 0, 4096)) != -1)
	// outStream.write(data, 0, count);
	//
	// data = null;
	// responseText.setText(new String(outStream.toByteArray(), "UTF-8"));
	// } catch (ClientProtocolException e1) {
	// e1.printStackTrace();
	// } catch (IOException e1) {
	// e1.printStackTrace();
	// }
	// }
	//
	// @Override
	// public void widgetDefaultSelected(SelectionEvent e) {
	// // TODO Auto-generated method stub
	//
	// }
	// });
	//
	// }

	@Override
	protected void setPartName(String partName) {
		super.setPartName(partName);
	}

	@Override
	public void setFocus() {

	}

	@Override
	protected void addPages() {
		createModel();
		PostFlankerFormPage gesilaTestGuardFormPage = new PostFlankerFormPage(this, "GesilaTestGuardPage", "概览");
		//PostGuardDocFormPage postGuardAPIFormPage = new PostGuardDocFormPage(this, "PostGuardAPIFormPage", "文档");
		PostFlankerApiDocFormPage postFlankerApiDocFormPage=new PostFlankerApiDocFormPage(this, "PostFlankerApiDocFormPage", "文档");
		PostGuardDescFormPage postGuardDescFormPage = new PostGuardDescFormPage(this, "PostGuardDescFormPage", "简介");

		try {
			addPage(gesilaTestGuardFormPage);
			addPage(postFlankerApiDocFormPage);
			addPage(postGuardDescFormPage);
		} catch (PartInitException e) {
			e.printStackTrace();
		}
	}

	private void createModel() {
		URI resourceURI = EditUIUtil.getURI(getEditorInput(), editingDomain.getResourceSet().getURIConverter());
		resource = editingDomain.getResourceSet().getResource(resourceURI, true);
	}

	private IGesilaTestGuardPage gesilaTestGuardPage;

	public IGesilaTestGuardPage getTestGuardPage() {
		if (gesilaTestGuardPage == null)
			gesilaTestGuardPage = new GesilaTestGuardPage();
		return gesilaTestGuardPage;
	}

	public <T> T getAdapter(Class<T> adapter) {
		if (Resource.class == adapter) {
			return (T) resource;
		} else if (EditingDomain.class == adapter) {
			return (T) editingDomain;
		} else if (IGesilaTestGuardPage.class == adapter) {
			return (T) getTestGuardPage();
		} else if (GesilaTestGuardProperty.class == adapter) {
			return (T) getGesilaTestGuardProperty();
		}
		return super.getAdapter(adapter);
	}

	private <T> T getGesilaTestGuardProperty() {
		TestGuard testGuard = (TestGuard) this.resource.getContents().get(0);
		String methodName = testGuard.getMethod();
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(methodName);
		stringBuffer.append(" /");
		stringBuffer.append(" HTTP/1.1");
		stringBuffer.append("\n");
		stringBuffer.append("Host: " + testGuard.getUrl());
		GesilaTestGuardProperty gesilaTestGuardProperty = new GesilaTestGuardProperty();
		gesilaTestGuardProperty.setProperties(stringBuffer.toString());
		return (T) gesilaTestGuardProperty;
	}

}
