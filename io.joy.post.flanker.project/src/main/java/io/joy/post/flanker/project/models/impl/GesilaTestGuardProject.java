package io.joy.post.flanker.project.models.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import io.joy.post.flanker.project.models.IPostFlankerProject;
import io.joy.post.flanker.project.models.IPostFlankerProjectContainerElement;
import io.joy.post.flanker.project.models.IPostFlankerProjectElement;

/**
 * 
 * @author robin
 *
 */
public class GesilaTestGuardProject extends AbstractGesilaTestGuardProjectElement implements IPostFlankerProject {

	private IProject project;

	private List<IPostFlankerProjectElement> elements = new ArrayList<IPostFlankerProjectElement>();

	public GesilaTestGuardProject(IProject project) {
		this.project = project;
	}

	public String getName() {
		return project.getName();
	}

	@Override
	public List<IPostFlankerProjectElement> getElements() {
		if (elements.isEmpty()) {
			createElements();
		}
		try {
			syncElements();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return elements;
	}

	private void syncElements() throws IOException {
		File parentFile = project.getLocation().toFile();

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
			} else if (file.isDirectory()&&!file.isHidden()) {
				if (!StringUtils.equals(name, "dependence")) {
					for (IPostFlankerProjectElement element : elements) {
						if (name.equals(element.getName())) {
							addElement = false;
							break;
						}
					}
					if (addElement) {
						PostFlankerGroup gesilaTestGuardGroup = new PostFlankerGroup(this);
//						IPath path = new Path(file.getCanonicalPath());
//						IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
						gesilaTestGuardGroup.setName(name);
						addElements.add(gesilaTestGuardGroup);
					}
				}
			}
		}
		elements.addAll(addElements);

	}

	public <T> T getAdapter(Class<T> adapter) {
		return super.getAdapter(adapter);
	}

	@Override
	public IProject getProject() {
		return project;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void createElements() {
		File parentFile = project.getLocation().toFile();
		for (File file : parentFile.listFiles()) {
			String name = file.getName();
			if (file.isFile() && !file.isHidden() && !name.equals(".project")) {
				PostFlankerTestGuard gesilaTestGuard = new PostFlankerTestGuard(this);
				gesilaTestGuard.setName(name);
				elements.add(gesilaTestGuard);
			} else if (file.isDirectory()&& !file.isHidden()) {
				if (StringUtils.equals(file.getName(), "dependence")) {
					PostFlankerDependence postGuardDependence = new PostFlankerDependence(this);
					postGuardDependence.setName(name);
					postGuardDependence.setLabelName("依赖项");
					elements.add(postGuardDependence);
				} else {
					PostFlankerGroup gesilaTestGuardGroup = new PostFlankerGroup(this);
					gesilaTestGuardGroup.setName(name);
					elements.add(gesilaTestGuardGroup);
				}
			}
		}
	}

	@Override
	public IResource getResource() {
		return project;
	}

	@Override
	public IPostFlankerProjectContainerElement getParent() {
		return null;
	}

}
