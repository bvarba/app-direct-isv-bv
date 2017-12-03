package com.bvarba.appdirect.web.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.bvarba.appdirect.web.dtos.Event;

@Component
public class Client {
	private RestTemplate restTemplate= null;
	
	public Client(){
		
	}
	
	public Event fetchEventFromUrl(String eventUrl) {
		 restTemplate = new RestTemplate();
	        final BasicOAuthInterceptor interceptor =  new BasicOAuthInterceptor(
	                "bvarbanov-185932",
	        	     "jXVMBHJVNt3KRW0M");
	        restTemplate.getInterceptors()
	        .add(interceptor);
		 return restTemplate.getForObject(eventUrl, Event.class);
	}
}
