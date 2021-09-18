package io.joy.post.flanker.console.factory.impl;

import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;

import io.joy.post.flanker.console.IPostFlankerMessageConsoleStream;
import io.joy.post.flanker.console.PostFlankerMessageConsole;
import io.joy.post.flanker.console.factory.IPostFlankerConsoleFactory;


/**
 * 
 * @author ouyubin
 *
 */
public class PostFlankerConsoleFactorImpl implements IPostFlankerConsoleFactory {

	private static PostFlankerMessageConsole console = new PostFlankerMessageConsole("PostFlanker 输出", null);
	
	private static PostFlankerConsoleFactorImpl INSTANCE=new PostFlankerConsoleFactorImpl();
	
	private PostFlankerConsoleFactorImpl() {

	}
	
	public static PostFlankerConsoleFactorImpl getInstance() {
		return INSTANCE;
	}

	@Override
	public void openConsole() {
		if (console != null) {
			IConsoleManager manager = ConsolePlugin.getDefault().getConsoleManager();
			IConsole[] existing = manager.getConsoles();
			boolean exist = false;
			for (int i = 0; i < existing.length; i++) {
				if (console == existing[i]) {
					exist = true;
				}
			}
			if (!exist) {
				manager.addConsoles(new IConsole[] { console });
			}
			manager.showConsoleView(console);

		}
	}

	public static PostFlankerMessageConsole getConsole() {
		return console;
	}

	public IPostFlankerMessageConsoleStream createPostFlankerMessageConsoleStream() {
		this.openConsole();
		PostFlankerMessageConsole postFlankerMessageConsoleConsole = getConsole();
		return postFlankerMessageConsoleConsole.newPostFlankerMessageConsoleStream();

	}

}
