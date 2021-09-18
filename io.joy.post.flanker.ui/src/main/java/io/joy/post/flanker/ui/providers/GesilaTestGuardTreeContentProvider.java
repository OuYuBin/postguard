package io.joy.post.flanker.ui.providers;

import org.eclipse.jface.viewers.ITreeContentProvider;

import io.joy.post.flanker.ui.models.GesilaTestGuardRoot;
import io.joy.post.flanker.ui.models.IGesilaTestGuardGroup;

/**
 * 
 * @author robin
 *
 */
public class GesilaTestGuardTreeContentProvider implements ITreeContentProvider {

	@Override
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof IGesilaTestGuardGroup) {
			return ((IGesilaTestGuardGroup) parentElement).getGesilaTestGuards().toArray();
		}
		return new Object[0];
	}

	@Override
	public Object getParent(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		return getChildren(element).length > 0;
	}

}
