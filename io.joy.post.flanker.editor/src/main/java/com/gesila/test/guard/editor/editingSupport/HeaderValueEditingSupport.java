package com.gesila.test.guard.editor.editingSupport;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.fieldassist.AutoCompleteField;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;

import com.gesila.test.guard.model.testGuard.Header;
import com.gesila.test.guard.model.testGuard.Headers;
import com.gesila.test.guard.model.testGuard.TestGuardFactory;
import com.gesila.test.guard.model.testGuard.TestGuardPackage;

/**
 * 
 * @author robin
 *
 */
public class HeaderValueEditingSupport extends EditingSupport {

	// ComboBoxCellEditor comboBoxViewerCellEditor;
	private CellEditor cellEditor = null;

	private Headers headers;

	private IAdaptable adaptable;

	public HeaderValueEditingSupport(ColumnViewer viewer, Headers headers, IAdaptable adaptable) {
		super(viewer);
		this.headers = headers;
		this.adaptable = adaptable;
	}

	@Override
	public CellEditor getCellEditor(Object element) {
		if (element instanceof EEnumLiteral) {
			EAnnotation annotation = ((EEnumLiteral) element).getEAnnotation("ExtendedMetaData");
			if (annotation != null) {
				EMap<String, String> details = annotation.getDetails();
				String content = details.get("content");
				if (content != null) {
					String[] contents = content.split("\\|");
					String[] values = new String[contents.length + 1];
					values[0] = "";
					System.arraycopy(contents, 0, values, 1, contents.length);
					cellEditor = new ComboBoxCellEditor(((Table) getViewer().getControl()), values, SWT.FLAT);
					// comboBoxViewerCellEditor.setInput(values);
					new AutoCompleteField(cellEditor.getControl(), new CComboContentAdapter(), values);
					// return comboBoxViewerCellEditor;
				} else {
					cellEditor = new TextCellEditor(((Table) getViewer().getControl()), SWT.FLAT);
				}
			} else {
				cellEditor = new TextCellEditor(((Table) getViewer().getControl()), SWT.FLAT);
			}
		} else {
			cellEditor = new TextCellEditor(((Table) getViewer().getControl()), SWT.FLAT);
		}
		return cellEditor;
	}

	@Override
	protected boolean canEdit(Object element) {
		return true;
	}

	@Override
	protected Object getValue(Object element) {
		if (cellEditor instanceof TextCellEditor) {
			if (element instanceof EEnumLiteral) {
				String literal = ((EEnumLiteral) element).getLiteral();
				List<Header> headerElements = headers.getHeader().stream()
						.filter(header -> header.getName().equals(literal)).collect(Collectors.toList());
				if (!headerElements.isEmpty()) {
					return headerElements.get(0).getValue();
				}
			} else if (element instanceof Header) {
				return ((Header) element).getValue();
			}
		} else if (cellEditor instanceof ComboBoxCellEditor) {
			if (element instanceof EEnumLiteral) {
				String literal = ((EEnumLiteral) element).getLiteral();
				List<Header> headerElements = headers.getHeader().stream()
						.filter(header -> header.getName().equals(literal)).collect(Collectors.toList());
				if (!headerElements.isEmpty()) {
					EAnnotation annotation = ((EEnumLiteral) element).getEAnnotation("ExtendedMetaData");
					if (annotation != null) {
						EMap<String, String> details = annotation.getDetails();
						String content = details.get("content");
						if (content != null) {
							String[] contents = content.split("\\|");
							String[] values = new String[contents.length + 1];
							values[0] = "";
							System.arraycopy(contents, 0, values, 1, contents.length);
							int i = 0;
							for (String value : values) {
								Header header = headerElements.get(0);
								if (StringUtils.equals(header.getValue(), value)) {
									return i;
								}
								i++;
							}
//							EditingDomain editingDomain = adaptable.getAdapter(EditingDomain.class);
//							EStructuralFeature feature = (headerElements.get(0)).eClass().getEStructuralFeature("value");
//							SetCommand setCommand = new SetCommand(editingDomain, headerElements.get(0), feature,
//									values[(int) value]);
//							editingDomain.getCommandStack().execute(setCommand);

						}
					}
				} else {
					return 0;
				}
			}
		}
		return "";
	}

