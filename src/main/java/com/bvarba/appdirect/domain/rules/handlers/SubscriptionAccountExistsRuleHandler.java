package com.bvarba.appdirect.domain.rules.handlers;

import com.bvarba.appdirect.domain.dal.entities.SubscriptionAccount;
import com.bvarba.appdirect.domain.dal.repository.SubscriptionAccountRepository;
import com.bvarba.appdirect.domain.rules.exceptions.BusinessRuleFailedNotificationEventException;
import com.bvarba.appdirect.web.dtos.Event;
import com.bvarba.appdirect.web.response.ErrorCode;
import com.bvarba.appdirect.web.response.ErrorNotificationEventResponse;

public class SubscriptionAccountExistsRuleHandler extends SubscriptionAccountRuleHandler{
	public SubscriptionAccountExistsRuleHandler(SubscriptionAccountRepository accountRepository) {
		super(accountRepository);
	}

	@Override
	public void validate(Event incomingBusinessData) {
		String accountIdentifier = incomingBusinessData.getPayload().getAccount().getAccountIdentifier();
		SubscriptionAccount account = getAccountRepository().findByAccountIdentifier(accountIdentifier);	
		if(account==null) {
			ErrorNotificationEventResponse errorResponse = 
					new ErrorNotificationEventResponse("Subscription account with "+accountIdentifier+ " does not exist...", 
							ErrorCode.FORBIDDEN);		
			throw new BusinessRuleFailedNotificationEventException(errorResponse);
		}
	}
}
