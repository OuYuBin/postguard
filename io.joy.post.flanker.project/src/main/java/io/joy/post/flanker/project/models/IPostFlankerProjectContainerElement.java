package io.joy.post.flanker.project.models;

import java.util.List;

import org.eclipse.core.resources.IResource;

/**
 * 
 * @author robin
 *
 */
public interface IPostFlankerProjectContainerElement extends IPostFlankerProjectElement {

	public List<IPostFlankerProjectElement> getElements();
	
	public IResource getResource();
	
	
}
