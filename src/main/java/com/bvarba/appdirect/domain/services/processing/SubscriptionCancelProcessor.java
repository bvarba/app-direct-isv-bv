package com.bvarba.appdirect.domain.services.processing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bvarba.appdirect.domain.dal.repository.SubscriptionAccountRepository;
import com.bvarba.appdirect.web.dtos.Event;
import com.bvarba.appdirect.web.response.NotificationEventResponse;
import com.bvarba.appdirect.web.response.SuccessNotificationEventResponse;

/**
 * @author Boris Varbanov
 *
 */

@Service("SubscriptionCancelProcessor")
public class SubscriptionCancelProcessor implements EventProcessor{
	@Autowired
	private SubscriptionAccountRepository subscriptionRepo;
	
	@Override
	public NotificationEventResponse processEvent(Event event) {
		try {
			String accountIdentifier = event.getPayload().getAccount().getAccountIdentifier();
			
			subscriptionRepo.deleteByAccountIdentifier(accountIdentifier);
		//TODO: validation account does not exist
		}catch(Exception ex) {
			//return error 
		}
		return new SuccessNotificationEventResponse();
	}

}
