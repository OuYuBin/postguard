package com.gesila.test.guard.navigator.ui.views.providers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.TextStyle;
import org.eclipse.swt.widgets.Display;

import com.gesila.test.guard.navigator.ui.Activator;

import io.joy.post.flanker.project.models.IPostFlankerProjectElement;
import io.joy.post.flanker.project.models.impl.GesilaTestGuardProject;
import io.joy.post.flanker.project.models.impl.PostFlankerDependence;
import io.joy.post.flanker.project.models.impl.PostFlankerGroup;
import io.joy.post.flanker.project.models.impl.PostFlankerLibrary;
import io.joy.post.flanker.project.models.impl.PostFlankerTestGuard;

/**
 * 
 * @author robin
 *
 */
public class PostFlankerTreeLabelProvider extends LabelProvider implements IStyledLabelProvider {

	protected ResourceManager resourceManager = new LocalResourceManager(JFaceResources.getResources());

	public StyledString.Styler commentStyler;

	public StyledString.Styler counterStyler;

	public StyledString.Styler qualifierStyler;

	public StyledString.Styler postMethodStyler;
	
	public StyledString.Styler getMethodStyler;

	public PostFlankerTreeLabelProvider() {
		super();
		commentStyler = StyledString.DECORATIONS_STYLER;
		counterStyler = StyledString.COUNTER_STYLER;
		qualifierStyler = StyledString.QUALIFIER_STYLER;
		postMethodStyler = new StyledString.Styler() {

			@Override
			public void applyStyles(TextStyle textStyle) {
				textStyle.foreground = new Color(Display.getDefault(), 51, 153, 51);
			}
		};
		getMethodStyler = new StyledString.Styler() {

			@Override
			public void applyStyles(TextStyle textStyle) {
				textStyle.foreground = new Color(Display.getDefault(), 0, 153, 255);
			}
		};
	}

	@Override
	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public Image getImage(Object element) {
		if (element instanceof GesilaTestGuardProject) {
			return Activator.getDefault().getImageRegistry().get("project");
		} else if (element instanceof PostFlankerTestGuard) {
			if (element instanceof PostFlankerGroup) {
				return Activator.getDefault().getImageRegistry().get("interfaceGroup");
			}
			return Activator.getDefault().getImageRegistry().get("interface");
		} else if (element instanceof PostFlankerDependence) {
			return Activator.getDefault().getImageRegistry().get("dependence");
		} else if (element instanceof PostFlankerLibrary) {
			return Activator.getDefault().getImageRegistry().get("library");
		}
		return null;
	}

	public String getText(Object element) {
		if (GesilaTestGuardProject.class.isInstance(element)) {
			return ((GesilaTestGuardProject) element).getName();
		} else if (PostFlankerTestGuard.class.isInstance(element)) {
			if (PostFlankerGroup.class.isInstance(element)) {
				return ((PostFlankerGroup) element).getName();
			}
			int i = ((PostFlankerTestGuard) element).getName().lastIndexOf('.');
			return ((PostFlankerTestGuard) element).getName().substring(0, i);
		} else if (PostFlankerDependence.class.isInstance(element)) {
			return ((PostFlankerDependence) element).getLabelName();
		} else if (PostFlankerLibrary.class.isInstance(element)) {
			// return ((PostGuardLibrary) element).getName();
			int i = ((PostFlankerLibrary) element).getName().lastIndexOf('.');
			return ((PostFlankerLibrary) element).getName().substring(0, i);
		}
		return element.toString();
	}

