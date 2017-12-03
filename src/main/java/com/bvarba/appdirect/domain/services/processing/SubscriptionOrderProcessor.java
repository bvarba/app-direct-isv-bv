package com.bvarba.appdirect.domain.services.processing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bvarba.appdirect.domain.dal.entities.SubscriptionAccount;
import com.bvarba.appdirect.domain.dal.entities.SubscriptionAccountState;
import com.bvarba.appdirect.domain.dal.repository.SubscriptionAccountRepository;
import com.bvarba.appdirect.web.client.BasicOAuthInterceptor;
import com.bvarba.appdirect.web.dtos.Event;
import com.bvarba.appdirect.web.response.NotificationEventResponse;
import com.bvarba.appdirect.web.response.SuccessNotificationEventResponse;

/**
 * @author Boris Varbanov
 *
 */

@Service("SubscriptionOrderProcessor")
public class SubscriptionOrderProcessor implements EventProcessor{
    private static final Logger logger = LoggerFactory.getLogger( BasicOAuthInterceptor.class );

	@Autowired
	private SubscriptionAccountRepository subscriptionRepo;
	
	@Override
	public NotificationEventResponse processEvent(Event event) {
		//do validation of event, uuid exists?
	
		SubscriptionAccount subscriptionAccount = SubscriptionAccountEntityMapper.mapEventToSubscription(event);
		subscriptionAccount.setAccountState(SubscriptionAccountState.ACTIVE);
		logger.info("Creating Order subscription for companyUuid: "+subscriptionAccount.getCompanyUuid());
		subscriptionRepo.save(subscriptionAccount);
		
		return new SuccessNotificationEventResponse(subscriptionAccount.getAccountIdentifier());
	}
}
