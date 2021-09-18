package com.gesila.test.guard.http;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpUriRequest;

import io.joy.post.flanker.console.IPostFlankerMessageConsoleStream;
import io.joy.post.flanker.console.PostFlankerMessageConsoleInfoWithColorAndEmoji;
import io.joy.post.flanker.console.factory.IPostFlankerConsoleFactory;
import io.joy.post.flanker.console.factory.impl.PostFlankerConsoleFactorImpl;

/**
 * 
 * @author robin
 *
 */
public abstract class AbstractPostFlankerHttpExecute implements IPostFlankerHttpExecute {

	public static final PostFlankerConsoleFactorImpl consoleFactory = IPostFlankerConsoleFactory.INSTANCE;

	protected IPostGuardHttpClient commonHttpClient;

	public AbstractPostFlankerHttpExecute(IPostGuardHttpClient commonHttpClient) {
		this.commonHttpClient = commonHttpClient;
	}

	public HttpResponse execute(HttpUriRequest request, PostGuardHttpClientContext postFlankerHttpClientContext)
			throws IOException, ClientProtocolException {
		consoleFactory.openConsole();
		IPostFlankerMessageConsoleStream consoleStream = consoleFactory.createPostFlankerMessageConsoleStream();
		HttpResponse response = null;
		try {
			consoleStream.println(PostFlankerMessageConsoleInfoWithColorAndEmoji.START,
					"正在请求服务: " + request.getURI().toURL());
			long startMillisTime = System.currentTimeMillis();
			response = commonHttpClient.getHttpClient().execute(request, postFlankerHttpClientContext);
			long totalMilliTime = System.currentTimeMillis() - startMillisTime;
			consoleStream.println(PostFlankerMessageConsoleInfoWithColorAndEmoji.NORMAL,
					"请求总耗时: " + totalMilliTime + "毫秒");
			consoleStream.println(PostFlankerMessageConsoleInfoWithColorAndEmoji.SUCCESS,
					"请求响应代码: " + response.getStatusLine().getStatusCode());
		} catch (Exception ex) {
			consoleStream.println(PostFlankerMessageConsoleInfoWithColorAndEmoji.ERROR, "请求异常: " + ex.getMessage());
			throw ex;
		}
		return response;
	}

	protected void createCookieStore(PostGuardHttpClientContext clientContext) {
		PostGuardLoginCookie.getInstance().createCookie(clientContext);
	}

}
