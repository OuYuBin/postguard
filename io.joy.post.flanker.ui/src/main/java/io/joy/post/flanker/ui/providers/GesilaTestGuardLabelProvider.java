package io.joy.post.flanker.ui.providers;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import io.joy.post.flanker.ui.models.IGesilaTestGuard;

/**
 * 
 * @author robin
 *
 */
public class GesilaTestGuardLabelProvider extends LabelProvider {

	@Override
	public Image getImage(Object element) {
		return super.getImage(element);
	}

	@Override
	public String getText(Object element) {
		if(element instanceof IGesilaTestGuard)
			return ((IGesilaTestGuard)element).getName();
		return super.getText(element);
	}

}
