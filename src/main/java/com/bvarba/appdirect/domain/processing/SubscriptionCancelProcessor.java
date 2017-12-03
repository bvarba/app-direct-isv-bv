package com.bvarba.appdirect.domain.processing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bvarba.appdirect.domain.entities.Subscription;
import com.bvarba.appdirect.domain.entities.SubscriptionRepository;
import com.bvarba.appdirect.web.dto.NotificationEventResponse;
import com.bvarba.appdirect.web.dto.SuccessNotificationEventResponse;
import com.bvarba.appdirect.web.dtos.Company;
import com.bvarba.appdirect.web.dtos.Event;
import com.bvarba.appdirect.web.dtos.Marketplace;

/**
 * @author Boris Varbanov
 *
 */

@Service("SubscriptionCancelProcessor")
public class SubscriptionCancelProcessor implements EventProcessor{
	@Autowired
	private SubscriptionRepository subscriptionRepo;
	
	@Override
	public NotificationEventResponse processEvent(Event event) {
		
		return new SuccessNotificationEventResponse(event.getApplicationUuid());
	}

}
