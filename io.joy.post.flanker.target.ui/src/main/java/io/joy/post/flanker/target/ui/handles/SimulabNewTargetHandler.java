package io.joy.post.flanker.target.ui.handles;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;

import com.keliangtek.simulab.target.IP;
import com.keliangtek.simulab.target.Name;
import com.keliangtek.simulab.target.Target;
import com.keliangtek.simulab.target.TargetPackage;
import com.keliangtek.simulab.target.core.SimulabTargetCore;
import com.keliangtek.simulab.target.core.SimulabTargetResourceManager;
import com.keliangtek.simulab.target.core.models.SimulabTarget;

import io.joy.post.flanker.target.ui.dialogs.SimulabNewTargetDialog;

/**
 * 
 * @author robin
 *
 */
public class SimulabNewTargetHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		SimulabNewTargetDialog simulabNewTargetDialog = new SimulabNewTargetDialog(
				Display.getDefault().getActiveShell());
		if (simulabNewTargetDialog.open() == Window.OK) {
			String name = simulabNewTargetDialog.getName();
			String host = simulabNewTargetDialog.getHost();
			boolean isDevTarget = simulabNewTargetDialog.isDevTarget();
			SimulabTarget simulabTarget = new SimulabTarget();
			simulabTarget.setName(name);
			simulabTarget.setHost(host);
			simulabTarget.setDevTarget(isDevTarget);
			SimulabTargetResourceManager.getInstance().addTarget(simulabTarget);
			if (isDevTarget)
				SimulabTargetCore.activeDevSimulabTarget(simulabTarget);

			// --创建下位机项目
			try {
				IWorkspace workspace = ResourcesPlugin.getWorkspace();
				URI uri = workspace.getRoot().getLocation().append("Targets")
						.toFile().toURI();
				IProject targetsProject = workspace.getRoot().getProject(
						"Targets");
				IFile targetFile = null;
				// --创建下位机项目
				if (!targetsProject.exists()) {
					IProjectDescription projectDesc = targetsProject
							.getWorkspace().newProjectDescription("Targets");
					projectDesc.setLocationURI(uri);
					try {
						targetsProject.create(projectDesc, null);
						targetsProject.open(null);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				// --创建下位机配置文件
				targetFile = workspace.getRoot().getFileForLocation(
						targetsProject.getLocation().append(name + ".tfg"));
				if (!targetFile.exists()) {
					if (!targetsProject.isOpen())
						targetsProject.open(null);
					// --不存在配置文件,生成空白文件
					byte[] bytes = "".getBytes();
					InputStream inputStream = new ByteArrayInputStream(bytes);
					targetsProject.getFile(name + ".tfg").create(inputStream,
							true, null);
				}

				org.eclipse.emf.common.util.URI targetURI = org.eclipse.emf.common.util.URI
						.createFileURI(targetFile.getLocationURI().getRawPath());
				if (!targetURI.isEmpty()) {
					ResourceSet resourceSet = new ResourceSetImpl();
					Resource resource = resourceSet.createResource(targetURI);
					Map<Object, Object> options = new HashMap<Object, Object>();
					options.put(XMLResource.OPTION_ENCODING, "UTF-8");
					resource.getContents().add(
							createInitializedModel(simulabTarget));
					resource.save(options);
				}
			} catch (CoreException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	private EObject createInitializedModel(SimulabTarget simulabTarget) {
		EPackage ePackage = TargetPackage.eINSTANCE;
		EClass eClass = (EClass) ePackage.getEClassifier("Target");
		Target target = (Target) ePackage.getEFactoryInstance().create(eClass);
		eClass = (EClass) ePackage.getEClassifier("Name");
		Name targetName = (Name) ePackage.getEFactoryInstance().create(eClass);
		targetName.setContent(simulabTarget.getName());
		target.setName(targetName);
		eClass = (EClass) ePackage.getEClassifier("IP");
		IP targetIP = (IP) ePackage.getEFactoryInstance().create(eClass);
		targetIP.setContent(simulabTarget.getHost());
		target.setIP(targetIP);
		return target;
	}

}
