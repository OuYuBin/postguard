package com.gesila.test.guard.editor.pages.providers;

import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IDetailsPageProvider;

import com.gesila.test.guard.editor.PostFlankerFormEditor;
import com.gesila.test.guard.editor.pages.PostFlankerApiDocDetailsPage;


/**
 * 
 * @author robin
 *
 */
public class PostFlankerApiDocDetailsPageProvider implements IDetailsPageProvider {

	
	PostFlankerFormEditor postFlankerFormPageEditor;
	
	public PostFlankerApiDocDetailsPageProvider(PostFlankerFormEditor postFlankerFormPageEditor){
		this.postFlankerFormPageEditor=postFlankerFormPageEditor;
	}
	
	@Override
	public Object getPageKey(Object object) {
		return object;
	}

	@Override
	public IDetailsPage getPage(Object key) {
		return new PostFlankerApiDocDetailsPage(key,postFlankerFormPageEditor);
	}

}
