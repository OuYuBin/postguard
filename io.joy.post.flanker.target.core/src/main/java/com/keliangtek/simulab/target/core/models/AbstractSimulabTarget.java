package com.keliangtek.simulab.target.core.models;

import java.io.IOException;
import java.util.HashMap;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.keliangtek.simulab.target.Target;
import com.keliangtek.simulab.target.util.TargetResourceFactoryImpl;

/**
 * 抽象目标对象
 * 
 * @author robin
 *
 */
public abstract class AbstractSimulabTarget implements ISimulabTarget {

	/**
	 * 状态定时器
	 */
	public int statusTimer;
	
	public int getStatusTimer() {
		return statusTimer;
	}

	public void setStatusTimer(int statusTimer) {
		this.statusTimer = statusTimer;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Class adapter) {
		if (adapter == Target.class) {
			IProject targetsProject = ResourcesPlugin.getWorkspace().getRoot()
					.getProject("Targets");
			IFile tfgFile = targetsProject.getFile(getName() + ".tfg");

			URI fileURI = URI.createPlatformResourceURI(tfgFile.getFullPath()
					.toString(), true);
			TargetResourceFactoryImpl targetResourceFactoryImpl = new TargetResourceFactoryImpl();
			Resource emfResource = targetResourceFactoryImpl
					.createResource(fileURI);
			try {
				emfResource.load(new HashMap());
			} catch (IOException e) {
				e.printStackTrace();
			}
			EObject root = emfResource.getContents().get(0);
			if (root instanceof Target) {
				return root;
			}
		}
		return null;
	}

}
