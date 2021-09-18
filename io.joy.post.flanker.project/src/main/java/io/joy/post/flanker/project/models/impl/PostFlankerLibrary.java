package io.joy.post.flanker.project.models.impl;

import io.joy.post.flanker.project.models.IPostFlankerProjectContainerElement;

/**
 * 
 * @author robin
 *
 */
public class PostFlankerLibrary extends GesilaTestGuardProjectElementImpl{

	public PostFlankerLibrary(IPostFlankerProjectContainerElement parent) {
		super(parent);
	}

	private String name;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
