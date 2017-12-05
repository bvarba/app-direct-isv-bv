package com.bvarba.appdirect.web.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.bvarba.appdirect.AppDirectConfig;
import com.bvarba.appdirect.web.dtos.Event;

@Component
public class Client {
	@Autowired
	private AppDirectConfig config;
	
	private RestTemplate restTemplate= null;

	  
	public Event fetchEventFromUrl(String eventUrl) {
		if(restTemplate==null) {
			restTemplate = new RestTemplate();
	        final BasicOAuthInterceptor interceptor =  new BasicOAuthInterceptor(
	        		config.getAppKey(),
	        	     config.getAppSecret());
	        restTemplate.getInterceptors().add(interceptor);
		}
	    return restTemplate.getForObject(eventUrl, Event.class);
	}
}
