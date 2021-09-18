package com.gesila.test.guard.http;

import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecProvider;
import org.apache.http.protocol.HttpContext;

/**
 * 
 * @author robin
 *
 */
public class PostGuardCookieSpecProvider implements CookieSpecProvider {

	@Override
	public CookieSpec create(HttpContext context) {
		return new PostGuardCookieSpec();
	}

}
