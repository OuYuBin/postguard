package io.joy.post.flanker.application.e3;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.console.IConsoleConstants;

/**
 * 
 * @author robin
 *
 */
public class Perspective implements IPerspectiveFactory {

	/**
	 * The ID of the perspective as specified in the extension.
	 */
	public static final String ID = "io.joy.post.flanker.application.e3.Perspective";

	@Override
	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		layout.setEditorAreaVisible(true);

		IFolderLayout leftLayout=layout.createFolder("left", IPageLayout.LEFT, 0.25f, editorArea);
		
		leftLayout.addView("com.gesila.test.guard.navigator.ui.views.GesilaTestGuardCommonNavigator");
		IFolderLayout leftBottomLayout=layout.createFolder("leftBottom", IPageLayout.BOTTOM, 0.80F, "left");
		leftBottomLayout.addView("com.keliangtek.simulab.target.ui.views.SimulabTargetView");
		
		
		layout.addView("com.gesila.test.guard.ui.views.GsilaTestGuardResponseViewPart", IPageLayout.RIGHT,
				0.60f, editorArea);

		IFolderLayout bottom= layout.createFolder("left", IPageLayout.BOTTOM, 0.80F, editorArea);
		bottom.addView("com.gesila.test.guard.ui.views.TestGuardPropertyPageBookView");
		bottom.addView(IConsoleConstants.ID_CONSOLE_VIEW);
		bottom.addView("org.eclipse.ui.views.ProgressView");
		// IFolderLayout folder = layout.createFolder("messages",
		// IPageLayout.TOP, 0.5f, editorArea);
		// folder.addPlaceholder(View.ID + ":*");
		// folder.addView(View.ID);
		//
		// layout.getViewLayout(NavigationView.ID).setCloseable(false);
		layout.addNewWizardShortcut("com.gesila.test.guard.navigator.ui.wizards.GesilaTestGuardNewProjectWizard");

	}
}
