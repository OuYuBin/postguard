package io.joy.post.flanker.ui.views;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.edit.EMFEditPlugin;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.source.CompositeRuler;
import org.eclipse.jface.text.source.LineNumberRulerColumn;
import org.eclipse.jface.text.source.projection.ProjectionAnnotationModel;
import org.eclipse.jface.text.source.projection.ProjectionSupport;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.internal.editors.text.EditorsPlugin;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.texteditor.ChainedPreferenceStore;
import org.eclipse.ui.texteditor.DefaultMarkerAnnotationAccess;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aptana.editor.common.CommonEditorPlugin;
import com.aptana.editor.common.ExtendedFastPartitioner;
import com.aptana.editor.common.IExtendedPartitioner;
import com.aptana.editor.common.NullPartitionerSwitchStrategy;
import com.aptana.editor.common.text.rules.CompositePartitionScanner;
import com.aptana.editor.common.text.rules.NullSubPartitionScanner;
import com.aptana.editor.common.viewer.CommonProjectionViewer;
import com.aptana.editor.html.HTMLPlugin;
import com.aptana.editor.html.HTMLSourceConfiguration;
import com.aptana.editor.json.JSONSourceConfiguration;
import com.aptana.editor.json.JSONSourceViewerConfiguration;
import com.gesila.test.guard.http.models.PostResponseInfo;
import com.gesila.test.guard.json.model.PostFlankerJSONObject;
import com.gesila.test.guard.json.model.PostFlankerJSONObject.Type;
import com.gesila.test.guard.json.utils.PostFlankerJSONUtils;
import com.gesila.test.guard.model.testGuard.TestGuard;

import io.joy.post.flanker.ui.Activator;

/**
 * 
 * @author robin
 *
 */
public class GsilaTestGuardResponseViewPart extends ViewPart implements IGesilaTestGuardViewPart {

	public static final String ID = "com.gesila.test.guard.ui.views.GsilaTestGuardResponseViewPart";

	private TreeViewer treeViewer;

	private CommonProjectionViewer commonProjectionViewer;

	private StyledText styledText;

	private Text text;

	private Form form;

