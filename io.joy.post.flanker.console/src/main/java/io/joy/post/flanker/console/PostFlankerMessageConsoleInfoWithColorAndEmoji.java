package io.joy.post.flanker.console;

import org.eclipse.swt.graphics.Color;

/**
 * 
 * @author robin
 *
 */
public enum PostFlankerMessageConsoleInfoWithColorAndEmoji implements IPostFlankerMessageConsoleInfo{

	START("ĺźĺ§", new Color(null, 23, 44, 60), "đ"), ERROR("ĺźĺ¸¸", new Color(null, 233, 30, 99), "â"),
	END("çťć", new Color(null, 21, 116, 52), "đď¸"), WARN("č­Śĺ", new Color(null, 217, 104, 49), "â ď¸ď¸"),
	NORMAL("äżĄćŻ", new Color(null, 39, 72, 98), "đŹď¸"), SUCCESS("ćĺ",new Color(null,0,0,255),"đ");

	Color color;

	String info;

	String prefix;

	PostFlankerMessageConsoleInfoWithColorAndEmoji(String info, Color color, String emoji) {
		this.color = color;
		this.info = info;
		this.prefix=emoji;
	}

	public String getInfo() {
		return info;
	}

	public Color getColor() {
		return color;
	}

	public String getPrefix() {
		return prefix;
	}

}
