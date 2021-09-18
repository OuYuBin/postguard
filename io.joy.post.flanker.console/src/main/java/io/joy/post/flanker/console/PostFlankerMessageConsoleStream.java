package io.joy.post.flanker.console;

import java.text.SimpleDateFormat;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

/**
 * 
 * @author ouyubin
 *
 */
public class PostFlankerMessageConsoleStream extends MessageConsoleStream implements IPostFlankerMessageConsoleStream {

	public PostFlankerMessageConsoleStream(MessageConsole console) {
		super(console);
	}

	@Override
	public void println(String message) {
		super.println(message);
	}

	public void println(IPostFlankerMessageConsoleInfo postFlankerMessageConsoleColor, String message) {

		if (this.getConsole() instanceof PostFlankerMessageConsole) {
			Display.getDefault().asyncExec(new Runnable() {

				@Override
				public void run() {
					PostFlankerMessageConsole postFlankerMessageConsole = (PostFlankerMessageConsole) PostFlankerMessageConsoleStream.this.getConsole();
					// --print current time
					PostFlankerMessageConsoleStream timePrinter = postFlankerMessageConsole.newPostFlankerMessageConsoleStream();
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					timePrinter.print("[" + format.format(System.currentTimeMillis()));
					// --日志级别输出
					PostFlankerMessageConsoleStream levelPrinter = postFlankerMessageConsole.newPostFlankerMessageConsoleStream();
					levelPrinter.setFontStyle(1);
					levelPrinter.setColor(postFlankerMessageConsoleColor.getColor());
					levelPrinter.print(" " + postFlankerMessageConsoleColor.getInfo());
					timePrinter.print("] ");

					PostFlankerMessageConsoleStream messagePrinter = postFlankerMessageConsole.newPostFlankerMessageConsoleStream();
					messagePrinter.setColor(postFlankerMessageConsoleColor.getColor());
					String prefix = postFlankerMessageConsoleColor.getPrefix();
					if (prefix != null)
						levelPrinter.print(" " + postFlankerMessageConsoleColor.getPrefix());
					messagePrinter.println(message);

				}
			});
		}

	}
}
