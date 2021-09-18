package io.joy.post.flanker.console;

import org.eclipse.swt.graphics.Color;

/**
 * 
 * @author robin
 *
 */
public enum PostFlankerMessageConsoleInfoWithColor implements IPostFlankerMessageConsoleInfo{

	START("INFO", new Color(null, 23, 44, 60)), ERROR("ERROR", new Color(null, 233, 30, 99)),
	END("INFO", new Color(null, 21, 116, 52)), WARN("WARN", new Color(null, 217, 104, 49)),
	NORMAL("INFO", new Color(null, 39, 72, 98)), SUCCESS("INFO", new Color(null, 0, 0, 255));

	Color color;

	String info;

	PostFlankerMessageConsoleInfoWithColor(String info, Color color) {
		this.color = color;
		this.info = info;
	}

	public String getInfo() {
		return info;
	}

	public Color getColor() {
		return color;
	}

	@Override
	public String getPrefix() {
		return null;
	}

}
