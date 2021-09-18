package io.joy.post.flanker.project.models;

import org.eclipse.core.runtime.IAdaptable;

/**
 * 
 * @author robin
 *
 */
public interface IPostFlankerProjectElement extends IAdaptable{

	public IPostFlankerProjectContainerElement getParent();
	
	public String getName();
	
}
