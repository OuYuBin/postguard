package com.gesila.test.guard.http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultRedirectStrategy;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 * 
 * 
 * @author robin
 *
 */
public class PostGuardHttpClient implements IPostGuardHttpClient {

	private Object url;

	private String requestJSON;

	private String requestMethod;

	private HttpEntity httpEntity;

	private Map<String, String> headerMap = new HashMap<String, String>();

	private HttpClientBuilder httpClientBuilder;

	private CloseableHttpClient httpClient;

	class EdiRedirectStrategy extends DefaultRedirectStrategy {
		private String[] REDIRECT_METHODS = new String[] { HttpGet.METHOD_NAME, HttpPost.METHOD_NAME,
				HttpHead.METHOD_NAME };

		@Override
		protected boolean isRedirectable(String method) {
			for (String m : REDIRECT_METHODS) {
				if (m.equalsIgnoreCase(method)) {
					return true;
				}
			}
			return false;
		}
	}

	public PostGuardHttpClient() {
		this(null);
	}

	public PostGuardHttpClient(Object url) {
		this(url, "GET");
	}

	public PostGuardHttpClient(Object url, String requestMethod) {
		this.url = url;
		this.requestMethod = requestMethod;
	}

	public PostGuardHttpClient(String baseUrl, String requestMethod, String... parameters) {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(baseUrl);
		stringBuffer.append("?");
		if (parameters != null) {
			int i = 0;
			for (String parameter : parameters) {
				if (i % 2 != 0) {
					stringBuffer.append(encodeParameter(parameter));
					stringBuffer.append("&");
				} else {
					stringBuffer.append(parameter);
					stringBuffer.append("=");
				}
				i++;
			}
		}
		this.url = stringBuffer.toString().substring(0, stringBuffer.toString().length() - 1);
		this.requestMethod = requestMethod;
	}

	private String encodeParameter(String parameter) {
		try {
			return URLEncoder.encode(parameter, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;

	}

	public HttpClient getHttpClient() {
		HttpClientBuilder builder = getHttpClientBuilder();
		return builder.build();
	}

	public HttpClientBuilder getHttpClientBuilder() {
		if (httpClientBuilder == null) {
			httpClientBuilder = HttpClientBuilder.create();
		}
		return httpClientBuilder;
	}

	public Object getUrl() {
		return url;
	}

	public void setUrl(Object url) {
		this.url = url;
	}

	public String getRequestJSON() {
		return requestJSON;
	}

	public void setRequestJSON(String requestJSON) {
		this.requestJSON = requestJSON;
	}

	public String getRequestMethod() {
		return requestMethod;
	}

	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}

	public HttpEntity getHttpEntity() {
		return httpEntity;
	}

	public void setHttpEntity(HttpEntity httpEntity) {
		this.httpEntity = httpEntity;
	}

	public Map<String, String> getHeaderMap() {
		if (headerMap == null) {
			headerMap = new HashMap<String, String>();
		}
		return headerMap;
	}

	public void setHeaderMap(Map<String, String> headerMap) {
		this.headerMap = headerMap;
	}

	public void close() throws IOException {
		if (httpClient != null) {
			httpClient.close();
		}
	}
}
