package com.bvarba.appdirect.domain.rules.handlers;

import com.bvarba.appdirect.domain.dal.repository.SubscriptionAccountRepository;
import com.bvarba.appdirect.web.dtos.Event;

public abstract class SubscriptionAccountRuleHandler extends EventBusinessRuleHandler{
	
	private SubscriptionAccountRepository accountRepository;
	public SubscriptionAccountRuleHandler(SubscriptionAccountRepository accountRepository){
		this.accountRepository = accountRepository;
	}
	public SubscriptionAccountRepository getAccountRepository() {
		return accountRepository;
	}
}
