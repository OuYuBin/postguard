package com.gesila.test.guard.editor.decorator;

import org.eclipse.jface.viewers.IDecorationContext;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.LabelDecorator;
import org.eclipse.swt.graphics.Image;

/**
 * 
 * @author robin
 * 
 */
public class PostFlankerApiDocLabelDecorator extends LabelDecorator {

	private Image decoratedImage = null;

	public PostFlankerApiDocLabelDecorator() {

	}

	@Override
	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		if (decoratedImage != null)
			decoratedImage.dispose();
		decoratedImage = null;

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
	public Image decorateImage(Image image, Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String decorateText(String text, Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image decorateImage(Image image, Object element,
			IDecorationContext context) {
//		if (element instanceof Host) {
//			EObject eObject = ((Host) element).getEObject();
//			if (StringUtils.contains(
//					SysConfigECoreUtil.getAttributeValue(eObject, "ostype"),
//					"Windows")) {
//
//				decoratedImage = new DecorationOverlayIcon(image, Activator
//						.getDefault().getImageRegistry()
//						.getDescriptor("Windows"), IDecoration.BOTTOM_RIGHT)
//						.createImage();
//				return decoratedImage;
//			} else {
//				if (StringUtils.contains(
//						SysConfigECoreUtil.getAttributeValue(eObject, "ostype"),
//						"Linux")) {
//
//					decoratedImage = new DecorationOverlayIcon(image, Activator
//							.getDefault().getImageRegistry()
//							.getDescriptor("Linux"), IDecoration.BOTTOM_RIGHT)
//							.createImage();
//					return decoratedImage;
//				}
//			}
//		}
		return null;
	}

	@Override
	public String decorateText(String text, Object element,
			IDecorationContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean prepareDecoration(Object element, String originalText,
			IDecorationContext context) {
		// TODO Auto-generated method stub
		return true;
	}

}
