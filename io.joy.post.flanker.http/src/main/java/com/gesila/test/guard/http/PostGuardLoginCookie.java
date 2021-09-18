package com.gesila.test.guard.http;

import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.client.CookieStore;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.cookie.CookieSpecProvider;
import org.apache.http.impl.cookie.BasicClientCookie;

/**
 * 
 * @author ouyubin
 *
 */
public class PostGuardLoginCookie {

	public static final PostGuardLoginCookie INSTANCE = new PostGuardLoginCookie();

	private PostGuardHttpClientContext postHttpClientContext;
	private String user;

	private PostGuardLoginCookie() {

	}

	public static PostGuardLoginCookie getInstance() {
		return INSTANCE;
	}

	public synchronized void createCookie(PostGuardHttpClientContext postHttpClientContext) {
		if (this.postHttpClientContext == null) {
			Header[] headers = postHttpClientContext.getResponse().getAllHeaders();
			if (headers.length == 0) {
				return;
			} else {
				CookieStore cookieStore = postHttpClientContext.getCookieStore();
				for (Header header : headers) {
					HeaderElement[] headerElements = header.getElements();
					for (HeaderElement headerElement : headerElements) {
						String name = headerElement.getName();
						if (StringUtils.equals(name, "erp1.jd.com")) {
							String erpId = headerElement.getValue();
							cookieStore.addCookie(new BasicClientCookie("erp1.jd.com", erpId));
						} else if (StringUtils.equals(name, "sso.jd.com")) {
							String ssoId = headerElement.getValue();
							cookieStore.addCookie(new BasicClientCookie("sso.jd.com", ssoId));
						}
					}
					this.postHttpClientContext = postHttpClientContext;
					Registry<CookieSpecProvider> registry = RegistryBuilder.<CookieSpecProvider>create()
							.register("postGuardCookieSpec", new PostGuardCookieSpecProvider()).build();
					postHttpClientContext.setCookieSpecRegistry(registry);
					String uuid = UUID.randomUUID().toString();
					BasicClientCookie lcpInfoCookie = new BasicClientCookie("lcpinfo", uuid.replace("-", ""));
					cookieStore.addCookie(lcpInfoCookie);
				}
			}
		}
	}

	public String getUser() {
		return user;
	}

	public void setUser(String currentUser) {
		this.user = currentUser;
	}

	public void reset() {
		this.postHttpClientContext = null;
	}

	public PostGuardHttpClientContext getPostHttpClientContext() {
		return postHttpClientContext;
	}

}
