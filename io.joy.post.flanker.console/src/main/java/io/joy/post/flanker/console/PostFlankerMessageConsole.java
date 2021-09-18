package io.joy.post.flanker.console;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.console.MessageConsole;

/**
 * 
 * @author robin
 *
 */
public class PostFlankerMessageConsole extends MessageConsole {

	public PostFlankerMessageConsole(String name, ImageDescriptor imageDescriptor) {
		super(name, imageDescriptor);
	}

	public PostFlankerMessageConsoleStream newPostFlankerMessageConsoleStream() {
		PostFlankerMessageConsoleStream postFlankerMessageConsoleStream = new PostFlankerMessageConsoleStream(this);
		postFlankerMessageConsoleStream.setEncoding("utf-8");
		return postFlankerMessageConsoleStream;
	}
}
