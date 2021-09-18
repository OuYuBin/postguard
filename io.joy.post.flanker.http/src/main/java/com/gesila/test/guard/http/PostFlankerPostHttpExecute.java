package com.gesila.test.guard.http;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

/**
 * 
 * @author ouyubin
 *
 */
public class PostFlankerPostHttpExecute extends AbstractPostFlankerHttpExecute {

	public PostFlankerPostHttpExecute(IPostGuardHttpClient commonHttpClient) {
		super(commonHttpClient);
	}

	@Override
	public HttpResponse execute() throws IOException, ClientProtocolException {
		String url = (String) commonHttpClient.getUrl();
		HttpPost httpPost = new HttpPost(url);
		PostGuardHttpClientContext postFlankerHttpClientContext;
		if (PostGuardLoginCookie.getInstance().getPostHttpClientContext() != null) {
			postFlankerHttpClientContext = PostGuardLoginCookie.getInstance().getPostHttpClientContext();
		} else {
			postFlankerHttpClientContext = new PostGuardHttpClientContext();
		}
		// --设定请求链接超时时间和传输超时时间以及cookie策略
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(30000).setConnectTimeout(20000)
				.setCookieSpec("postGuardCookieSpec").build();
		httpPost.setConfig(requestConfig);

		Map<String, String> headerMap = commonHttpClient.getHeaderMap();
		for (Iterator<Map.Entry<String, String>> iter = headerMap.entrySet().iterator(); iter.hasNext();) {
			Map.Entry<String, String> entry = iter.next();
			httpPost.addHeader(entry.getKey(), entry.getValue());
		}

		HttpEntity httpEntity = commonHttpClient.getHttpEntity();
		if (httpEntity != null) {
			httpPost.setEntity(httpEntity);
		}

		String requestJSON = commonHttpClient.getRequestJSON();
		if (requestJSON != null) {
			StringEntity se = new StringEntity(requestJSON, ContentType.APPLICATION_JSON);
			httpPost.setEntity(se);
		}
		HttpResponse response=super.execute(httpPost,postFlankerHttpClientContext);
		if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK
				|| response.getStatusLine().getStatusCode() == HttpStatus.SC_MOVED_TEMPORARILY) {
			createCookieStore(postFlankerHttpClientContext);
		}

		return response;
	}
}
