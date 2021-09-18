package com.gesila.test.guard.common.listeners.manager;

import org.eclipse.core.resources.IResourceChangeListener;

/**
 * 
 * @author robin
 *
 */
public interface IGesilaTestGuardModelElementChangeListener extends IResourceChangeListener{

	public void testGuardModelElementChange();
}
