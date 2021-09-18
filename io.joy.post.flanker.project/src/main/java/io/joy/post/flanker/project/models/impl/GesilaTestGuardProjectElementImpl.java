package io.joy.post.flanker.project.models.impl;

import io.joy.post.flanker.project.models.IPostFlankerProjectContainerElement;

/**
 * 
 * @author robin
 *
 */
public class GesilaTestGuardProjectElementImpl extends AbstractGesilaTestGuardProjectElement{

	private IPostFlankerProjectContainerElement parent;
	
	public GesilaTestGuardProjectElementImpl(IPostFlankerProjectContainerElement parent){
		this.parent=parent;
	}

	public IPostFlankerProjectContainerElement getParent() {
		return parent;
	}

	public void setParent(IPostFlankerProjectContainerElement parent) {
		this.parent = parent;
	}

	@Override
	public String getName() {
		return null;
	}
}
