package com.bvarba.appdirect.web.client;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpRequest;

import com.sun.jersey.oauth.signature.OAuthRequest;

public class HttpOAuthRequestImpl implements OAuthRequest {
	private HttpRequest httpRequest;
	private Map<String, List<String>> paramMap;

	public HttpOAuthRequestImpl(HttpRequest httpRequest) {
		this.httpRequest = httpRequest;
		this.paramMap = new HashMap<String, List<String>>();
		String query = httpRequest.getURI().getQuery();
		if (query != null) {
			String[] params = query.split("&");
			Arrays.stream(params).map(param -> param.split("=")).forEach(keyValuePair -> {
				if (paramMap.get(keyValuePair[0]) == null) {
					paramMap.put(keyValuePair[0], new ArrayList<String>());
				}
				paramMap.get(keyValuePair[0]).add(keyValuePair[1]);
			});
		}
	}

	@Override
	public String getRequestMethod() {
		// TODO Auto-generated method stub
		return httpRequest.getMethod().name();
	}

	@Override
	public URL getRequestURL() {
		// TODO Auto-generated method stub
		try {
			return httpRequest.getURI().toURL();
		} catch (Exception ex) {
			throw new RuntimeException("Error getting URL...");
		}
	}

	@Override
	public Set<String> getParameterNames() {
		// TODO Auto-generated method stub
		return paramMap.keySet();
	}

	@Override
	public List<String> getParameterValues(String name) {
		// TODO Auto-generated method stub
		return paramMap.get(name);
	}

	@Override
	public List<String> getHeaderValues(String name) {
		// TODO Auto-generated method stub
		return httpRequest.getHeaders().get(name);
	}

	@Override
	public void addHeaderValue(String name, String value) throws IllegalStateException {
		httpRequest.getHeaders().add(name, value);
	}
}
