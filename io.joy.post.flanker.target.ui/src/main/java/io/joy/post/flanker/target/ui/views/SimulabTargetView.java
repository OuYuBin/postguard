package io.joy.post.flanker.target.ui.views;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Link;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.part.PageBook;

import com.keliangtek.simulab.target.IP;
import com.keliangtek.simulab.target.Name;
import com.keliangtek.simulab.target.Target;
import com.keliangtek.simulab.target.TargetPackage;
import com.keliangtek.simulab.target.core.SimulabTargetCore;
import com.keliangtek.simulab.target.core.SimulabTargetResourceManager;
import com.keliangtek.simulab.target.core.listeners.ISimulabTargetLifeCycleListener;
import com.keliangtek.simulab.target.core.models.ISimulabTarget;
import com.keliangtek.simulab.target.core.models.SimulabTarget;
import com.keliangtek.simulab.target.util.TargetResourceImpl;

import io.joy.post.flanker.target.ui.dialogs.SimulabNewTargetDialog;
import io.joy.post.flanker.target.ui.jobs.UpdateTargetJob;

/**
 * 环境视图
 * 
 * @author robin
 *
 */

public class SimulabTargetView extends CommonNavigator {

	public static final String ID = "com.keliangtek.simulab.target.ui.views.SimulabTargetView";

	public TreeViewer simulabTargetTreeViewer;

	public PageBook pageBook;

	public Control targetControl;

	public Control noTargetControl;

	private ISimulabTargetLifeCycleListener targetChangeLifeCycleListener;

	public static final String TARGET_FILE_EXTENSION = ".tfg";

	public SimulabTargetView() {
	}

	public void createPartControl(Composite parent) {
		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		gridLayout.verticalSpacing = 1;
		gridLayout.horizontalSpacing = 0;
		parent.setLayout(gridLayout);
		FormToolkit formToolKit = new FormToolkit(parent.getDisplay());
		Form form = formToolKit.createForm(parent);
		form.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		form.setText("环境");
		formToolKit.decorateFormHeading(form);
		Composite body = form.getBody();
		GridLayout layout = new GridLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		body.setLayout(layout);
		pageBook = new PageBook(body, SWT.NONE);
		pageBook.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		super.createPartControl(pageBook);

		targetControl = getCommonViewer().getControl();
		noTargetControl = createNoTargetControl(formToolKit, pageBook);
		pageBook.showPage(noTargetControl);

		deferInitialization();

	}

	private void deferInitialization() {
		addListeners();
		Display.getDefault().asyncExec(new Runnable() {

			@Override
			public void run() {
				simulabTargetTreeViewer = getCommonViewer();
				getSite().setSelectionProvider(simulabTargetTreeViewer);
				deferinitialize();
			}
		});

	}

	private void addListeners() {
		targetChangeLifeCycleListener = new ISimulabTargetLifeCycleListener() {

			@Override
			public void fireTargetAdd(ISimulabTarget simulabTarget) {
				addTarget(simulabTarget);
			}

			@Override
			public void fireTargetRemove(ISimulabTarget simulabTarget) {
				removeTarget(simulabTarget);
			}

			@Override
			public void fireTargetActiveDevNode(ISimulabTarget simulabTarget) {
				activeDevNodeTarget(simulabTarget);

			}

			@Override
			public void fireTargetChange(ISimulabTarget simulabTarget) {
				targetChange(simulabTarget);

			}

		};
		SimulabTargetResourceManager.getInstance().addListener(targetChangeLifeCycleListener);

	}

	private void targetChange(ISimulabTarget simulabTarget) {
		Display.getDefault().asyncExec(new Runnable() {

			@Override
			public void run() {
				if (!simulabTargetTreeViewer.getControl().isDisposed())
					simulabTargetTreeViewer.refresh();
			}

		});

	}

	protected void activeDevNodeTarget(ISimulabTarget simulabTarget) {
		Display.getDefault().asyncExec(new Runnable() {

			@Override
			public void run() {
				SimulabTargetResourceManager.getInstance().getSimulabTargetTopology()
						.acitveDevNodeSimulabTarget(simulabTarget);
				simulabTargetTreeViewer.refresh();
				togglePage();
			}

		});
	}

	private void removeTarget(ISimulabTarget simulabTarget) {
		Display.getDefault().asyncExec(new Runnable() {

			@Override
			public void run() {
				SimulabTargetResourceManager.getInstance().getSimulabTargetTopology()
						.removeSimulabTarget(simulabTarget);
				simulabTargetTreeViewer.refresh();
				togglePage();
			}

		});

	}

	private void addTarget(ISimulabTarget simulabTarget) {
		Display.getDefault().asyncExec(new Runnable() {

			@Override
			public void run() {
				SimulabTargetResourceManager.getInstance().getSimulabTargetTopology().addSimulabTarget(simulabTarget);
				simulabTargetTreeViewer.refresh();
				togglePage();
			}

		});
	}

