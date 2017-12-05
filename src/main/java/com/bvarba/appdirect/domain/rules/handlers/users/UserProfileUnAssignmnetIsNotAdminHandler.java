package com.bvarba.appdirect.domain.rules.handlers.users;

import com.bvarba.appdirect.domain.dal.entities.UserProfile;
import com.bvarba.appdirect.domain.dal.repository.UserProfileRepository;
import com.bvarba.appdirect.domain.rules.exceptions.BusinessRuleFailedNotificationEventException;
import com.bvarba.appdirect.web.dtos.Event;
import com.bvarba.appdirect.web.response.ErrorCode;
import com.bvarba.appdirect.web.response.ErrorNotificationEventResponse;

public class UserProfileUnAssignmnetIsNotAdminHandler extends UserProfileRuleHandler {
	public UserProfileUnAssignmnetIsNotAdminHandler(UserProfileRepository userProfileRepo) {
		super(userProfileRepo);
	}

	@Override
	public void validate(Event incomingBusinessData) {
		String accountIdentifier = incomingBusinessData.getPayload().getAccount().getAccountIdentifier();
		String userUuid = incomingBusinessData.getPayload().getUser().getUuid();
		UserProfile existingUser = getRepository().findByUuidAndSubscriptionAccount_accountIdentifier(userUuid,
				accountIdentifier);
		if (existingUser != null) {
			boolean isAdmin = existingUser.getIsAdmin();
			if(isAdmin) {
				ErrorNotificationEventResponse errorResponse = new ErrorNotificationEventResponse(
						"User Profile cannot be admin " + accountIdentifier + " already exist...",
						ErrorCode.UNAUTHORIZED);
				throw new BusinessRuleFailedNotificationEventException(errorResponse);			
			}
		}
	}
}
