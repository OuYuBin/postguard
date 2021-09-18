package com.gesila.test.guard.editor.providers;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;

import com.gesila.test.guard.editor.listeners.IDetalListener;
//import com.jd.lcp.wuliuyun.apidoc.api;
//import com.jd.lcp.wuliuyun.apidoc.element;
//import com.jd.lcp.wuliuyun.apidoc.method;
//import com.jd.lcp.wuliuyun.apidoc.params;
//import com.jd.lcp.wuliuyun.apidoc.result;

/**
 * 
 * @author robin
 */
public class PostFlankerApiDocContentProvider implements ITreeContentProvider, IDetalListener {

	protected TreeViewer treeViewer;

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		this.treeViewer = (TreeViewer) viewer;
	}

	@Override
	public Object[] getElements(Object inputElement) {
//		if (inputElement instanceof api) {
//			return new Object[] { (api) inputElement };
//		}
		if (inputElement instanceof List) {
			return ((List) inputElement).toArray();
		}
		return new Object[0];
	}

	@Override
	public Object[] getChildren(Object parentElement) {
//		if (parentElement instanceof api) {
//			return ((api) parentElement).getMethod().toArray(new method[0]);
//		} else if (parentElement instanceof method) {
//			return new Object[] { ((method) parentElement).getParams() ,((method)parentElement).getResult()};
//		}else if(parentElement instanceof params) {
//			return ((params) parentElement).getElement().toArray();
//		}else if(parentElement instanceof result) {
//			return ((result) parentElement).getElement().toArray();
//		}else if(parentElement instanceof element) {
//			return ((element) parentElement).getElement().toArray();
//		}
		return new Object[0];
	}

	@Override
	public Object getParent(Object element) {
//		if (element instanceof IModel) {
//			return ((IModel) element).getParent();
//		}
		if (element instanceof EObject) {
			return ((EObject) element).eContainer();
		}
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		return getChildren(element).length > 0;
	}

	@Override
	public void dispose() {

	}

	protected void addListenerTo(EObject model) {
//		model.addListener(this);
//		if (model instanceof IContainerModel) {
//			for (Object name : ((IContainerModel) model).getChildren()) {
//IModel child = (IModel) name;
//addListenerTo(child);
//}
//		}
	}

	@Override
	public void fireAdd(EObject model) {
		// IModel parent = model.getParent();
//		model.addListener(this);
//		treeViewer.refresh(parent, false);
	}

	@Override
	public void fireRemove(EObject model) {
		treeViewer.refresh(model, false);
	}

	@Override
	public void fireSet(EObject model) {
		treeViewer.refresh(model, false);

	}

}