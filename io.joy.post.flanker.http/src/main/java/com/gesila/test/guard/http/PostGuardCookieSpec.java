package com.gesila.test.guard.http;

import java.util.List;

import org.apache.http.Header;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.impl.cookie.DefaultCookieSpec;

/**
 * 
 * @author robin
 *
 */
public class PostGuardCookieSpec extends DefaultCookieSpec implements CookieSpec {

	@Override
	public int getVersion() {
		return 0;
	}

	@Override
	public List<Cookie> parse(Header header, CookieOrigin origin) throws MalformedCookieException {
		return super.parse(header, origin);
	}

	@Override
	public void validate(Cookie cookie, CookieOrigin origin) throws MalformedCookieException {

	}

	@Override
	public boolean match(Cookie cookie, CookieOrigin origin) {
		return true;
	}

	@Override
	public List<Header> formatCookies(List<Cookie> cookies) {
		return super.formatCookies(cookies);
	}

	@Override
	public Header getVersionHeader() {
		return super.getVersionHeader();
	}
}
