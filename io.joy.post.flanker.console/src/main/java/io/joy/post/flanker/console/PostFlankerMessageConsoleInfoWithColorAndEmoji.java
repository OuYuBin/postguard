package io.joy.post.flanker.console;

import org.eclipse.swt.graphics.Color;

/**
 * 
 * @author robin
 *
 */
public enum PostFlankerMessageConsoleInfoWithColorAndEmoji implements IPostFlankerMessageConsoleInfo{

	START("开始", new Color(null, 23, 44, 60), "🚀"), ERROR("异常", new Color(null, 233, 30, 99), "❌"),
	END("结束", new Color(null, 21, 116, 52), "🏁️"), WARN("警告", new Color(null, 217, 104, 49), "⚠️️"),
	NORMAL("信息", new Color(null, 39, 72, 98), "💬️"), SUCCESS("成功",new Color(null,0,0,255),"👌");

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
