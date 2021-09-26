package com.aptana.editor.json.cn.enflame.viewer.json;

import org.eclipse.jface.text.IDocument;

import com.aptana.editor.common.AbstractThemeableEditor;
import com.aptana.editor.json.internal.text.JSONFoldingComputer;

/**
 * 
 * @author robin
 *
 */
public class EnflameJSONFoldingComputer extends JSONFoldingComputer {

	public EnflameJSONFoldingComputer(AbstractThemeableEditor editor, IDocument document) {
		super(editor, document);
	}
	
	public EnflameJSONFoldingComputer(IDocument document) {
		this(null,document);
	}

}
