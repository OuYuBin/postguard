package io.joy.post.flanker.target.ui.views.decorator;

import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

/**
 * 
 * @author robin
 *
 */
public class SimulabTaregetDecoratorImageRegistory {

	private static SimulabTaregetDecoratorImageRegistory INSTANCE = new SimulabTaregetDecoratorImageRegistory();

	private static ImageRegistry imageRegistry;

	private SimulabTaregetDecoratorImageRegistory() {
		imageRegistry = new ImageRegistry();
	}

	public static SimulabTaregetDecoratorImageRegistory getInstance() {
		return INSTANCE;
	}

	public final void declareRegistory(String key, Image image) {
		imageRegistry.put(key, image);
	}

	public Image getImage(String key) {
		return imageRegistry.get(key);
	}

}
