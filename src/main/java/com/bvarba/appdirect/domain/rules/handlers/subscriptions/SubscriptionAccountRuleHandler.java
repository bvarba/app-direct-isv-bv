package com.bvarba.appdirect.domain.rules.handlers.subscriptions;

import com.bvarba.appdirect.domain.dal.repository.SubscriptionAccountRepository;
import com.bvarba.appdirect.domain.rules.handlers.EventBusinessRuleHandler;

public abstract class SubscriptionAccountRuleHandler extends EventBusinessRuleHandler{
	
	private SubscriptionAccountRepository subscriptionAccountRepository;
	public SubscriptionAccountRuleHandler(SubscriptionAccountRepository accountRepository){
		this.subscriptionAccountRepository = accountRepository;
	}
	public SubscriptionAccountRepository getRepository() {
		return subscriptionAccountRepository;
	}
}
