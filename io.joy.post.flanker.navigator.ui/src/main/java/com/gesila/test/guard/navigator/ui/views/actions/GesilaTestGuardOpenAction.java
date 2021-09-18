package com.gesila.test.guard.navigator.ui.views.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.SelectionListenerAction;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.FileEditorInput;

import com.gesila.test.guard.editor.input.GesilaTestGuardLibraryEditorInput;

import io.joy.post.flanker.project.models.IPostFlankerProjectElement;
import io.joy.post.flanker.project.models.impl.PostFlankerTestGuard;
import io.joy.post.flanker.project.models.impl.PostFlankerLibrary;

/**
 * 
 * @author robin
 *
 */
public class GesilaTestGuardOpenAction extends SelectionListenerAction {

	IWorkbenchWindow workbenchWindow;

	public GesilaTestGuardOpenAction(String text, IWorkbenchWindow workbenchWindow) {
		super(text);
		this.workbenchWindow = workbenchWindow;
	}

	@Override
	public void run() {
		super.run();
		try {
			IStructuredSelection selection = getStructuredSelection();
			Object object = selection.getFirstElement();
			if (object instanceof PostFlankerTestGuard || object instanceof PostFlankerLibrary) {
				IPath path = ((IPostFlankerProjectElement) object).getAdapter(IPath.class);
				IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
				if (file.exists()) {
					IWorkbenchPage page = workbenchWindow.getActivePage();
					if (page != null) {
						IEditorDescriptor editorDesc = null;
						try {
							editorDesc = IDE.getEditorDescriptor(file, true, true);
						} catch (OperationCanceledException ex) {
							ex.printStackTrace();
						}
						if (object instanceof PostFlankerLibrary) {
							page.openEditor(new GesilaTestGuardLibraryEditorInput(file), editorDesc.getId(), true);
						} else {
							page.openEditor(new FileEditorInput(file), editorDesc.getId(), true);
						}
						// IDE.openEditor(page, file, true);
					}
					// IFileStore fileStore =
					// EFS.getLocalFileSystem().getStore(file.getLocationURI());
					// IEditorInput editorInput = new
					// FileStoreEditorInput(fileStore);
					// workbenchWindow.getActivePage().openEditor(editorInput,
					// "com.gesila.test.guard.editor.GesilaTestGuardEditor");
				}
			}
		} catch (PartInitException e) {
			e.printStackTrace();
		}
	}

}
