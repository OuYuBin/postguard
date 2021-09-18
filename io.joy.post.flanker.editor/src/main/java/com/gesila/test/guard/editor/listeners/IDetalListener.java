package com.gesila.test.guard.editor.listeners;

import org.eclipse.emf.ecore.EObject;

/**
 * 
 * @author robin
 * 
 */
public interface IDetalListener {
	
	public void fireAdd(EObject model);

	public void fireRemove(EObject model);
	
	public void fireSet(EObject model);

}
