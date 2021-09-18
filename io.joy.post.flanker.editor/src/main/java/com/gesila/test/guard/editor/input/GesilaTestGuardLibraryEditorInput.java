package com.gesila.test.guard.editor.input;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.part.FileEditorInput;

/**
 * 
 * @author robin
 *
 */
public class GesilaTestGuardLibraryEditorInput extends FileEditorInput {
	
	
	public GesilaTestGuardLibraryEditorInput(IFile file) {
		super(file);
	}


}
