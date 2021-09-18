package com.gesila.test.guard.http;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.conn.HttpHostConnectException;

/**
 * 
 * @author robin
 *
 */
public class PostGuardHttpClientUtil {

	public static Object execute(IPostGuardHttpClient commonHttpClient)
			throws IOException, ClientProtocolException, HttpHostConnectException {
		IPostFlankerHttpExecute httpExectue = createExectue(commonHttpClient);
		Object result = httpExectue.execute();
		return result;
	}

	private static IPostFlankerHttpExecute createExectue(IPostGuardHttpClient commonHttpClient) {
		String requestType = commonHttpClient.getRequestMethod();
		IPostFlankerHttpExecute httpExectue = null;
		if (requestType.equals(IPostGuardHttpClient.POST_METHOD)) {
			httpExectue = new PostFlankerPostHttpExecute(commonHttpClient);
		} else if (requestType.equals(IPostGuardHttpClient.METHOD_PUT)) {
			httpExectue = new PostGuardPutHttpExecute(commonHttpClient);
		} else if (requestType.equals(IPostGuardHttpClient.METHOD_DELETE)) {
			httpExectue = new PostGuardDeleteHttpExecute(commonHttpClient);
		} else{
			httpExectue = new PostGuardGetHttpExecute(commonHttpClient);
		}
		return httpExectue;
	}

}
