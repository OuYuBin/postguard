package io.joy.post.flanker.project.models.impl;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;

import io.joy.post.flanker.project.models.IPostFlankerProject;
import io.joy.post.flanker.project.models.IPostFlankerProjectContainerElement;
import io.joy.post.flanker.project.models.IPostFlankerProjectElement;

/**
 * 
 * @author robin
 *
 */
public abstract class AbstractGesilaTestGuardProjectElement implements IPostFlankerProjectElement{

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getAdapter(Class<T> adapter) {
		if(adapter==IPath.class){
			return createResourcePath();
		}else if(adapter==IFile.class) {
			IPath path = getAdapter(IPath.class);
			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			return (T) root.getFile(path);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	private <T> T createResourcePath(){
		Object object=null;
		if(this instanceof IPostFlankerProject){
			object=((IPostFlankerProject)this).getProject().getFullPath();
		}else if(this instanceof IPostFlankerProjectElement){
			object=((IPostFlankerProjectElement)this).getParent().getAdapter(IPath.class);
			if(object!=null){
				object=((IPath)object).append(getName());
			}
		}
		return (T) object;
	}

	public abstract IPostFlankerProjectContainerElement getParent();
}
