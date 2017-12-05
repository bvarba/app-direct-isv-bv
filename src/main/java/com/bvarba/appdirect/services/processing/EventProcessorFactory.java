package com.bvarba.appdirect.services.processing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bvarba.appdirect.services.processing.subscriptions.SubscriptionCancelProcessor;
import com.bvarba.appdirect.services.processing.subscriptions.SubscriptionChangeProcessor;
import com.bvarba.appdirect.services.processing.subscriptions.SubscriptionOrderProcessor;
import com.bvarba.appdirect.services.processing.users.UserAssignmentProcessor;
import com.bvarba.appdirect.services.processing.users.UserUnAssignmentProcessor;
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

	@Autowired
	@Qualifier("UserAssignmentProcessor") 
	private UserAssignmentProcessor userAssignmentProcessor;

	@Autowired
	@Qualifier("UserUnAssignmentProcessor") 
	private UserUnAssignmentProcessor userUnassignmentProcessor;
	
	public EventProcessor getEventProcessor(EventType eventType){
		switch(eventType) {
			case SUBSCRIPTION_ORDER:
				return subscriptionOrderProcessor;
			case SUBSCRIPTION_CANCEL:
				return subscriptionCancelProcessor;
			case SUBSCRIPTION_CHANGE:
				return subscriptionChangeProcessor;
			case USER_ASSIGNMENT:
				return userAssignmentProcessor;
			case USER_UNASSIGNMENT:
				return userUnassignmentProcessor;
			case SUBSCRIPTION_NOTICE:
			case USER_UPDATED:
				throw new UnSupportedEventTypeException(eventType);
			default:
				throw new IllegalArgumentException("Illegal event type: "+eventType);
		}
	}
}
