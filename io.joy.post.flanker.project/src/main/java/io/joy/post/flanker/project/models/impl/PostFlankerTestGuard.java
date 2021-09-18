package io.joy.post.flanker.project.models.impl;

import io.joy.post.flanker.project.models.IPostFlankerProjectContainerElement;

/**
 * 
 * @author robin
 *
 */
public class PostFlankerTestGuard extends GesilaTestGuardProjectElementImpl {

	private String name;

	private String url;
	
	public PostFlankerTestGuard(IPostFlankerProjectContainerElement parent) {
		super(parent);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public <T> T getAdapter(Class<T> adapter) {
		return super.getAdapter(adapter);
	}
	
	

}
