package com.keliangtek.simulab.target.editor.pages;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import com.keliangtek.simulab.target.IP;
import com.keliangtek.simulab.target.Name;
import com.keliangtek.simulab.target.RootPath;
import com.keliangtek.simulab.target.Target;
import com.keliangtek.simulab.target.TargetFactory;
import com.keliangtek.simulab.target.TargetPackage;
import com.keliangtek.simulab.target.core.SimulabTargetCore;
import com.keliangtek.simulab.target.core.SimulabTargetResourceManager;
import com.keliangtek.simulab.target.core.listeners.ISimulabTargetLifeCycleListener;
import com.keliangtek.simulab.target.core.models.ISimulabTarget;
import com.keliangtek.simulab.target.editor.ISimulabCommonFormEditor;

/**
 * 
 * @author robin
 *
 */
public class SimulabTargetFormPage extends FormPage {

	private Target target;

	private Form form;

	boolean isEditPartClosed = false;

	private ISimulabTargetLifeCycleListener targetChangeLifeCycleListener;

	public SimulabTargetFormPage(FormEditor editor, String id, String title) {
		super(editor, id, title);
		ISimulabCommonFormEditor simulabCommonFormEditor = (ISimulabCommonFormEditor) getEditor();
		EditingDomain editingDomain = (EditingDomain) simulabCommonFormEditor.getAdapter(EditingDomain.class);
		Resource resource = editingDomain.getResourceSet().getResources().get(0);
		target = (Target) resource.getContents().get(0);
		addListeners();
	}

	private void addListeners() {
		targetChangeLifeCycleListener = new ISimulabTargetLifeCycleListener() {

			@Override
			public void fireTargetAdd(ISimulabTarget simulabTarget) {
			}

			@Override
			public void fireTargetRemove(ISimulabTarget simulabTarget) {
			}

			@Override
			public void fireTargetActiveDevNode(ISimulabTarget simulabTarget) {

			}

			@Override
			public synchronized void fireTargetChange(ISimulabTarget simulabTarget) {
				//refreshSimulabTarget(simulabTarget);
			}

		};
		SimulabTargetResourceManager.getInstance().addListener(targetChangeLifeCycleListener);

	}

