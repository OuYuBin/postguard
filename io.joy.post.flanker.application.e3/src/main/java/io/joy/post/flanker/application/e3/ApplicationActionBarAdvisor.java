package io.joy.post.flanker.application.e3;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarContributionItem;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.actions.ContributionItemFactory;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.internal.ide.IDEWorkbenchMessages;


public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

	private IWorkbenchAction exitAction;
	private IWorkbenchAction aboutAction;
	private IWorkbenchAction newWindowAction;
	private IWorkbenchAction importAction;
	private IWorkbenchAction openPreferencesAction;
	
	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
	}

	@Override
	protected void makeActions(final IWorkbenchWindow window) {
		// Creates the actions and registers them.
		// Registering is needed to ensure that key bindings work.
		// The corresponding commands keybindings are defined in the plugin.xml
		// file.
		// Registering also provides automatic disposal of the actions when
		// the window is closed.

		exitAction = ActionFactory.QUIT.create(window);
		register(exitAction);

		aboutAction = ActionFactory.ABOUT.create(window);
		register(aboutAction);

		newWindowAction = ActionFactory.OPEN_NEW_WINDOW.create(window);
		register(newWindowAction);

		importAction = ActionFactory.IMPORT.create(window);
		register(importAction);

		openPreferencesAction = ActionFactory.PREFERENCES.create(window);
		register(openPreferencesAction);
	}

	@Override
	protected void fillMenuBar(IMenuManager menuBar) {
		MenuManager fileMenu = new MenuManager("&文件", IWorkbenchActionConstants.M_FILE);
		MenuManager windowsMenu = new MenuManager(IDEWorkbenchMessages.Workbench_window,
				IWorkbenchActionConstants.M_WINDOW);
		MenuManager helpMenu = new MenuManager("&帮助", IWorkbenchActionConstants.M_HELP);
		IWorkbenchWindow window = getActionBarConfigurer().getWindowConfigurer().getWindow();
		
		
		menuBar.add(fileMenu);
		// Add a group marker indicating where action set menus will appear.
		menuBar.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		menuBar.add(windowsMenu);
		menuBar.add(helpMenu);

		// File
		fileMenu.add(newWindowAction);
		fileMenu.add(new Separator());
		fileMenu.add(importAction);
		fileMenu.add(exitAction);

		MenuManager showViewMenu = new MenuManager("显示视图");
		IContributionItem item = ContributionItemFactory.VIEWS_SHORTLIST
				.create(getActionBarConfigurer().getWindowConfigurer().getWindow());
		showViewMenu.add(item);
		windowsMenu.add(showViewMenu);
		windowsMenu.add(openPreferencesAction);
		// Help
		helpMenu.add(aboutAction);
	}

	@Override
	protected void fillCoolBar(ICoolBarManager coolBar) {
		IToolBarManager toolbar = new ToolBarManager(SWT.FLAT | SWT.RIGHT);

		IWorkbenchWindow window = getActionBarConfigurer().getWindowConfigurer().getWindow();
		register(ActionFactory.NEW_WIZARD_DROP_DOWN.create(window));
		toolbar.add(getAction(ActionFactory.NEW_WIZARD_DROP_DOWN.getId()));

		coolBar.add(new ToolBarContributionItem(toolbar, "main"));
		// toolbar.add(openViewAction);
		// toolbar.add(messagePopupAction);
		coolBar.add(toolbar);
	}
}
