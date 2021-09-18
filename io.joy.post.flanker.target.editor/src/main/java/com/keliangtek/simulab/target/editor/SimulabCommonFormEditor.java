package com.keliangtek.simulab.target.editor;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.ui.forms.editor.FormEditor;

/**
 * 
 * @author robin
 *
 */
public abstract class SimulabCommonFormEditor extends FormEditor implements ISimulabCommonFormEditor {

	protected ComposedAdapterFactory adapterFactory;

	protected Resource resource;

	protected AdapterFactoryEditingDomain editingDomain;
	
	public SimulabCommonFormEditor(){
		
	}

	@SuppressWarnings("unchecked")
	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		if (adapter.equals(AdapterFactory.class)) {
			return adapterFactory;
		} else if (adapter.equals(Resource.class)) {
			return resource;
		} else if (adapter.equals(EditingDomain.class)) {
			return editingDomain;
		}
		return super.getAdapter(adapter);
	}

}
