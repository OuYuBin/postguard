package com.aptana.editor.json.cn.enflame.viewer.json;

import java.util.Collection;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.reconciler.IReconciler;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.texteditor.spelling.SpellingService;

import com.aptana.editor.common.AbstractThemeableEditor;
import com.aptana.editor.common.spelling.MultiRegionSpellingReconcileStrategy;
import com.aptana.editor.common.text.reconciler.CompositeReconcilingStrategy;
import com.aptana.editor.json.JSONSourceViewerConfiguration;

/**
 * 
 * @author robin
 *
 */
public class EnflameJSONSourceViewerConfiguration extends JSONSourceViewerConfiguration {

	public EnflameJSONSourceViewerConfiguration(IPreferenceStore preferences, AbstractThemeableEditor editor) {
		super(preferences, editor);
	}

	public EnflameJSONSourceViewerConfiguration(IPreferenceStore preferences) {
		this(preferences, null);
	}

	@Override
	public IReconciler getReconciler(ISourceViewer sourceViewer) {
		IReconcilingStrategy reconcilingStrategy = new EnflameJSONReconcilingStrategy(sourceViewer);
//		((EnflameJSONReconcilingStrategy)reconcilingStrategy).setSourceViewe(sourceViewer);
		if (EditorsUI.getPreferenceStore().getBoolean(SpellingService.PREFERENCE_SPELLING_ENABLED)) {
			SpellingService spellingService = EditorsUI.getSpellingService();
			Collection<String> spellingContentTypes = getSpellingContentTypes(sourceViewer);
			if (spellingService.getActiveSpellingEngineDescriptor(fPreferenceStore) != null
					&& !spellingContentTypes.isEmpty()) {
				reconcilingStrategy = new CompositeReconcilingStrategy(reconcilingStrategy,
						new MultiRegionSpellingReconcileStrategy(sourceViewer, spellingService,
								getConfiguredDocumentPartitioning(sourceViewer), spellingContentTypes));
			}
		}
		EnflameReconciler reconciler = new EnflameReconciler(reconcilingStrategy);
		reconciler.setDocumentPartitioning(getConfiguredDocumentPartitioning(sourceViewer));
		reconciler.setIsIncrementalReconciler(false);
		reconciler.setIsAllowedToModifyDocument(false);
		reconciler.setProgressMonitor(new NullProgressMonitor());
		reconciler.setDelay(500);
		fReconciler = reconciler;;
		return reconciler;
	}
}
