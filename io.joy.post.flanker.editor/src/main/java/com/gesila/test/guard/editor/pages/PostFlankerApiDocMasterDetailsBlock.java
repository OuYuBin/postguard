package com.gesila.test.guard.editor.pages;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.forms.DetailsPart;
import org.eclipse.ui.forms.IDetailsPageProvider;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.MasterDetailsBlock;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
//import org.eclipse.ui.internal.ide.dialogs.RelativePathVariableGroup.IModel;

import com.gesila.test.guard.editor.Activator;
import com.gesila.test.guard.editor.PostFlankerFormEditor;
import com.gesila.test.guard.editor.decorator.PostFlankerApiDocLabelDecorator;
import com.gesila.test.guard.editor.pages.providers.PostFlankerApiDocDetailsPageProvider;
import com.gesila.test.guard.editor.providers.PostFlankerApiDocContentProvider;
import com.gesila.test.guard.editor.providers.PostFlankerApiDocLabelProvider;
import com.gesila.test.guard.editor.providers.PostFlankerDecorationgStyledCellLabelProvider;
import com.gesila.test.guard.model.testGuard.TestGuard;

/**
 * 
 * @author robin
 * 
 */
public class PostFlankerApiDocMasterDetailsBlock extends MasterDetailsBlock {

	private PostFlankerFormEditor postFlankerFormPageEditor;

	private PostFlankerApiDocFormPage postFlankerApiDocFormPage;

	private TreeViewer treeViewer;

	private IDetailsPageProvider detailsPageProvider;

	// private HostConfigFilter hostConfigFilter;

	public PostFlankerApiDocMasterDetailsBlock(FormPage formPage, FormEditor formEditor) {
		this.postFlankerApiDocFormPage = (PostFlankerApiDocFormPage) formPage;
		this.postFlankerFormPageEditor = (PostFlankerFormEditor) formEditor;
		this.detailsPageProvider = new PostFlankerApiDocDetailsPageProvider(postFlankerFormPageEditor);
	}

	@Override
	protected void createMasterPart(final IManagedForm managedForm, Composite parent) {
		FormToolkit formToolkit = managedForm.getToolkit();
		Section section = formToolkit.createSection(parent, Section.EXPANDED | Section.TITLE_BAR);
		section.setText("API结构");
		section.clientVerticalSpacing = 0;
		section.marginWidth = 5;
		section.marginHeight = 5;

		ToolBarManager toolBarManager = new ToolBarManager(SWT.FLAT);
		ToolBar toolbar = toolBarManager.createControl(section);
		toolbar.setCursor(Display.getDefault().getSystemCursor(SWT.CURSOR_HAND));

		toolBarManager.add(new Action("Collapseall", SWT.CHECK) {

			@Override
			public ImageDescriptor getImageDescriptor() {
				return Activator.getDefault().getImageRegistry().getDescriptor("Collapseall");
			}

			@Override
			public void run() {
				super.run();
				treeViewer.expandToLevel(2);
			}

		});

		toolBarManager.add(new Action("ToggleExpandState", SWT.CHECK) {

			@Override
			public ImageDescriptor getImageDescriptor() {
				return Activator.getDefault().getImageRegistry().getDescriptor("ToggleExpandState");
			}

			@Override
			public void run() {
				super.run();
				if (this.isChecked())
					treeViewer.expandAll();
				else
					treeViewer.collapseAll();
			}

		});

		// toolBarManager.update(true);
		section.setTextClient(toolbar);

		Composite client = formToolkit.createComposite(section, SWT.WRAP);
		GridLayout layout = new GridLayout();
		layout.marginHeight = 2;
		client.setLayout(layout);

		// --搜索
		final Text searchText = formToolkit.createText(client, "",
				SWT.BORDER | SWT.SEARCH | SWT.ICON_SEARCH | SWT.CANCEL);
		searchText.setMessage("搜索: API");
		searchText.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		searchText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent keyEvent) {
				if (keyEvent.keyCode == SWT.ESC) {
					// hostConfigFilter.setFilterText("");
				} else {
					// hostConfigFilter.setFilterText(searchText.getText());
				}
				treeViewer.refresh();
				treeViewer.expandToLevel(2);
			}
		});

		// --结构树
		Tree tree = formToolkit.createTree(client, SWT.FULL_SELECTION);
		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
		gd.widthHint = 20;
		gd.heightHint = 20;
		tree.setLayoutData(gd);
		treeViewer = new TreeViewer(tree);
		// hostConfigFilter = new HostConfigFilter();
		// treeViewer.addFilter(hostConfigFilter);
		treeViewer.setContentProvider(new PostFlankerApiDocContentProvider());
		PostFlankerApiDocLabelDecorator postFlankerApiDocLabelDecorator = new PostFlankerApiDocLabelDecorator();
		PostFlankerApiDocLabelProvider postFlankerApiDocLabelProvider = new PostFlankerApiDocLabelProvider();
		treeViewer.setLabelProvider(new PostFlankerDecorationgStyledCellLabelProvider(postFlankerApiDocLabelProvider,
				postFlankerApiDocLabelDecorator, null));
		Resource resource = postFlankerFormPageEditor.getAdapter(Resource.class);
		TestGuard testGuard = (TestGuard) resource.getContents().get(0);
		//api myApi = testGuard.getApi();
//		Resource resource = sysConfigFormPageEditor.getResource();
//		RootModel rootModel = SysConfigModelManager
//				.createHostConfigRootModel(resource);
//		List list=new ArrayList();
//		list.add(myApi);
//		treeViewer.setInput(list);
		formToolkit.paintBordersFor(client);

		section.setClient(client);

		final SectionPart sectionPart = new SectionPart(section);

		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				managedForm.fireSelectionChanged(sectionPart, event.getSelection());

			}
		});

		treeViewer.addDoubleClickListener(new IDoubleClickListener() {
			@Override
			public void doubleClick(DoubleClickEvent event) {
				Object object = ((StructuredSelection) event.getSelection()).getFirstElement();
//				if (object instanceof IModel) {
//					if (treeViewer.getExpandedState(object)) {
//						treeViewer.collapseToLevel(object, 1);
//					} else {
//						treeViewer.expandToLevel(object, 1);
//					}
//				}
			}

		});
//		treeViewer.setSelection(new StructuredSelection(
//				new Object[] { treeViewer.getTree().getItem(0).getData() }));
		treeViewer.getTree().forceFocus();
		treeViewer.expandToLevel(2);
		createContextMenu(treeViewer);
		managedForm.addPart(sectionPart);
	}

	private void createContextMenu(TreeViewer treeViewer) {
		MenuManager contextMenu = new MenuManager("#PopUP");
		contextMenu.add(new Separator("additions"));
		contextMenu.setRemoveAllWhenShown(true);
		// contextMenu.addMenuListener(sysConfigFormPageEditor);
		Menu menu = contextMenu.createContextMenu(treeViewer.getControl());
		treeViewer.getControl().setMenu(menu);

	}

	@Override
	public void createContent(IManagedForm managedForm) {
		super.createContent(managedForm);
		this.sashForm.setWeights(new int[] { 40, 60 });
	}

	@Override
	protected void registerPages(DetailsPart detailsPart) {
		detailsPart.setPageProvider(detailsPageProvider);
	}

	@Override
	protected void createToolBarActions(IManagedForm managedForm) {
		// TODO Auto-generated method stub

	}

	public TreeViewer getTreeViewer() {
		return treeViewer;
	}

	public void setTreeViewer(TreeViewer treeViewer) {
		this.treeViewer = treeViewer;
	}

}
