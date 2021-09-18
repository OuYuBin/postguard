package io.joy.post.flanker.console.factory;

import org.eclipse.ui.console.IConsoleFactory;

import io.joy.post.flanker.console.factory.impl.PostFlankerConsoleFactorImpl;

/**
 * 
 * @author ouyubin
 *
 */
public interface IPostFlankerConsoleFactory extends IConsoleFactory {

	PostFlankerConsoleFactorImpl INSTANCE = PostFlankerConsoleFactorImpl.getInstance();
}
