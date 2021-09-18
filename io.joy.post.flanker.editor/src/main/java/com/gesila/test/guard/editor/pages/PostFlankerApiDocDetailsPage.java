package com.gesila.test.guard.editor.pages;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.forms.AbstractFormPart;
import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IFormPart;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;

import com.gesila.test.guard.editor.PostFlankerFormEditor;
import com.gesila.test.guard.model.testGuard.TestGuard;

public class PostFlankerApiDocDetailsPage extends AbstractFormPart implements
		IDetailsPage, INotifyChangedListener {

	private Object input;

	FormToolkit toolKit;

	private PostFlankerFormEditor sysConfigFormPageEditor;

	private Section objectInfoSection;

	private SectionPart objectInfoSectionPart;

	private List objectInfoTextList = new ArrayList();

	private SectionPart attrsSectionPart;

	// private Section elementsSection;

	private Section attrsSection;

	//private AttrFilter attrFilter;

	private TableViewer attrTableViewer;

	private EObject attrEObject;

	private List<Widget> attributesControlList = new ArrayList<Widget>();
	
	private Resource myResource;

	public PostFlankerApiDocDetailsPage(Object input,
			PostFlankerFormEditor sysConfigFormPageEditor) {
		this.input = input;
		this.sysConfigFormPageEditor = sysConfigFormPageEditor;
		
//		myResource = getEditor().getAdapter(Resource.class);
//		testGuard = (TestGuard) myResource.getContents().get(0);
//		AdapterFactory adapterFactory = sysConfigFormPageEditor
//				.getAdapterFactory();
//		((IChangeNotifier) adapterFactory).addListener(this);
	}

	@Override
	public void createContents(Composite parent) {
		toolKit = getManagedForm().getToolkit();
		TableWrapLayout tableWrapLayout = new TableWrapLayout();
		parent.setLayout(tableWrapLayout);

		objectInfoSection = toolKit.createSection(parent, Section.EXPANDED
				| Section.TITLE_BAR);
		objectInfoSection.setText("Attributes");
		objectInfoSection.clientVerticalSpacing = 0;

		TableWrapData twd = new TableWrapData(TableWrapData.FILL_GRAB);
		twd.grabHorizontal = true;
		twd.grabVertical=true;
		objectInfoSection.setLayoutData(twd);

		Composite client = toolKit.createComposite(objectInfoSection);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		gridLayout.horizontalSpacing = 8;
		client.setLayout(gridLayout);

		createAttributesSection(input, client);
		objectInfoSection.setClient(client);
		objectInfoSectionPart = new SectionPart(objectInfoSection);
		getManagedForm().addPart(objectInfoSectionPart);
		EObject eObject = null;
//		if (input instanceof IModel) {
//			eObject = ((IModel) input).getEObject();
//		}
//		if (eObject == null) {
//			return;
//		}
//
//		Resource resource = sysConfigFormPageEditor.getResource();
//		String type = ((SysConfigEClassImpl) (eObject.eClass()))
//				.getSysConfigComponent().getAttributeValue("type");
//		List<EObject> attrs = new ArrayList<EObject>();
//		if (type.equals("Host")) {
//			attrs = SysConfigModelManager.getAttrOfOs(resource, eObject);
//		} else if (type.equals("Object")) {
//			attrs = SysConfigModelManager.getAttrOfApp(resource, eObject);
//		} else {
//			return;
//		}
//		if (!attrs.isEmpty()) {
//			attrsSection = toolKit.createSection(parent, Section.EXPANDED
//					| Section.TITLE_BAR);
//			attrsSection.setText("Attr");
//			attrsSection.clientVerticalSpacing = 0;
//
//			twd = new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.TOP);
//			twd.grabHorizontal = true;
//			twd.grabVertical = true;
//			attrsSection.setLayoutData(twd);
//
//			client = toolKit.createComposite(attrsSection, SWT.WRAP);
//			gridLayout = new GridLayout();
//			client.setLayout(gridLayout);
//
//			createAttrsSection(sysConfigFormPageEditor.getResource(), attrs,
//					client);
//			attrsSection.setClient(client);
//			attrsSectionPart = new SectionPart(attrsSection);
//
//			getManagedForm().addPart(attrsSectionPart);
//			
//		}
	}

	private void createAttributesSection(final Object input, Composite parent) {

//		if (input instanceof IModel) {
//			final EObject eObject = ((IModel) input).getEObject();
//
//			if (eObject != null) {
//				EList<EAttribute> attributes = SysConfigECoreUtil
//						.getAllAttributes(eObject);
//				List<Node> attrList = ((SysConfigEClassImpl) eObject.eClass())
//						.getSysConfigComponent().getAttributes();
//				final IMessageManager messageManager = getManagedForm()
//						.getMessageManager();
//				Node node = null;
//				for (final EAttribute eAttribute : attributes) {
//					String name = eAttribute.getName();
//					String comment = null;
//
//					for (int i = 0; i < attrList.size(); i++) {
//						node = attrList.get(i);
//						if (name.equals(node.getAttributes()
//								.getNamedItem("type").getNodeValue())) {
//							Node commentNode = node.getAttributes()
//									.getNamedItem("comment");
//							if (commentNode != null)
//								comment = commentNode.getNodeValue();
//
//							Node descNode = node.getAttributes().getNamedItem(
//									"desc");
//							if (descNode != null) {
//								name = descNode.getNodeValue();
//								break;
//							}
//						}
//					}
//					Node modeNode = node.getAttributes().getNamedItem("mode");
//					String mode = null;
//					if (modeNode != null) {
//						mode = modeNode.getNodeValue();
//					}
//					Label nameLable = getManagedForm().getToolkit()
//							.createLabel(parent, name + ":", SWT.LEFT);
//					GridData gd = new GridData(SWT.FILL, SWT.FILL, false, true);
//					gd.horizontalSpan = 1;
//					gd.horizontalAlignment = SWT.LEFT;
//					nameLable.setLayoutData(gd);
//
//					gd = new GridData(SWT.FILL, SWT.FILL, true, true);
//					gd.widthHint = 100;
//					String value = (String) eObject.eGet(eAttribute);
//
//					if (eAttribute.getName().equals("ostype")) {
//						final String[] osTypes = new String[] { "Linux",
//								"Windows" };
//						CCombo combo = new CCombo(parent, SWT.READ_ONLY
//								| SWT.FLAT | SWT.BORDER);
//						combo.setVisibleItemCount(3);
//						combo.setData(eAttribute);
//						getManagedForm().getToolkit().adapt(combo, true, true);
//						combo.setItems(osTypes);
//						combo.addSelectionListener(new SelectionListener() {
//
//							@Override
//							public void widgetSelected(SelectionEvent e) {
//								CCombo combo = (CCombo) e.getSource();
//								String value = osTypes[combo
//										.getSelectionIndex()];
//								String oldValue = (String) (((IModel) input)
//										.getEObject())
//										.eGet((EStructuralFeature) combo
//												.getData());
//								if (value.equals(oldValue)) {
//									return;
//								}
//								EditingDomain editingDomain = sysConfigFormPageEditor
//										.getEditingDomain();
//								SysConfigSetCommand setCommand = new SysConfigSetCommand(
//										editingDomain, ((IModel) input)
//												.getEObject(), eAttribute,
//										value, input);
//								editingDomain.getCommandStack().execute(
//										setCommand);
//							}
//
//							@Override
//							public void widgetDefaultSelected(SelectionEvent e) {
//
//							}
//						});
//						String osType = value != null ? value : osTypes[0];
//						combo.setText(osType);
//						gd.horizontalSpan = 2;
//						if (Platform.getOS().equals(Platform.OS_MACOSX)) {
//							Shell shell = new Shell();
//							GC gc = new GC(shell);
//							gc.setFont(shell.getFont());
//							Point point = gc.textExtent("");
//							gd.heightHint = point.y + 6;
//						}
//						combo.setLayoutData(gd);
//						attributesControlList.add(combo);
//					} else if (eAttribute.getName().equals("datacenter")) {
//						CCombo combo = new CCombo(parent, SWT.READ_ONLY
//								| SWT.FLAT | SWT.BORDER);
//						combo.setData(eAttribute);
//						getManagedForm().getToolkit().adapt(combo, true, true);
//						combo.addSelectionListener(new SelectionListener() {
//
//							@Override
//							public void widgetSelected(SelectionEvent e) {
//								CCombo combo = (CCombo) e.getSource();
//								String[] items = combo.getItems();
//								String value = items[combo.getSelectionIndex()];
//								String oldValue = (String) (((IModel) input)
//										.getEObject())
//										.eGet((EStructuralFeature) combo
//												.getData());
//								if (value.equals(oldValue)) {
//									return;
//								}
//								EditingDomain editingDomain = sysConfigFormPageEditor
//										.getEditingDomain();
//								SysConfigSetCommand setCommand = new SysConfigSetCommand(
//										editingDomain, ((IModel) input)
//												.getEObject(), eAttribute,
//										value, input);
//								editingDomain.getCommandStack().execute(
//										setCommand);
//							}
//
//							@Override
//							public void widgetDefaultSelected(SelectionEvent e) {
//
//							}
//						});
//						gd.horizontalSpan = 2;
//						if (Platform.getOS().equals(Platform.OS_MACOSX)) {
//							Shell shell = new Shell();
//							GC gc = new GC(shell);
//							gc.setFont(shell.getFont());
//							Point point = gc.textExtent("");
//							gd.heightHint = point.y + 6;
//						}
//						combo.setLayoutData(gd);
//						attributesControlList.add(combo);
//
//					} else if (mode != null) {
//						if (mode.equals("boolean")) {
//							final Button valueButton = getManagedForm()
//									.getToolkit().createButton(parent, null,
//											SWT.CHECK);
//							valueButton.setData(eAttribute);
//							gd.horizontalSpan = 2;
//							Shell shell = new Shell();
//							GC gc = new GC(shell);
//							gc.setFont(shell.getFont());
//							Point point = gc.textExtent("");
//							gd.heightHint = point.y + 6;
//							valueButton.setLayoutData(gd);
//							if (new Boolean(value).booleanValue()) {
//								valueButton.setSelection(true);
//							}
//							attributesControlList.add(valueButton);
//							valueButton
//									.addSelectionListener(new SelectionListener() {
//
//										@Override
//										public void widgetSelected(
//												SelectionEvent e) {
//											Button button = (Button) e
//													.getSource();
//											String value = new Boolean(button
//													.getSelection()).toString();
//											if (value != null) {
//												String oldValue = (String) eObject
//														.eGet((EStructuralFeature) button
//																.getData());
//												if (value.equals(oldValue)) {
//													return;
//												}
//												EditingDomain editingDomain = sysConfigFormPageEditor
//														.getEditingDomain();
//												SysConfigSetCommand setCommand = new SysConfigSetCommand(
//														editingDomain, eObject,
//														eAttribute, value,
//														input);
//												editingDomain.getCommandStack()
//														.execute(setCommand);
//											}
//										}
//
//										@Override
//										public void widgetDefaultSelected(
//												SelectionEvent e) {
//										}
//									});
//						} else {
//							final Text valueText = getManagedForm()
//									.getToolkit().createText(parent, value,
//											SWT.BORDER);
//							valueText.setData(eAttribute);
//							// if (name.equals("Expr")) {
//							// gd.horizontalSpan = 1;
//							// } else {
//							gd.horizontalSpan = 2;
//							// }
//							valueText.setLayoutData(gd);
//							valueText.addModifyListener(new ModifyListener() {
//
//								@Override
//								public void modifyText(ModifyEvent event) {
//									Text text = (Text) event.widget;
//									String value = text.getText();
//									if (value != null) {
//										String oldValue = (String) eObject
//												.eGet((EStructuralFeature) text
//														.getData());
//										if (value.equals(oldValue)) {
//											return;
//										}
//										EditingDomain editingDomain = sysConfigFormPageEditor
//												.getEditingDomain();
//										SysConfigSetCommand setCommand = new SysConfigSetCommand(
//												editingDomain, eObject,
//												eAttribute, value, input);
//										editingDomain.getCommandStack()
//												.execute(setCommand);
//									}
//								}
//							});
//							if (comment != null) {
//								final ControlDecoration informationDeco = new ControlDecoration(
//										valueText, SWT.TOP | SWT.LEFT);
//								Image image = FieldDecorationRegistry
//										.getDefault()
//										.getFieldDecoration(
//												FieldDecorationRegistry.DEC_CONTENT_PROPOSAL)
//										.getImage();
//
//								informationDeco.setDescriptionText(comment);
//								informationDeco.setShowOnlyOnFocus(true);
//								informationDeco.setImage(image);
//							}
//							Node isRequiredNode = node.getAttributes()
//									.getNamedItem("isRequired");
//							if (isRequiredNode != null
//									&& new Boolean(
//											isRequiredNode.getNodeValue())) {
//								final ControlDecoration informationDeco = new ControlDecoration(
//										valueText, SWT.CENTER | SWT.LEFT);
//								Image image = FieldDecorationRegistry
//										.getDefault()
//										.getFieldDecoration(
//												FieldDecorationRegistry.DEC_REQUIRED)
//										.getImage();
//
//								informationDeco.setShowOnlyOnFocus(false);
//								informationDeco.setImage(image);
//							}
//
//							Node errorMessageNode = node.getAttributes()
//									.getNamedItem("errorMessage");
//							if (errorMessageNode != null) {
//								final String errorMessage = errorMessageNode
//										.getNodeValue();
//								final Node regexNode = node.getAttributes()
//										.getNamedItem("regex");
//								if (regexNode != null) {
//									String regex = regexNode.getNodeValue();
//									if (regex != null) {
//										Pattern pattern = Pattern
//												.compile(regex);
//										Matcher match = pattern
//												.matcher(valueText.getText());
//										if (!match.find()) {
//											messageManager.addMessage(
//													"textType", errorMessage,
//													null,
//													IMessageProvider.WARNING,
//													valueText);
//										} else {
//											messageManager.removeMessage(
//													"textType", valueText);
//										}
//									}
//								}
//
//								valueText
//										.addModifyListener(new ModifyListener() {
//
//											@Override
//											public void modifyText(ModifyEvent e) {
//												if (regexNode != null) {
//													String regex = regexNode
//															.getNodeValue();
//													if (regex != null) {
//														Pattern pattern = Pattern
//																.compile(regex);
//														Text text = (Text) e
//																.getSource();
//														Matcher match = pattern.matcher(text
//																.getText());
//														if (!match.find()) {
//															messageManager
//																	.addMessage(
//																			"textType",
//																			errorMessage,
//																			null,
//																			IMessageProvider.WARNING,
//																			valueText);
//														} else {
//															messageManager
//																	.removeMessage(
//																			"textType",
//																			valueText);
//														}
//													}
//												}
//
//											}
//										});
//							}
//
//							attributesControlList.add(valueText);
//						}
//					}
//				}
//			} else {
//				if (input instanceof com.shfit.ctp.monitor.sysconfig.editor.model.System) {
//					Label nameLable = getManagedForm().getToolkit()
//							.createLabel(parent,
//									((IModel) input).getName() + ":", SWT.LEFT);
//					GridData gd = new GridData(SWT.FILL, SWT.FILL, false, true);
//					gd.horizontalSpan = 1;
//					gd.horizontalAlignment = SWT.LEFT;
//					nameLable.setLayoutData(gd);
//
//					gd = new GridData(SWT.FILL, SWT.FILL, true, true);
//					gd.widthHint = 100;
//					String value = ((com.shfit.ctp.monitor.sysconfig.editor.model.System) input)
//							.getCtpName();
//					Text valueText = getManagedForm().getToolkit().createText(
//							parent, value, SWT.BORDER);
//					valueText.setData(input);
//					gd.horizontalSpan = 2;
//					valueText.setLayoutData(gd);
//					attributesControlList.add(valueText);
//					valueText.addModifyListener(new ModifyListener() {
//
//						// --更改原则:更改系统名称其实需要修改host对象中datacenter中的属性
//						@Override
//						public void modifyText(ModifyEvent event) {
//							Text text = (Text) event.widget;
//							String value = text.getText();
//							List<IModel> list = ((com.shfit.ctp.monitor.sysconfig.editor.model.System) input)
//									.getChildren();
//							for (int i = 0; i < list.size(); i++) {
//								IModel model = list.get(i);
//								EObject eObject = model.getEObject();
//								EAttribute eAttribute = (EAttribute) eObject
//										.eClass().getEStructuralFeature(
//												"datacenter");
//								EditingDomain editingDomain = sysConfigFormPageEditor
//										.getEditingDomain();
//								SysConfigSetCommand setCommand = new SysConfigSetCommand(
//										editingDomain, eObject, eAttribute,
//										value, input);
//								editingDomain.getCommandStack().execute(
//										setCommand);
//								// --更改System对象名称
//								((com.shfit.ctp.monitor.sysconfig.editor.model.System) input)
//										.setCtpName(value);
//							}
//						}
//					});
//				}
//			}
//		}

	}

	@Override
	public void selectionChanged(IFormPart part, ISelection selection) {
//		FormToolkit toolkit = getManagedForm().getToolkit();
//		EObject eObject = null;
//		IModel model = null;
//		if (selection instanceof IStructuredSelection) {
//			model = (IModel) ((IStructuredSelection) selection)
//					.getFirstElement();
//			eObject = model.getEObject();
//			if (eObject != null) {
//				ISysConfigComponent sysConfigComponent = ((SysConfigEClassImpl) eObject
//						.eClass()).getSysConfigComponent();
//			}
//		}
//		for (int i = 0; i < attributesControlList.size(); i++) {
//			Widget widget = attributesControlList.get(i);
//			if (widget instanceof CCombo) {
//				EAttribute eAttribute = (EAttribute) ((CCombo) widget)
//						.getData();
//				if (eAttribute.getName().equals("datacenter")) {
//					Member member = (Member) model.getParent().getParent();
//					List list = member.getChildren();
//					List<String> systems = new ArrayList<String>();
//					for (int j = 0; j < list.size(); j++) {
//						Object object = list.get(j);
//						if (object instanceof com.shfit.ctp.monitor.sysconfig.editor.model.System) {
//							systems.add(((com.shfit.ctp.monitor.sysconfig.editor.model.System) object)
//									.getCtpName());
//						}
//					}
//					((CCombo) widget).setItems(systems.toArray(new String[0]));
//					String value = (String) eObject.eGet(eAttribute);
//					if (value != null)
//						((CCombo) widget).setText(value);
//
//				}
//			}
//		}
//
//		if (attrTableViewer != null) {
//			Resource resource = sysConfigFormPageEditor.getResource();
//			String type = ((SysConfigEClassImpl) (eObject.eClass()))
//					.getSysConfigComponent().getAttributeValue("type");
//			List<EObject> attrs = new ArrayList<EObject>();
//			if (type.equals("Host")) {
//				attrs = SysConfigModelManager.getAttrOfOs(resource, eObject);
//			} else if (type.equals("Object")) {
//				attrs = SysConfigModelManager.getAttrOfApp(resource, eObject);
//			} else {
//				return;
//			}
//
//			attrTableViewer.setInput(attrs);
//			if (attrEObject != null) {
//				IStructuredSelection newSelection = new StructuredSelection(
//						attrEObject);
//				attrTableViewer.setSelection(newSelection, true);
//				attrEObject = null;
//			}
//		}
	}

	@Override
	public void notifyChanged(Notification notification) {
//		Object object = notification.getNotifier();
//		if (object == ((IModel) input).getEObject()) {
//			Object feature = notification.getFeature();
//			if (feature instanceof EAttribute && attributesControlList != null) {
//				for (Object element : attributesControlList) {
//					Widget widget = (Widget) element;
//					if (widget.getData() == feature) {
//						String value = notification.getNewStringValue() == null ? ""
//								: notification.getNewStringValue();
//						if (widget instanceof Text) {
//							if (value != null) {
//								String oldValue = ((Text) widget).getText();
//								if (value.equals(oldValue)) {
//									return;
//								} else {
//									((Text) widget).setText(value);
//								}
//								break;
//							}
//						} else if (widget instanceof CCombo) {
//							// Object data = ((CCombo) widget).getData();
//							((CCombo) widget).setText(value);
//						} else if (widget instanceof Button) {
//							if (new Boolean(value).booleanValue()) {
//								((Button) widget).setSelection(true);
//							} else {
//								((Button) widget).setSelection(false);
//							}
//						}
//						break;
//					}
//				}
//			}
//		}
		// if (input instanceof System) {
		// for (Iterator iter = attributesControlList.iterator(); iter
		// .hasNext();) {
		// Widget widget = (Widget) iter.next();
		// if (widget instanceof Text) {
		// if (input == widget.getData()) {
		// ((Text) widget).setText(((System) input).getCtpName());
		// break;
		// }
		// }
		// }
		// }
	}

	private void createAttrsSection(Resource resource, List<EObject> attrs,
			Composite composite) {

//		final Text searchText = toolKit.createText(composite, "", SWT.BORDER
//				| SWT.SEARCH | SWT.ICON_SEARCH | SWT.CANCEL);
//		searchText.setMessage("搜索:	Attr");
//		searchText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
//
//		searchText.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyReleased(KeyEvent keyEvent) {
//				attrFilter.setFilterText(searchText.getText());
//				attrTableViewer.refresh();
//			}
//		});
//
//		ToolBarManager toolBarManager = new ToolBarManager(SWT.FLAT);
//		Section section = (Section) composite.getParent();
//		ToolBar toolbar = toolBarManager.createControl(composite.getParent());
//		toolbar.setCursor(Display.getDefault().getSystemCursor(SWT.CURSOR_HAND));
//
//		Action action = new Action() {
//
//			@Override
//			public ImageDescriptor getImageDescriptor() {
//				return Activator.getDefault().getImageRegistry()
//						.getDescriptor("Add");
//			}
//
//			@Override
//			public void run() {
//				EObject eObject = null;
//				String appOrOsName = null;
//				String appOrOsType = null;
//				if (input instanceof IModel) {
//					eObject = ((IModel) input).getEObject();
//				}
//				if (eObject == null) {
//					return;
//				}
//				String type = ((SysConfigEClassImpl) (eObject.eClass()))
//						.getSysConfigComponent().getAttributeValue("type");
//
//				Resource resource = sysConfigFormPageEditor.getResource();
//				Collection collection = ModelQuery.queryAttrDefine(resource
//						.getContents().get(0));
//				EObject attrDefineEObject = (EObject) collection.iterator()
//						.next();
//				SysConfig sysConfig = (SysConfig) sysConfigFormPageEditor
//						.getAdapter(SysConfig.class);
//				EStructuralFeature attrFeature = attrDefineEObject.eClass()
//						.getEStructuralFeature(
//								attrDefineEObject.eClass().getName() + "Attr");
//				EClass attrEClass = (EClass) attrFeature.getEType();
//				attrEObject = sysConfig.getePackage().getEFactoryInstance()
//						.create(attrEClass);
//				attrEObject.eSet(attrEClass.getEStructuralFeature("name"),
//						"Attr");
//				attrEObject.eSet(attrEClass.getEStructuralFeature("valueType"),
//						"string");
//
//				EStructuralFeature appOrOsFeature = attrEClass
//						.getEStructuralFeature(attrEClass.getName() + "object");
//				if (type.equals("Host")) {
//					appOrOsName = SysConfigECoreUtil.getAttributeValue(eObject,
//							"ostype");
//					appOrOsType = "os";
//				} else if (type.equals("Object")) {
//					appOrOsName = SysConfigECoreUtil.getAttributeValue(eObject,
//							"name");
//					appOrOsType = "app";
//				}
//				EObject appOrOsEObject = sysConfig.getePackage()
//						.getEFactoryInstance()
//						.create((EClass) appOrOsFeature.getEType());
//				appOrOsEObject.eSet(appOrOsEObject.eClass()
//						.getEStructuralFeature("name"), appOrOsName);
//				appOrOsEObject.eSet(appOrOsEObject.eClass()
//						.getEStructuralFeature("type"), appOrOsType);
//
//				Object list = (attrEObject.eGet(appOrOsFeature));
//				if (appOrOsFeature.isMany()) {
//					((List<EObject>) list).add(appOrOsEObject);
//				}
//				EditingDomain editingDomain = sysConfigFormPageEditor
//						.getEditingDomain();
//				SysConfigAddCommand addCommand = new SysConfigAddCommand(
//						editingDomain, attrDefineEObject, attrFeature,
//						attrEObject, input);
//				editingDomain.getCommandStack().execute(addCommand);
//			}
//
//		};
//		toolBarManager.add(action);
//
//		Action deleteAction = new Action() {
//
//			@Override
//			public ImageDescriptor getImageDescriptor() {
//				return Activator.getDefault().getImageRegistry()
//						.getDescriptor("Delete");
//			}
//
//			@Override
//			public void run() {
//				EObject eObject = null;
//				if (input instanceof IModel) {
//					eObject = ((IModel) input).getEObject();
//				}
//				if (eObject == null) {
//					return;
//				}
//				IStructuredSelection selection = (IStructuredSelection) attrTableViewer
//						.getSelection();
//				EObject attrEObject = (EObject) selection.getFirstElement();
//
//				Resource resource = sysConfigFormPageEditor.getResource();
//				Collection collection = ModelQuery.queryAttrDefine(resource
//						.getContents().get(0));
//				EObject attrDefineEObject = (EObject) collection.iterator()
//						.next();
//				Collection attrCollection = ModelQuery
//						.queryAttrs(attrDefineEObject);
//				for (Iterator iter = attrCollection.iterator(); iter.hasNext();) {
//					if (iter.next() == attrEObject) {
//						EditingDomain editingDomain = sysConfigFormPageEditor
//								.getEditingDomain();
//						SysConfigDeleteCommand deleteCommand = new SysConfigDeleteCommand(
//								editingDomain,
//								Collections.singleton(attrEObject), input);
//						editingDomain.getCommandStack().execute(deleteCommand);
//						break;
//					}
//				}
//			}
//		};
//		toolBarManager.add(deleteAction);
//		toolBarManager.add(new Separator());
//
//		SysConfigConvertAttrAction sysConfigConvertAttrAction = new SysConfigConvertAttrAction(
//				"ConvertAttr");
//		toolBarManager.add(sysConfigConvertAttrAction);
//
//		toolBarManager.update(true);
//
//		section.setTextClient(toolbar);
//
//		Composite tableParentComposite = toolKit.createComposite(composite,
//				SWT.NULL);
//		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
//		gd.widthHint = 1;
//		tableParentComposite.setLayoutData(gd);
//		TableColumnLayout tableColumnLayout = new TableColumnLayout();
//		tableParentComposite.setLayout(tableColumnLayout);
//
//		attrTableViewer = new TableViewer(tableParentComposite,SWT.MULTI | SWT.H_SCROLL
//				| SWT.V_SCROLL | SWT.BORDER | SWT.FULL_SELECTION);
//		Table table = attrTableViewer.getTable();
//		gd = new GridData(SWT.FILL, SWT.FILL, true, true);
//		table.setHeaderVisible(true);
//		table.setLinesVisible(true);
//		table.setLayoutData(gd);
//		createAttrTableViewerColumns(attrTableViewer, attrs.get(0));
//
//		attrFilter = new AttrFilter();
//		attrTableViewer.addFilter(attrFilter);
//
//		attrTableViewer
//				.setContentProvider(new SysConfigDetailStructuredContentProvider());
//		attrTableViewer.setInput(attrs);

	}

	private void createAttrTableViewerColumns(TableViewer tableViewer,
			EObject attr) {
//		EList<EAttribute> attributes = SysConfigECoreUtil
//				.getAllAttributes(attr);
//
//		Composite composite = tableViewer.getTable().getParent();
//		TableColumnLayout tableColumnLayout = (TableColumnLayout) composite
//				.getLayout();
//
//		TableViewerColumn tableViewerColumn = new TableViewerColumn(
//				tableViewer, SWT.CENTER | SWT.BORDER | SWT.FULL_SELECTION
//						| SWT.MULTI);
//		tableViewerColumn
//				.setLabelProvider(new SysConfigTableCheckBoxColumnLabelProvider());
//		// tableViewerColumn.getColumn().setImage(
//		// Activator.getDefault().getImageRegistry().get("CheckBoxGroup"));
//		tableViewerColumn.getColumn().setText("!");
//		tableViewerColumn.getColumn().setResizable(false);
//		tableViewerColumn.setEditingSupport(new SysConfigCheckedEditingSupport(
//				tableViewer));
//		tableColumnLayout.setColumnData(tableViewerColumn.getColumn(),
//				new ColumnPixelData(21, false));
//
//		List<Node> attrList = ((SysConfigEClassImpl) attr.eClass())
//				.getSysConfigComponent().getAttributes();
//
//		for (int i = 0; i < attributes.size(); i++) {
//			EAttribute eAttribute = attributes.get(i);
//
//			String name = eAttribute.getName();
//			int style = SWT.LEFT;
//			if (name.equals("interval") || name.equals("maxintodb")) {
//				style = SWT.RIGHT;
//			}
//			tableViewerColumn = new TableViewerColumn(tableViewer, SWT.BORDER
//					| SWT.FULL_SELECTION | SWT.MULTI | style);
//
//			for (int j = 0; j < attrList.size(); j++) {
//				Node node = attrList.get(j);
//				if (name.equals(node.getAttributes().getNamedItem("type")
//						.getNodeValue())) {
//					Node descNode = node.getAttributes().getNamedItem("desc");
//					if (descNode != null) {
//						name = descNode.getNodeValue();
//						break;
//					}
//				}
//			}
//
//			TableColumn tableColumn = tableViewerColumn.getColumn();
//			tableColumn.setText(name);
//
//			tableViewerColumn
//					.setLabelProvider(new SysConfigTableColumnLabelProvider(
//							eAttribute, tableViewer));
//			CellEditor cellEditor = createCellEditor(eAttribute, tableViewer);
//
//			tableViewerColumn.setEditingSupport(new SysConfigEditingSupport(
//					sysConfigFormPageEditor, tableViewer, cellEditor,
//					eAttribute, input));
//
//			composite = tableViewer.getTable().getParent();
//			tableColumnLayout = (TableColumnLayout) composite.getLayout();
//			ColumnWeightData columnWeightData = new ColumnWeightData(1, 100,
//					true);
//			tableColumnLayout.setColumnData(tableColumn, columnWeightData);
//		}
	}

	private CellEditor createCellEditor(EAttribute eAttribute,
			TableViewer tableViewer) {
		if (eAttribute.getName().equals("valueType")) {
			return new ComboBoxCellEditor(tableViewer.getTable(), new String[] {
					"string", "int", "float", "percent" }, SWT.READ_ONLY);
		} else if (eAttribute.getName().equals("maxintodb")) {
			return new ComboBoxCellEditor(tableViewer.getTable(), new String[] {
					"true", "false" }, SWT.READ_ONLY);
		}
		return new TextCellEditor(tableViewer.getTable());
	}

//	public SysConfigFormPageEditor getSysConfigFormPageEditor() {
//		return sysConfigFormPageEditor;
//	}

	// private void createToolBars(Composite toolBarComposite, ToolBar toolBar)
	// {
	// GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
	// toolBar.setLayoutData(gd);
	// ToolItem item = new ToolItem(toolBar, SWT.PUSH);
	// item.setImage(Activator.getDefault().getImageRegistry().get("Add"));
	// item.addSelectionListener(new SelectionListener() {
	//
	// @Override
	// public void widgetSelected(SelectionEvent e) {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void widgetDefaultSelected(SelectionEvent e) {
	// // TODO Auto-generated method stub
	//
	// }
	// });
	// item = new ToolItem(toolBar, SWT.PUSH);
	// item.setImage(Activator.getDefault().getImageRegistry().get("Delete"));
	// item.setEnabled(false);
	//
	// new ToolItem(toolBar, SWT.SEPARATOR);
	//
	// item = new ToolItem(toolBar, SWT.PUSH);
	// item.setImage(Activator.getDefault().getImageRegistry().get("MoveUp"));
	// item.setEnabled(false);
	// item = new ToolItem(toolBar, SWT.PUSH);
	// item.setImage(Activator.getDefault().getImageRegistry().get("MoveDown"));
	// item.setEnabled(false);
	//
	// }
	//
	// @SuppressWarnings("unchecked")
	// private Map<EReference, EList<EObject>> createModels(
	// EList<EReference> references, EObject input) {
	// Map<EReference, EList<EObject>> modelMap = new LinkedHashMap<EReference,
	// EList<EObject>>();
	// for (EReference reference : references.toArray(new EReference[0])) {
	// Object object = ((EObject) input).eGet(reference);
	// modelMap.put(reference, (EList<EObject>) object);
	// }
	// return modelMap;
	// }
	//
	// private void createTableViewerColumns(TableViewer tableViewer,
	// Object input, EReference reference) {
	// EList<EAttribute> attributes = ((EClass) reference.getEType())
	// .getEAllAttributes();
	//
	// for (int i = 0; i < attributes.size(); i++) {
	// TableViewerColumn tableViewerColumn = new TableViewerColumn(
	// tableViewer, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
	// EAttribute eAttribute = attributes.get(i);
	// TableColumn tableColumn = tableViewerColumn.getColumn();
	// tableColumn.setText(eAttribute.getName());
	//
	// tableViewerColumn
	// .setLabelProvider(new SysConfigTableColumnLabelProvider(
	// eAttribute, tableViewer));
	// CellEditor cellEditor = createCellEditor();
	//
	// tableViewerColumn.setEditingSupport(new SysConfigEditingSupport(
	// sysConfigFormPageEditor, tableViewer, cellEditor,
	// eAttribute));
	//
	// Composite composite = tableViewer.getTable().getParent();
	// TableColumnLayout tableColumnLayout = (TableColumnLayout) composite
	// .getLayout();
	// ColumnWeightData columnWeightData = new ColumnWeightData(1, 100,
	// true);
	// tableColumnLayout.setColumnData(tableColumn, columnWeightData);
	// }
	// }

}
