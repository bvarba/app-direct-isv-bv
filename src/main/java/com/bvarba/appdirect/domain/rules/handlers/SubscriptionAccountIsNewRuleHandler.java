package com.bvarba.appdirect.domain.rules.handlers;

import com.bvarba.appdirect.domain.dal.entities.SubscriptionAccount;
import com.bvarba.appdirect.domain.dal.repository.SubscriptionAccountRepository;
import com.bvarba.appdirect.domain.rules.exceptions.BusinessRuleFailedNotificationEventException;
import com.bvarba.appdirect.web.dtos.Event;
import com.bvarba.appdirect.web.response.ErrorCode;
import com.bvarba.appdirect.web.response.ErrorNotificationEventResponse;

public class SubscriptionAccountIsNewRuleHandler extends SubscriptionAccountRuleHandler {

	public SubscriptionAccountIsNewRuleHandler(SubscriptionAccountRepository accountRepository) {
		super(accountRepository);
	}

	@Override
	public void validate(Event incomingBusinessData) {
		String accountIdentifier = incomingBusinessData.getPayload().getAccount() != null
				? incomingBusinessData.getPayload().getAccount().getAccountIdentifier()
				: incomingBusinessData.getPayload().getCompany().getUuid();
				
		SubscriptionAccount account = getAccountRepository().findByAccountIdentifier(accountIdentifier);

		if (account != null) {
			ErrorNotificationEventResponse errorResponse = new ErrorNotificationEventResponse(accountIdentifier,
					"Subscription account with " + accountIdentifier + " already exists...", ErrorCode.FORBIDDEN);
			throw new BusinessRuleFailedNotificationEventException(errorResponse);
		}
	}
}