	@Override
	protected void setValue(Object element, Object value) {
		if (cellEditor instanceof TextCellEditor) {
			if (element instanceof EEnumLiteral) {
				EAnnotation annotation = ((EEnumLiteral) element).getEAnnotation("ExtendedMetaData");
				String literal = ((EEnumLiteral) element).getLiteral();
				List<Header> headerElements = headers.getHeader().stream()
						.filter(header -> header.getName().equals(literal)).collect(Collectors.toList());
				if (!headerElements.isEmpty()) {
					String currentValue = headerElements.get(0).getValue();
					if (StringUtils.isBlank((String) value)) {
						EditingDomain editingDomain = adaptable.getAdapter(EditingDomain.class);
						RemoveCommand removeCommand = new RemoveCommand(editingDomain, headers,
								TestGuardPackage.eINSTANCE.getHeaders_Header(), headerElements.get(0));
						editingDomain.getCommandStack().execute(removeCommand);
						return;
					}
					if (!StringUtils.equals(currentValue, (String) value)) {
						EditingDomain editingDomain = adaptable.getAdapter(EditingDomain.class);
						EStructuralFeature feature = (headerElements.get(0)).eClass().getEStructuralFeature("value");
						SetCommand setCommand = new SetCommand(editingDomain, headerElements.get(0), feature,
								(String) value);
						editingDomain.getCommandStack().execute(setCommand);
					}
				} else {
					EditingDomain editingDomain = adaptable.getAdapter(EditingDomain.class);
					Header header = TestGuardFactory.eINSTANCE.createHeader();
					header.setName(literal);
					header.setValue((String) value);
					AddCommand addCommand = new AddCommand(editingDomain, headers,
							TestGuardPackage.eINSTANCE.getHeaders_Header(), header);
					editingDomain.getCommandStack().execute(addCommand);
				}
				getViewer().refresh(element, true);
			} else if (element instanceof Header) {
				EditingDomain editingDomain = adaptable.getAdapter(EditingDomain.class);
				EStructuralFeature feature = ((Header) element).eClass().getEStructuralFeature("value");
				SetCommand setCommand = new SetCommand(editingDomain, (Header) element, feature, value);
				editingDomain.getCommandStack().execute(setCommand);
				getViewer().refresh(element, true);
			}
		} else if (cellEditor instanceof ComboBoxCellEditor) {
			String literal = ((EEnumLiteral) element).getLiteral();
			if (element instanceof EEnumLiteral) {
				List<Header> headerElements = headers.getHeader().stream()
						.filter(header -> header.getName().equals(literal)).collect(Collectors.toList());
				if (!headerElements.isEmpty()) {
					EAnnotation annotation = ((EEnumLiteral) element).getEAnnotation("ExtendedMetaData");
					if (annotation != null) {
						EMap<String, String> details = annotation.getDetails();
						String content = details.get("content");
						if (content != null) {
							String[] contents = content.split("\\|");
							String[] values = new String[contents.length + 1];
							values[0] = "";
							System.arraycopy(contents, 0, values, 1, contents.length);
							if ((Integer) value > -1) {
								String currentValue = headerElements.get(0).getValue();
								if (!StringUtils.equals(currentValue, values[(int) value])) {
									EditingDomain editingDomain = adaptable.getAdapter(EditingDomain.class);
									EStructuralFeature feature = (headerElements.get(0)).eClass()
											.getEStructuralFeature("value");
									SetCommand setCommand = new SetCommand(editingDomain, headerElements.get(0),
											feature, values[(int) value]);
									editingDomain.getCommandStack().execute(setCommand);
								}
							} else {
								EditingDomain editingDomain = adaptable.getAdapter(EditingDomain.class);
								RemoveCommand removeCommand = new RemoveCommand(editingDomain, headers,
										TestGuardPackage.eINSTANCE.getHeaders_Header(), headerElements.get(0));
								editingDomain.getCommandStack().execute(removeCommand);
							}
						}
					}
				} else {
					EAnnotation annotation = ((EEnumLiteral) element).getEAnnotation("ExtendedMetaData");
					if (annotation != null) {
						EMap<String, String> details = annotation.getDetails();
						String content = details.get("content");
						if (content != null) {
							if ((Integer) value > -1) {
								String[] contents = content.split("\\|");
								String[] values = new String[contents.length + 1];
								values[0] = "";
								System.arraycopy(contents, 0, values, 1, contents.length);
								String currentVal = values[(Integer) value];
								if (StringUtils.isNotBlank(currentVal)) {
									EditingDomain editingDomain = adaptable.getAdapter(EditingDomain.class);
									Header header = TestGuardFactory.eINSTANCE.createHeader();
									header.setName(literal);
									header.setValue(values[(Integer) value]);
									AddCommand addCommand = new AddCommand(editingDomain, headers,
											TestGuardPackage.eINSTANCE.getHeaders_Header(), header);
//							EStructuralFeature feature = (headerElements.get(0)).eClass()
//									.getEStructuralFeature("value");
//							SetCommand setCommand = new SetCommand(editingDomain, headerElements.get(0), feature,
//									values[(int) value]);
									editingDomain.getCommandStack().execute(addCommand);
								}
							}
						}
					}
//					Header header = TestGuardFactory.eINSTANCE.createHeader();
//					header.setName(literal);
//					header.setValue((String) value);
//					headers.getHeader().add(header);
				}
				getViewer().refresh(element, true);
			}
		}
	}

}