	public GsilaTestGuardResponseViewPart() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {

		FormToolkit formToolkit = new FormToolkit(Display.getCurrent());
		form = formToolkit.createForm(parent);
		form.setText("响应");
		formToolkit.decorateFormHeading(form);
		Composite body = form.getBody();
		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		gridLayout.verticalSpacing = 1;
		gridLayout.horizontalSpacing = 0;
		body.setLayout(gridLayout);

		CTabFolder cTabFolder = new CTabFolder(body, SWT.NONE);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.widthHint = SWT.DEFAULT;
		gridData.heightHint = SWT.DEFAULT;
		cTabFolder.setLayoutData(gridData);

		CTabItem cTabItem = new CTabItem(cTabFolder, SWT.NONE);
		cTabItem.setImage(Activator.getDefault().getImageRegistry().get("text"));
		cTabItem.setText("文本");

		CompositeRuler ruler = new CompositeRuler();
		ProjectionAnnotationModel projectionAnnotationModel = new ProjectionAnnotationModel();
		ruler.setModel(projectionAnnotationModel);
		LineNumberRulerColumn lineCol = new LineNumberRulerColumn();
		lineCol.setBackground(new Color(Display.getCurrent(), 147, 224, 255));
		ruler.addDecorator(0, lineCol);

		Document document = new Document();
		document.set("{\n" + 
				"	\"id\": \"1\",\n" + 
				"	\"name\": \"test\"\n" + 
				"}");
		commonProjectionViewer = new CommonProjectionViewer(cTabFolder, ruler, null, false,
				SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		commonProjectionViewer.configure(new JSONSourceViewerConfiguration(getChainedPreferenceStore(), null));
		commonProjectionViewer.setDocument(document,projectionAnnotationModel);

		ProjectionSupport projectionSupport = new ProjectionSupport(commonProjectionViewer,
				new DefaultMarkerAnnotationAccess(), EditorsPlugin.getDefault().getSharedTextColors());
		projectionSupport.install();
		commonProjectionViewer.doOperation(ProjectionViewer.TOGGLE);
		CompositePartitionScanner partitionScanner = new CompositePartitionScanner(
				JSONSourceConfiguration.getDefault().createSubPartitionScanner(), new NullSubPartitionScanner(),
				new NullPartitionerSwitchStrategy());
		IDocumentPartitioner partitioner = new ExtendedFastPartitioner(partitionScanner,
				JSONSourceConfiguration.getDefault().getContentTypes());
		partitionScanner.setPartitioner((IExtendedPartitioner) partitioner);
		partitioner.connect(document);
		document.setDocumentPartitioner(partitioner);
		CommonEditorPlugin.getDefault().getDocumentScopeManager().registerConfiguration(document,
				HTMLSourceConfiguration.getDefault());

		styledText = commonProjectionViewer.getTextWidget();

		// 设置自动换行
		styledText.setWordWrap(true);
		styledText.setFont(JFaceResources.getTextFont());

		// text = formToolkit.createText(cTabFolder, null, SWT.BORDER |
		// SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.widthHint = SWT.DEFAULT;
		gridData.heightHint = SWT.DEFAULT;
		styledText.setLayoutData(gridData);
		cTabItem.setControl(commonProjectionViewer.getControl());

		CTabItem jsonCTabItem = new CTabItem(cTabFolder, SWT.NONE);
		jsonCTabItem.setImage(Activator.getDefault().getImageRegistry().get("json"));
		jsonCTabItem.setText("JSON");

		treeViewer = new TreeViewer(cTabFolder, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION | SWT.V_SCROLL);
		Tree tree = treeViewer.getTree();
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		TreeColumn descColumn = new TreeColumn(treeViewer.getTree(), SWT.NONE);
		descColumn.setWidth(100);
		descColumn.setText("描述");
		descColumn.setMoveable(true);

		TreeColumn column = new TreeColumn(treeViewer.getTree(), SWT.NONE);
		column.setWidth(150);
		column.setText("名称");

		TreeViewerColumn valueColumn = new TreeViewerColumn(treeViewer, SWT.NONE);
		valueColumn.getColumn().setWidth(260);
		valueColumn.getColumn().setText("值");

		valueColumn.setEditingSupport(new EditingSupport(treeViewer) {

			@Override
			protected void setValue(Object element, Object value) {

			}

			@Override
			protected Object getValue(Object element) {
				if (element instanceof PostFlankerJSONObject) {
					return ((PostFlankerJSONObject) element).getValue();
				}
				return null;
			}

			@Override
			protected CellEditor getCellEditor(Object element) {
				return null;
			}

			@Override
			protected boolean canEdit(Object element) {
				return true;
			}
		});

		treeViewer.setContentProvider(new ITreeContentProvider() {

			@Override
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

			}

			@Override
			public void dispose() {

			}

			@Override
			public boolean hasChildren(Object element) {
				if (getChildren(element).length > 0) {
					return true;
				}
				return false;
			}

			@Override
			public Object getParent(Object element) {
				return null;
			}

			@Override
			public Object[] getElements(Object inputElement) {
				return (Object[]) ((List) inputElement).toArray(new Object[0]);
			}

			@Override
			public Object[] getChildren(Object parentElement) {
				return ((PostFlankerJSONObject) parentElement).getPostFlankerJSONObjects().toArray(new Object[0]);
			}
		});
		treeViewer.setLabelProvider(new ITableLabelProvider() {

			@Override
			public void addListener(ILabelProviderListener listener) {

			}

			@Override
			public void dispose() {

			}

			@Override
			public boolean isLabelProperty(Object element, String property) {
				return false;
			}

			@Override
			public void removeListener(ILabelProviderListener listener) {

			}

			@Override
			public Image getColumnImage(Object element, int columnIndex) {
				String image = "full/obj16/GenericValue";
				switch (columnIndex) {
				case 0:
				case 1:
					return null;
				case 2:
					String name = ((PostFlankerJSONObject) element).getName();
					if (name.equals("_ApplicationId") || name.equals("_ApplicationKey")) {
						image = "full/obj16/IntegralValue.gif";
					}
					Type type = ((PostFlankerJSONObject) element).getType();
					if (type != null) {
						switch (type) {
						case BOOLEAN:
							return ExtendedImageRegistry.getInstance()
									.getImage(EMFEditPlugin.INSTANCE.getImage("full/obj16/BooleanValue.gif"));
						case NUMBER:
							return ExtendedImageRegistry.getInstance()
									.getImage(EMFEditPlugin.INSTANCE.getImage("full/obj16/IntegralValue.gif"));
						default:
							break;
						}
					}
					break;
				}
				return ExtendedImageRegistry.getInstance().getImage(EMFEditPlugin.INSTANCE.getImage(image));
			}

			@Override
			public String getColumnText(Object element, int columnIndex) {
				switch (columnIndex) {
				case 0:
					return ((PostFlankerJSONObject) element).getDesc() == null ? ""
							: ((PostFlankerJSONObject) element).getDesc();
				case 1:
					return ((PostFlankerJSONObject) element).getName() == null ? ""
							: ((PostFlankerJSONObject) element).getName();
				case 2:
					return ((PostFlankerJSONObject) element).getValue() == null ? ""
							: ((PostFlankerJSONObject) element).getValue();
				}
				return null;
			}

		});
		jsonCTabItem.setControl(tree);
		cTabFolder.setSelection(0);
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	@Override
	public void refresh(Object object, TestGuard testGuard) {
		Display.getDefault().asyncExec(() -> {
			List list = new ArrayList();
			if (object instanceof PostResponseInfo) {
				JSONObject jsonObject = PostFlankerJSONUtils
						.createJSONObject(((PostResponseInfo) object).getResponseInfo());
//				if (testGuard.getApi() != null)
//					PostFlankerJSONUtils.createPostFlankerJSONObject(jsonObject, list,
//							testGuard.getApi().getMethod().get(0).getResult().getElement().get(0));
//				else
				PostFlankerJSONUtils.createPostFlankerJSONObject(jsonObject, list);
				if (!list.isEmpty()) {
					Display display = Display.getCurrent();
					if (((PostResponseInfo) object).getStatusCode() != 200) {
						form.setForeground(new Color(null, 225, 37, 27));
					} else {
						form.setForeground(new Color(null, 38, 168, 114));
					}
					form.setText("响应 " + ((PostResponseInfo) object).getStatusCode());
					treeViewer.setInput(list);
					treeViewer.refresh(true);
					treeViewer.expandToLevel(3);
				}
				commonProjectionViewer.getDocument().set(JSON.toJSONString(jsonObject, true));
			}
		});

	}

	public static IPreferenceStore getChainedPreferenceStore() {
		return new ChainedPreferenceStore(new IPreferenceStore[] { HTMLPlugin.getDefault().getPreferenceStore(),
				CommonEditorPlugin.getDefault().getPreferenceStore(),
				EditorsPlugin.getDefault().getPreferenceStore() });
	}

}
