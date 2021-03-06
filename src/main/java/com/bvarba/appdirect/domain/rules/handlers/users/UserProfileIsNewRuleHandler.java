package com.bvarba.appdirect.domain.rules.handlers.users;

import com.bvarba.appdirect.domain.dal.entities.UserProfile;
import com.bvarba.appdirect.domain.dal.repository.UserProfileRepository;
import com.bvarba.appdirect.domain.rules.exceptions.BusinessRuleFailedNotificationEventException;
import com.bvarba.appdirect.web.dtos.Event;
import com.bvarba.appdirect.web.response.ErrorCode;
import com.bvarba.appdirect.web.response.ErrorNotificationEventResponse;

public class UserProfileIsNewRuleHandler extends UserProfileRuleHandler {
	public UserProfileIsNewRuleHandler(UserProfileRepository userProfileRepo) {
		super(userProfileRepo);
	}

	@Override
	public void validate(Event incomingBusinessData) {
		String accountIdentifier = incomingBusinessData.getPayload().getAccount().getAccountIdentifier();
		String userUuid = incomingBusinessData.getPayload().getUser().getUuid();
		UserProfile existingUser = getRepository().findByUuidAndSubscriptionAccount_accountIdentifier(userUuid,
				accountIdentifier);
		if (existingUser != null) {
			ErrorNotificationEventResponse errorResponse = new ErrorNotificationEventResponse(
					"User with the provided uuid account with " + userUuid + " already exist...",
					ErrorCode.USER_ALREADY_EXISTS);
			throw new BusinessRuleFailedNotificationEventException(errorResponse);
		}
	}
}
