package com.gesila.test.guard.navigator.ui.views.comparator;

import java.util.Comparator;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;

import io.joy.post.flanker.project.models.impl.PostFlankerDependence;

/**
 * 
 * @author ouyubin
 *
 */
public class PostGuardViewerComparator extends ViewerComparator implements Comparator<Object> {

	public PostGuardViewerComparator() {
	}

	public PostGuardViewerComparator(Comparator<? super String> comparator) {
		super(comparator);
	}

	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {
		return compare(e1, e2);
	}

	@Override
	public int compare(Object o1, Object o2) {
		if (o1 instanceof PostFlankerDependence)
			return 1;
		if (o2 instanceof PostFlankerDependence)
			return -1;
		return 0;
	}

}
