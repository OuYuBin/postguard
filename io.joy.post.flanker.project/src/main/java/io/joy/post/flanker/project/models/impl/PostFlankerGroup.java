package io.joy.post.flanker.project.models.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;

import io.joy.post.flanker.project.models.IPostFlankerProjectContainerElement;
import io.joy.post.flanker.project.models.IPostFlankerProjectElement;

/**
 * 
 * @author robin
 *
 */
public class PostFlankerGroup extends PostFlankerTestGuard implements IPostFlankerProjectContainerElement {

	private List<IPostFlankerProjectElement> elements = new ArrayList<IPostFlankerProjectElement>();

	public PostFlankerGroup(IPostFlankerProjectContainerElement parent) {
		super(parent);
	}

	@Override
	public List<IPostFlankerProjectElement> getElements() {
		if (elements.isEmpty()) {
			createElements();
		}
		syncElements();
		return elements;
	}

	private void syncElements() {
		File parentFile = getResource().getLocation().toFile();

		List<IPostFlankerProjectElement> removeElements = new ArrayList<IPostFlankerProjectElement>();
		for (IPostFlankerProjectElement element : elements) {
			boolean removeElement = true;
			String name = element.getName();
			for (File file : parentFile.listFiles()) {
				if (name.equals(file.getName())) {
					removeElement = false;
					break;
				}
			}
			if (removeElement) {
				removeElements.add(element);
			}
		}
		elements.removeAll(removeElements);

		List<IPostFlankerProjectElement> addElements = new ArrayList<IPostFlankerProjectElement>();
		for (File file : parentFile.listFiles()) {
			boolean addElement = true;
			String name = file.getName();
			if (file.isFile() && !file.isHidden() && !name.equals(".project")) {
				for (IPostFlankerProjectElement element : elements) {
					if (name.equals(element.getName())) {
						addElement = false;
						break;
					}
				}
				if (addElement) {
					PostFlankerTestGuard gesilaTestGuard = new PostFlankerTestGuard(this);
					gesilaTestGuard.setName(name);
					addElements.add(gesilaTestGuard);
				}
			}
		}
		elements.addAll(addElements);
	}

	private void createElements() {
		File parentFile = getResource().getLocation().toFile();
		for (File file : parentFile.listFiles()) {
			String name = file.getName();
			if (file.isFile() && !file.isHidden() && !name.equals(".project")) {
				PostFlankerTestGuard gesilaTestGuard = new PostFlankerTestGuard(this);
				gesilaTestGuard.setName(name);
				elements.add(gesilaTestGuard);
			}
		}

	}

	@Override
	public IResource getResource() {
		IPath path = getAdapter(IPath.class);
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		return root.getFile(path);
	}

}