	@Override
	protected void createFormContent(IManagedForm managedForm) {
		super.createFormContent(managedForm);
		FormToolkit formToolkit = managedForm.getToolkit();
		ScrolledForm scrolledForm = managedForm.getForm();
		scrolledForm.setText("目标环境 - " + target.getName().getContent());
		form = scrolledForm.getForm();
		form.setMessage("在线", IMessageProvider.INFORMATION);
		// form.setImage(TargetEditorPlugin.getPlugin().getImageRegistry()
		// .get("Server"));

		formToolkit.decorateFormHeading(form);
		GridLayout layout = new GridLayout();
		layout.verticalSpacing = 2;
		scrolledForm.getBody().setLayout(layout);
		// --基本信息
		createBaseInfoSection(scrolledForm.getBody(), formToolkit);
		// --服务信息
		createServiceInfoSection(scrolledForm.getBody(), formToolkit);

		// --发送请求信息
		Thread sendThread = new Thread() {
			// -主机信息获取状态位
			int status = 0;

//			SimulabDatagramSocketConnection simulabDatagramSocketConnection = SimulabDatagramManager
//					.getInstance().getSendSimulabDatagramSocketConnection();

			public synchronized void run() {
				// int count = 0;
				try {
					while (true) {
						// --守护连接对象销毁
						if (isEditPartClosed)
							break;
						String ip = target.getIP().getContent();
						if (!ip.equals("127.0.0.1")) {
//							byte[] bytes = new byte[6];
//							bytes[0] = Integer.valueOf(100).byteValue();
//							bytes[1] = Integer.valueOf(ip.split("\\.")[0])
//									.byteValue();
//							bytes[2] = Integer.valueOf(ip.split("\\.")[1])
//									.byteValue();
//							bytes[3] = Integer.valueOf(ip.split("\\.")[2])
//									.byteValue();
//							bytes[4] = Integer.valueOf(ip.split("\\.")[3])
//									.byteValue();
//							bytes[5] = new Byte(String.valueOf(status));
//							simulabDatagramSocketConnection
//									.doSend(SimulabSocketCommandRequestType.HEART_BEAT_REQUEST,
//											ip, bytes);
						}
						// count++;
						Thread.sleep(5);
					}
				}  catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		 sendThread.start();

	}

	private void createServiceInfoSection(Composite body, FormToolkit formToolkit) {
		Section targetSection = formToolkit.createSection(body, Section.TITLE_BAR | Section.EXPANDED);
		targetSection.setText("服务信息");

		targetSection.clientVerticalSpacing = 0;
		targetSection.marginHeight = 2;
		targetSection.marginWidth = 0;

		Composite client = formToolkit.createComposite(targetSection, SWT.WRAP);
		GridLayout gridLayout = new GridLayout(2, false);
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 2;
		// gridLayout.verticalSpacing = 0;
		// gridLayout.horizontalSpacing = 0;
		client.setLayout(gridLayout);

		Label label = new Label(client, SWT.LEFT);
		label.setText("域名称:");
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, false, false);
		gridData.widthHint = SWT.DEFAULT;
		gridData.heightHint = SWT.DEFAULT;
		label.setLayoutData(gridData);

		Text text = new Text(client, SWT.BORDER);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.widthHint = SWT.DEFAULT;
		gridData.heightHint = SWT.DEFAULT;
		text.setLayoutData(gridData);
		String domainName = target.getDomainName();
		text.setText(domainName == null ? "" : domainName);
		text.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent event) {
				Text domainText = (Text) event.getSource();
				if (StringUtils.equals(domainText.getText(), target.getDomainName())) {
					return;
				}
				EditingDomain editingDomain = getEditor().getAdapter(EditingDomain.class);
				EAttribute domainNameAttribute = TargetPackage.eINSTANCE.getTarget_DomainName();
				SetCommand setCommand = new SetCommand(editingDomain, target, domainNameAttribute,
						domainText.getText());
				editingDomain.getCommandStack().execute(setCommand);
			}
		});

		label = new Label(client, SWT.LEFT);
		label.setText("服务根路径:");
		gridData = new GridData(SWT.FILL, SWT.FILL, false, false);
		gridData.widthHint = SWT.DEFAULT;
		gridData.heightHint = SWT.DEFAULT;
		label.setLayoutData(gridData);

		text = new Text(client, SWT.BORDER);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.widthHint = SWT.DEFAULT;
		gridData.heightHint = SWT.DEFAULT;
		text.setLayoutData(gridData);
		text.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent event) {
				Text rootPathText = (Text) event.getSource();
				if (target.getRootPath() != null) {
					if (StringUtils.equals(rootPathText.getText(), target.getRootPath().getContent())) {
						return;
					}
				}

				EditingDomain editingDomain = getEditor().getAdapter(EditingDomain.class);
				EAttribute contentAttribute = TargetPackage.eINSTANCE.getRootPath_Content();
				RootPath rootPath = target.getRootPath();
				if (rootPath != null) {
					SetCommand setCommand = new SetCommand(editingDomain, target.getRootPath(), contentAttribute,
							rootPathText.getText());
					editingDomain.getCommandStack().execute(setCommand);
				} else {
					CompoundCommand compoundCommand = new CompoundCommand();
					rootPath = TargetFactory.eINSTANCE.createRootPath();
					SetCommand rootPathSetCommand = new SetCommand(editingDomain, target,
							TargetPackage.eINSTANCE.getTarget_RootPath(), rootPath);
					compoundCommand.append(rootPathSetCommand);
					SetCommand setCommand = new SetCommand(editingDomain, rootPath, contentAttribute,
							rootPathText.getText());
					compoundCommand.append(setCommand);
					editingDomain.getCommandStack().execute(compoundCommand);
				}
			}
		});

		RootPath rootPath = target.getRootPath();
		if (rootPath != null) {
			String value = rootPath.getContent();
			text.setText(value == null ? "" : value);
		}
		targetSection.setClient(client);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.widthHint = SWT.DEFAULT;
		gridData.heightHint = SWT.DEFAULT;
		targetSection.setLayoutData(gridData);

		label = new Label(client, SWT.LEFT);
		label.setText("服务端口:");
		gridData = new GridData(SWT.FILL, SWT.FILL, false, false);
		gridData.widthHint = SWT.DEFAULT;
		gridData.heightHint = SWT.DEFAULT;
		label.setLayoutData(gridData);

		text = new Text(client, SWT.BORDER);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.widthHint = SWT.DEFAULT;
		gridData.heightHint = SWT.DEFAULT;
		text.setLayoutData(gridData);
		String port = target.getPort();
		text.setText(port == null ? "" : port);
		text.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent event) {
				Text portText = (Text) event.getSource();
				if (StringUtils.equals(portText.getText(), target.getPort())) {
					return;
				}
				EditingDomain editingDomain = getEditor().getAdapter(EditingDomain.class);
				EAttribute portAttribute = TargetPackage.eINSTANCE.getTarget_Port();
				SetCommand setCommand = new SetCommand(editingDomain, target, portAttribute, portText.getText());
				editingDomain.getCommandStack().execute(setCommand);
			}
		});
		targetSection.setClient(client);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.widthHint = SWT.DEFAULT;
		gridData.heightHint = SWT.DEFAULT;
		targetSection.setLayoutData(gridData);
	}

	private void createBaseInfoSection(Composite body, FormToolkit formToolkit) {
		Section targetSection = formToolkit.createSection(body, Section.TITLE_BAR | Section.EXPANDED);
		targetSection.setText("基本信息");

		targetSection.clientVerticalSpacing = 0;
		targetSection.marginHeight = 2;
		targetSection.marginWidth = 0;

		Composite client = formToolkit.createComposite(targetSection, SWT.WRAP);
		GridLayout gridLayout = new GridLayout(2, false);
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 2;
		// gridLayout.verticalSpacing = 0;
		// gridLayout.horizontalSpacing = 0;
		client.setLayout(gridLayout);

		Label label = new Label(client, SWT.LEFT);
		label.setText("目标环境名称:");
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, false, false);
		gridData.widthHint = SWT.DEFAULT;
		gridData.heightHint = SWT.DEFAULT;
		label.setLayoutData(gridData);

		Text text = new Text(client, SWT.BORDER);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.widthHint = SWT.DEFAULT;
		gridData.heightHint = SWT.DEFAULT;
		text.setLayoutData(gridData);
		Name name = target.getName();
		if (name != null) {
			String value = name.getContent();
			text.setText(value == null ? "" : value);
		}
		text.setEditable(false);

		label = new Label(client, SWT.LEFT);
		label.setText("IP地址:");
		gridData = new GridData(SWT.FILL, SWT.FILL, false, false);
		gridData.widthHint = SWT.DEFAULT;
		gridData.heightHint = SWT.DEFAULT;
		label.setLayoutData(gridData);

		text = new Text(client, SWT.BORDER);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.widthHint = SWT.DEFAULT;
		gridData.heightHint = SWT.DEFAULT;
		text.setLayoutData(gridData);
		IP ip = target.getIP();
		if (ip != null) {
			String value = ip.getContent();
			text.setText(value == null ? "" : value);
		}
		text.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent event) {
				Text ipText = (Text) event.getSource();
				if (target.getIP() != null) {
					if (StringUtils.equals(ipText.getText(), target.getIP().getContent())) {
						return;
					}
				}

				EditingDomain editingDomain = getEditor().getAdapter(EditingDomain.class);
				EAttribute contentAttribute = TargetPackage.eINSTANCE.getIP_Content();
				IP ip = target.getIP();
				if (ip != null) {
					SetCommand setCommand = new SetCommand(editingDomain, ip, contentAttribute, ipText.getText());
					editingDomain.getCommandStack().execute(setCommand);
				} else {
					CompoundCommand compoundCommand = new CompoundCommand();
					ip = TargetFactory.eINSTANCE.createIP();
					SetCommand ipSetCommand = new SetCommand(editingDomain, target,
							TargetPackage.eINSTANCE.getTarget_IP(), ip);
					compoundCommand.append(ipSetCommand);
					SetCommand setCommand = new SetCommand(editingDomain, ip, contentAttribute, ipText.getText());
					compoundCommand.append(setCommand);
					editingDomain.getCommandStack().execute(compoundCommand);
				}
				SimulabTargetCore.setHost(target.getName().getContent(), ipText.getText());

			}
		});
		targetSection.setClient(client);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.widthHint = SWT.DEFAULT;
		gridData.heightHint = SWT.DEFAULT;
		targetSection.setLayoutData(gridData);
	}

//	public synchronized void refreshSimulabTarget(ISimulabTarget simulabTarget) {
//		Display.getDefault().asyncExec(new Runnable() {
//
//			@Override
//			public synchronized void run() {
//				if (simulabTarget.getHost().equals(target.getIP().getContent())) {
//					if (simulabTarget.getStatus().equals("0") && !form.isDisposed()
//							&& form.getMessage().equals("Online")) {
//						if (!form.isDisposed()) {
//							form.setMessage("Offline", IMessageProvider.ERROR);
//						}
//					} else if (simulabTarget.getStatus().equals("1") && !form.isDisposed()
//							&& form.getMessage().equals("Offline")) {
//						if (!form.isDisposed()) {
//							form.setMessage("Online", IMessageProvider.NONE);
//						}
//					}
//				}
//			}
//		});
//	}

	@Override
	public void dispose() {
		super.dispose();
	}

	public void clear() {
		isEditPartClosed = true;
		SimulabTargetResourceManager.getInstance().removeListener(targetChangeLifeCycleListener);

	}

}
