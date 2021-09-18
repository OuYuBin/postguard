package io.joy.post.flanker.target.ui.views.decorator;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DecorationOverlayIcon;
import org.eclipse.jface.viewers.IDecorationContext;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.LabelDecorator;
import org.eclipse.swt.graphics.Image;

import com.keliangtek.simulab.target.core.models.SimulabTarget;

import io.joy.post.flanker.target.ui.Activator;

/**
 * 
 * @author robin
 *
 */
public class SimulabTargetLabelDecorator extends LabelDecorator {

	public SimulabTargetLabelDecorator() {

	}

	@Override
	public Image decorateImage(Image image, Object element) {
		ImageDescriptor[] imageDescs = new ImageDescriptor[4];
		Image decorateImage = image;
		if (element instanceof SimulabTarget) {
			boolean isDevTarget = ((SimulabTarget) element).isDevTarget();
			if (isDevTarget) {
				imageDescs[0] = Activator
						.getImageDescriptor("icons/dev_target.gif");
			}
			String host = ((SimulabTarget) element).getHost();

			if (host.equals("127.0.0.1")) {
				imageDescs[3] = Activator.getImageDescriptor("icons/run.gif");
				if (imageDescs[0] != null) {
					decorateImage = SimulabTaregetDecoratorImageRegistory
							.getInstance().getImage("dev_target_run");
					if (decorateImage == null) {
						decorateImage = new DecorationOverlayIcon(image,
								imageDescs).createImage();
						SimulabTaregetDecoratorImageRegistory.getInstance()
								.declareRegistory("dev_target_run",
										decorateImage);
					}
				} else {
					decorateImage = SimulabTaregetDecoratorImageRegistory
							.getInstance().getImage("target_run");
					if (decorateImage == null) {
						decorateImage = new DecorationOverlayIcon(image,
								imageDescs).createImage();
						SimulabTaregetDecoratorImageRegistory.getInstance()
								.declareRegistory("target_run",
										decorateImage);
					}
				}
			} else {
				String status = ((SimulabTarget) element).getStatus();
				if (status == null || status.equals("0")) {
					imageDescs[3] = Activator
							.getImageDescriptor("icons/stop.gif");
					if (imageDescs[0] != null) {
						decorateImage = SimulabTaregetDecoratorImageRegistory
								.getInstance().getImage("dev_target_stop");
						if (decorateImage == null) {
							decorateImage = new DecorationOverlayIcon(image,
									imageDescs).createImage();
							SimulabTaregetDecoratorImageRegistory.getInstance()
									.declareRegistory("dev_target_stop",
											decorateImage);
						}
					} else {
						decorateImage = SimulabTaregetDecoratorImageRegistory
								.getInstance().getImage("target_stop");
						if (decorateImage == null) {
							decorateImage = new DecorationOverlayIcon(image,
									imageDescs).createImage();
							SimulabTaregetDecoratorImageRegistory.getInstance()
									.declareRegistory("target_stop",
											decorateImage);
						}
					}
				} else if (status.equals("1")) {
					imageDescs[3] = Activator
							.getImageDescriptor("icons/run.gif");
					if (imageDescs[0] != null) {
						decorateImage = SimulabTaregetDecoratorImageRegistory
								.getInstance().getImage("dev_target_run");
						if (decorateImage == null) {
							decorateImage = new DecorationOverlayIcon(image,
									imageDescs).createImage();
							SimulabTaregetDecoratorImageRegistory.getInstance()
									.declareRegistory("dev_target_run",
											decorateImage);
						}
					} else {
						decorateImage = SimulabTaregetDecoratorImageRegistory
								.getInstance().getImage("target_run");
						if (decorateImage == null) {
							decorateImage = new DecorationOverlayIcon(image,
									imageDescs).createImage();
							SimulabTaregetDecoratorImageRegistory.getInstance()
									.declareRegistory("target_run",
											decorateImage);
						}
					}
				}
			}
		}
		return decorateImage;
	}

	@Override
	public String decorateText(String text, Object element) {
		return null;
	}

	@Override
	public void addListener(ILabelProviderListener listener) {

	}

	@Override
	public void dispose() {

	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {

	}

	@Override
	public Image decorateImage(Image image, Object element,
			IDecorationContext context) {
		return null;
	}

	@Override
	public String decorateText(String text, Object element,
			IDecorationContext context) {
		return null;
	}

	@Override
	public boolean prepareDecoration(Object element, String originalText,
			IDecorationContext context) {
		return true;
	}

}
