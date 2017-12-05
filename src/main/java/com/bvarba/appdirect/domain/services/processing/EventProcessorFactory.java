package com.bvarba.appdirect.domain.services.processing;

import javax.naming.OperationNotSupportedException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bvarba.appdirect.domain.services.processing.subscriptions.SubscriptionCancelProcessor;
import com.bvarba.appdirect.domain.services.processing.subscriptions.SubscriptionChangeProcessor;
import com.bvarba.appdirect.domain.services.processing.subscriptions.SubscriptionOrderProcessor;
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
	private SubscriptionCancelProcessor subscriptionCancelProcessor;
	
	@Autowired
	@Qualifier("SubscriptionChangeProcessor") 
	private SubscriptionChangeProcessor subscriptionChangeProcessor;
	
	public EventProcessor getEventProcessor(EventType eventType) throws Exception{
		switch(eventType) {
			case SUBSCRIPTION_ORDER:
				return subscriptionOrderProcessor;
			case SUBSCRIPTION_CANCEL:
				return subscriptionCancelProcessor;
			case SUBSCRIPTION_CHANGE:
				return subscriptionChangeProcessor;
			case SUBSCRIPTION_NOTICE:
			case USER_ASSIGNMENT:
			case USER_UNASSIGNMENT:
			case USER_UPDATED:
				throw new UnSupportedEventTypeException(eventType);
			default:
				throw new IllegalArgumentException("Illegal event type: "+eventType);
		}
	}
}
