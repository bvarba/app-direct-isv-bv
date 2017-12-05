package com.bvarba.appdirect.services.processing.subscriptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bvarba.appdirect.domain.dal.SubscriptionAccountDAL;
import com.bvarba.appdirect.domain.dal.entities.SubscriptionAccount;
import com.bvarba.appdirect.domain.dal.entities.SubscriptionAccountState;
import com.bvarba.appdirect.domain.dal.repository.SubscriptionAccountRepository;
import com.bvarba.appdirect.domain.rules.handlers.EventBusinessRuleHandler;
import com.bvarba.appdirect.domain.rules.handlers.SubscriptionAccountIsNewRuleHandler;
import com.bvarba.appdirect.services.processing.EventProcessorWithRules;
import com.bvarba.appdirect.web.client.BasicOAuthInterceptor;
import com.bvarba.appdirect.web.dtos.Event;
import com.bvarba.appdirect.web.response.NotificationEventResponse;
import com.bvarba.appdirect.web.response.SuccessNotificationEventResponse;

/**
 * @author Boris Varbanov
 *
 */

@Service("SubscriptionOrderProcessor")
public class SubscriptionOrderProcessor extends EventProcessorWithRules{
    private static final Logger logger = LoggerFactory.getLogger( BasicOAuthInterceptor.class );

	@Autowired
	private SubscriptionAccountRepository accountRepo;
	
	@Override
	protected EventBusinessRuleHandler buildBusinessRulesChain() {
		EventBusinessRuleHandler rule = new SubscriptionAccountIsNewRuleHandler(accountRepo);
		return rule;
	}
	
	@Override
	protected NotificationEventResponse processEventLogic(Event event) {	
		SubscriptionAccount subscriptionAccount = SubscriptionAccountDAL.createSubscriptionFromEvent(event);
		subscriptionAccount.setAccountState(SubscriptionAccountState.ACTIVE);
		logger.info("Creating Order subscription for companyUuid: "+subscriptionAccount.getCompanyUuid());
		accountRepo.save(subscriptionAccount);
		
		return new SuccessNotificationEventResponse(subscriptionAccount.getAccountIdentifier());
	}
}
