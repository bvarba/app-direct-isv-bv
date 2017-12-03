/**
 * 
 */
package com.bvarba.appdirect.domain.processing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bvarba.appdirect.web.dtos.EventType;

/**
 * @author Boris Varbanov
 *
 */
@Service
public class EventProcessorFactory {
	
	@Autowired
	@Qualifier("SubscriptionOrderProcessor") 
	private SubscriptionOrderProcessor subscriptionOrderProcessor;

	@Autowired
	@Qualifier("SubscriptionCancelProcessor") 
	private SubscriptionCancelProcessor subscriptionCanceProcessor;
	
	public EventProcessor getEventProcessor(EventType eventType) throws Exception{
		if(eventType==EventType.SUBSCRIPTION_ORDER) {
			return subscriptionOrderProcessor;
		}else if(eventType==EventType.SUBSCRIPTION_CANCEL) {
			return subscriptionCanceProcessor;
		}else {
			throw new Exception("Unhandled event");
		}
	
	}
}
