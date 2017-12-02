/**
 * 
 */
package com.bvarba.appdirect.domain.processing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.bvarba.appdirect.web.dtos.EventType;

/**
 * @author Boris Varbanov
 *
 */
@Service
public class EventProcessorFactory {
	
	@Autowired
	@Qualifier("SubscriptionCreateProcessor") 
	private SubscriptionOrderProcessor subscriptionOrderProcessor;
	
	public EventProcessor getEventProcessor(EventType eventType){
		return subscriptionOrderProcessor;
	
	}
}
