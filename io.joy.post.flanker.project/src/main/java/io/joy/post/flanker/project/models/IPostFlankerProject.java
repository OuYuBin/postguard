package io.joy.post.flanker.project.models;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;

/**
 * 
 * @author robin
 *
 */
public interface IPostFlankerProject extends IPostFlankerProjectContainerElement{

	public IProject getProject();
}