	private void deferinitialize() {
		UpdateTargetJob updateTargetJob = new UpdateTargetJob(SimulabTargetCore.loadSimulabTargetTopology());
		updateTargetJob.addJobChangeListener(new JobChangeAdapter() {

			@Override
			public void done(IJobChangeEvent event) {
				super.done(event);
				Display.getDefault().asyncExec(new Runnable() {

					@Override
					public void run() {
						togglePage();
					}
				});
			}

		});
		updateTargetJob.schedule();
	}

	private void togglePage() {
		if (simulabTargetTreeViewer.getTree().getItem(0).getItemCount() > 0) {
			simulabTargetTreeViewer.expandToLevel(2);
			pageBook.showPage(targetControl);
		} else {
			pageBook.showPage(noTargetControl);
		}

	}

	private Composite createNoTargetControl(FormToolkit formToolKit, PageBook pageBook) {
		Composite compsite = formToolKit.createComposite(pageBook);
		GridLayout gridLayout = new GridLayout();
		compsite.setLayout(gridLayout);

		Link link = new Link(compsite, SWT.NONE);
		link.setText("<a>暂无有效环境配置信息,点击链接创建新的环境...</a>");
		link.setBackground(pageBook.getDisplay().getSystemColor(SWT.COLOR_LIST_BACKGROUND));
		GridData gridData = new GridData(SWT.LEFT, SWT.FILL, true, false);
		gridData.widthHint = SWT.DEFAULT;
		gridData.heightHint = SWT.DEFAULT;
		link.setLayoutData(gridData);
		link.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				SimulabNewTargetDialog simulabNewTargetDialog = new SimulabNewTargetDialog(
						event.display.getActiveShell());
				if (simulabNewTargetDialog.open() == Window.OK) {
					String name = simulabNewTargetDialog.getName();
					String host = simulabNewTargetDialog.getHost();
					SimulabTarget simulabTarget = new SimulabTarget();
					simulabTarget.setName(name);
					simulabTarget.setHost(host);
					simulabTarget.saveSimulabTarget();
					try {
						IWorkspace workspace = ResourcesPlugin.getWorkspace();
						IProject targetsProject = workspace.getRoot().getProject("Targets");
						if (!(targetsProject.exists())) {
							// java.io.File targetsProjectFile =
							// targetsProject.getRawLocation().toFile();
							URI uri = workspace.getRoot().getLocation().append("Targets").toFile().toURI();
							IProjectDescription projectDesc = targetsProject.getWorkspace()
									.newProjectDescription("Targets");
							projectDesc.setLocationURI(uri);
							try {
								targetsProject.create(projectDesc, null);
								if (!targetsProject.isOpen()) {
									targetsProject.open(null);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						IFile file = workspace.getRoot()
								.getFileForLocation(targetsProject.getLocation().append(name + TARGET_FILE_EXTENSION));
						if (!targetsProject.isOpen()) {
							targetsProject.open(null);
						}
						if (!file.exists()) {
							// --不存在配置文件,生成空白文件
							byte[] bytes = "".getBytes();
							InputStream inputStream = new ByteArrayInputStream(bytes);
							targetsProject.getFile(name + TARGET_FILE_EXTENSION).create(inputStream, true, null);
						}
						org.eclipse.emf.common.util.URI uri = org.eclipse.emf.common.util.URI
								.createFileURI(file.getLocationURI().getRawPath());
						if (!uri.isEmpty()) {
							TargetResourceImpl targetResource = new TargetResourceImpl(uri);
							Map<Object, Object> options = new HashMap<Object, Object>();
							options.put(XMLResource.OPTION_ENCODING, "UTF-8");
							targetResource.getContents().add(createInitializedModel(simulabTarget));
							targetResource.save(options);
						}
					} catch (CoreException | IOException e) {
						e.printStackTrace();
					}
				}
			}

			private EObject createInitializedModel(SimulabTarget simulabTarget) {
				EPackage ePackage = TargetPackage.eINSTANCE;
				EClass eClass = (EClass) ePackage.getEClassifier("Target");
				Target target = (Target) ePackage.getEFactoryInstance().create(eClass);
				eClass = (EClass) ePackage.getEClassifier("Name");
				Name name = (Name) ePackage.getEFactoryInstance().create(eClass);
				name.setContent(simulabTarget.getName());
				target.setName(name);
				eClass = (EClass) ePackage.getEClassifier("IP");
				IP ip = (IP) ePackage.getEFactoryInstance().create(eClass);
				ip.setContent(simulabTarget.getHost());
				target.setIP(ip);
				return target;
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {

			}
		});
		return compsite;
	}
}