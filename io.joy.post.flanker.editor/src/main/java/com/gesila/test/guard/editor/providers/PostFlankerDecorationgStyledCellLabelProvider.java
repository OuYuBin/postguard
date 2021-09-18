package com.gesila.test.guard.editor.providers;

import org.eclipse.jface.viewers.DecoratingStyledCellLabelProvider;
import org.eclipse.jface.viewers.IDecorationContext;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.StyledString;

/**
 * 
 * @author robin
 * 
 */
public class PostFlankerDecorationgStyledCellLabelProvider extends
		DecoratingStyledCellLabelProvider {

	public PostFlankerDecorationgStyledCellLabelProvider(
			IStyledLabelProvider labelProvider, ILabelDecorator decorator,
			IDecorationContext decorationContext) {
		super(labelProvider, decorator, decorationContext);
	}

	@Override
	public StyledString getStyledText(Object object) {
		return getStyledStringProvider().getStyledText(object);
	}

}
