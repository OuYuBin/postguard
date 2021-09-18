package io.joy.post.flanker.project.fileInput;

import org.eclipse.core.resources.IFile;
import org.eclipse.ui.part.FileEditorInput;

import io.joy.post.flanker.project.models.IPostFlankerProjectElement;

/**
 * 
 * @author robin
 *
 */

public class GesilaTestGuardFileInput extends FileEditorInput {

	IPostFlankerProjectElement gesilaTestGuardProjectElement;

	public GesilaTestGuardFileInput(IFile file) {
		super(file);
	}

	public IPostFlankerProjectElement getGesilaTestGuardProjectElement() {
		return gesilaTestGuardProjectElement;
	}

	public void setGesilaTestGuardProjectElement(IPostFlankerProjectElement gesilaTestGuardProjectElement) {
		this.gesilaTestGuardProjectElement = gesilaTestGuardProjectElement;
	}

}
