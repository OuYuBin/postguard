package com.gesila.test.guard.editor.providers;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;

import com.gesila.test.guard.editor.Activator;
//import com.jd.lcp.wuliuyun.apidoc.api;
//import com.jd.lcp.wuliuyun.apidoc.element;
//import com.jd.lcp.wuliuyun.apidoc.method;
//import com.jd.lcp.wuliuyun.apidoc.params;
//import com.jd.lcp.wuliuyun.apidoc.result;

/**
 * 
 * @author robin
 * 
 */
public class PostFlankerApiDocLabelProvider extends LabelProvider implements IStyledLabelProvider {

	StyledString.Styler commentStyler;

	public PostFlankerApiDocLabelProvider() {
		commentStyler = StyledString.DECORATIONS_STYLER;
	}

	@Override
	public Image getImage(Object element) {
//		if (element instanceof api) {
//			return Activator.getDefault().getImageRegistry().get("interface");
//		} else if (element instanceof method) {
//			return Activator.getDefault().getImageRegistry().get("method");
//		} else if (element instanceof params) {
//			return Activator.getDefault().getImageRegistry().get("parameters");
//		} else if (element instanceof result) {
//			return Activator.getDefault().getImageRegistry().get("result");
//		} else if (element instanceof com.jd.lcp.wuliuyun.apidoc.element) {
//			return Activator.getDefault().getImageRegistry().get("element");
//		}
		return super.getImage(element);
	}

	@Override
	public String getText(Object element) {
//		if (element instanceof api) {
//			return ((api) element).getName();
//		} else if (element instanceof method) {
//			return ((method) element).getName();
//		} else if (element instanceof params) {
//			return "Params";
//		} else if (element instanceof result) {
//			return "Result";
//		} else if (element instanceof element) {
//			return ((element) element).getName();
//		}
		return super.getText(element);
	}

	@Override
	public StyledString getStyledText(Object element) {
		StyledString styledString = new StyledString(getText(element));
		if(element instanceof EObject) {
			EStructuralFeature commentFeature=((EObject)element).eClass().getEStructuralFeature("comment");
			if(commentFeature!=null) {
				String comment=(String) ((EObject)element).eGet(commentFeature);
				if(StringUtils.isNotBlank(comment)) {
					styledString.append(" - "+comment, commentStyler);
				}
			}
		}
		return styledString;
	}

}
