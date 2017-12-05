package com.bvarba.appdirect.domain.services.processing.subscriptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bvarba.appdirect.domain.dal.repository.SubscriptionAccountRepository;
import com.bvarba.appdirect.domain.rules.handlers.EventBusinessRuleHandler;
import com.bvarba.appdirect.domain.rules.handlers.SubscriptionAccountExistsRuleHandler;
import com.bvarba.appdirect.domain.services.processing.EventProcessorWithRules;
import com.bvarba.appdirect.web.dtos.Event;
import com.bvarba.appdirect.web.response.NotificationEventResponse;
import com.bvarba.appdirect.web.response.SuccessNotificationEventResponse;

/**
 * @author Boris Varbanov
 *
 */

@Service("SubscriptionCancelProcessor")
public class SubscriptionCancelProcessor extends EventProcessorWithRules{
	@Autowired
	private SubscriptionAccountRepository subscriptionRepo;//TODO move do dal

	@Override
	protected EventBusinessRuleHandler buildBusinessRulesChain() {
		EventBusinessRuleHandler businessRule = new SubscriptionAccountExistsRuleHandler(subscriptionRepo);
		return businessRule;
	}
	
	@Override
	protected NotificationEventResponse processEventLogic(Event event) {
		String accountIdentifier = event.getPayload().getAccount().getAccountIdentifier();
		subscriptionRepo.deleteByAccountIdentifier(accountIdentifier);
		return new SuccessNotificationEventResponse();
	}
}