	@Override
	public StyledString getStyledText(Object element) {
		String text = getText(element);
		StyledString styledString = new StyledString();
		if (!"".equals(text) && text != null) {
			styledString = new StyledString(text);
		}

		if (element instanceof PostFlankerGroup) {
			styledString.append(" (" + ((PostFlankerGroup) element).getElements().size() + ") ", counterStyler);
			return styledString;
		}

		if (element instanceof PostFlankerTestGuard || element instanceof PostFlankerLibrary) {
			IPath path = ((IPostFlankerProjectElement) element).getAdapter(IPath.class);
			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			IFile file = root.getFile(path);
			XMIResourceImpl xmiResource = new XMIResourceImpl();
			Map<Object, Object> options = new HashMap<Object, Object>();
			options.put(XMIResource.OPTION_ENCODING, "UTF-8");
			try {
				xmiResource.load(file.getContents(), options);
				EObject eObject = xmiResource.getContents().get(0);

				String method = (String) eObject.eGet(eObject.eClass().getEStructuralFeature("method"));

				if (StringUtils.equals(method, "POST")) {
					styledString.append(" " + method + " ", postMethodStyler);
				}else if(StringUtils.equals(method, "GET")) {
					styledString.append(" " + method + " ", getMethodStyler);
				}

				String desc = (String) eObject.eGet(eObject.eClass().getEStructuralFeature("desc"));
				if (StringUtils.isNotBlank(desc)) {
					int index = StringUtils.indexOf(desc, "\n");
					if (index > 0) {
						desc = desc.substring(0, index);
					}
					styledString.append(" - " + desc, commentStyler);
				}

			} catch (IOException | CoreException e) {
				e.printStackTrace();
			}

			// Object object = GesilaTestGuard).getObject();
			// if (object != null) {
			// if (EObject.class.isInstance(object)) {
			// Resource resource = ((EObject) object).eResource();
			// if (resource == null)
			// return null;
			// EClass eClass = (((EObject) object).eClass());
			// EAttribute attribute = EDIECoreUtil.getAttribute(eClass,
			// "cnName");
			// if (attribute != null) {
			// String cnName = (String) ((EObject) object).eGet(attribute);
			// if (!StringUtils.isEmpty(cnName))
			// styledString.append(" [" + cnName + "]", commentStyler);
			// }

		}

		// if (EDIPartnerProject.class.isInstance(element)) {
		// Object object = ((EDIPartnerProject) element).getObject();
		// if (Server.class.isInstance(object)) {
		// styledString.append("@" + ((Server) object).getHost(),
		// qualifierStyler);
		// int partnerSize = ((Server) object).getPartner().size();
		// styledString.append(" (" + partnerSize + ") ", counterStyler);
		// }
		// } else if (IEDIProjectElement.class.isInstance(element)) {
		// Object object = ((IEDIProjectElement) element).getObject();
		// if (object != null) {
		// if (EObject.class.isInstance(object)) {
		// Resource resource = ((EObject) object).eResource();
		// if (resource == null)
		// return null;
		// EClass eClass = (((EObject) object).eClass());
		// EAttribute attribute = EDIECoreUtil.getAttribute(eClass, "cnName");
		// if (attribute != null) {
		// String cnName = (String) ((EObject) object).eGet(attribute);
		// if (!StringUtils.isEmpty(cnName))
		// styledString.append(" [" + cnName + "]", commentStyler);
		// }
		// if (eClass.getName().equals(IEDIPartnerConfigContstant.INTERFACE)) {
		// EAttribute nameAttribute = EDIECoreUtil.getAttribute(eClass, "name");
		// String name = (String) ((EObject) object).eGet(nameAttribute);
		// String cnName = null;
		// List<EObject> eObjects = EDIModelQueryUtil
		// .queryReEObjectByUniqueNameWithSameClassName(
		// ((EObject) object).eContainer().eResource().getContents().get(0),
		// eClass, name)
		// .stream().collect(Collectors.toList());
		// if (!eObjects.isEmpty()) {
		// EObject eObject = eObjects.get(0);
		// EAttribute cnNameEAttribute =
		// EDIECoreUtil.getAttribute(eObject.eClass(), "cnName");
		// if (cnNameEAttribute != null) {
		// cnName = (String) eObject.eGet(cnNameEAttribute);
		// if (!StringUtils.isEmpty(cnName)) {
		// styledString.append(" [" + cnName + "]", commentStyler);
		// }
		// }
		// }
		//
		// } else if
		// (eClass.getName().equals(IEDIPartnerConfigContstant.CATEGORY)) {
		// int interfaceSize = (((EObject) object).eContents()).size();
		// styledString.append(" (" + interfaceSize + ") ", counterStyler);
		// }
		//
		// }
		// }
		// }
		return styledString;
	}

}
