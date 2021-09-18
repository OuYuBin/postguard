package com.gesila.test.guard.editor.editingSupport;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;

import com.gesila.test.guard.model.testGuard.Header;
import com.gesila.test.guard.model.testGuard.Headers;

/**
 * 
 * @author robin
 *
 */
public class HeaderNameEditingSupport extends EditingSupport {

	private CellEditor cellEditor = null;

	private Headers headers;

	private IAdaptable adaptable;

	public HeaderNameEditingSupport(ColumnViewer viewer, Headers headers, IAdaptable adaptable) {
		super(viewer);
		this.headers = headers;
		this.adaptable = adaptable;
	}

	@Override
	public CellEditor getCellEditor(Object element) {
		return cellEditor = new TextCellEditor(((Table) getViewer().getControl()), SWT.FLAT);
	}

	@Override
	protected boolean canEdit(Object element) {
		if (element instanceof Header)
			return true;
		else
			return false;
	}

	@Override
	protected Object getValue(Object element) {
		return ((Header) element).getName();
	}

	@Override
	protected void setValue(Object element, Object value) {
		if (cellEditor instanceof TextCellEditor) {
			if (element instanceof Header) {
				EditingDomain editingDomain = adaptable.getAdapter(EditingDomain.class);
				EStructuralFeature feature = ((Header) element).eClass().getEStructuralFeature("name");
				SetCommand setCommand = new SetCommand(editingDomain, (Header) element, feature, value);
				editingDomain.getCommandStack().execute(setCommand);
				getViewer().refresh(element, true);
			}
		}
	}

}
