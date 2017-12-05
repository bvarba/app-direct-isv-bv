package com.bvarba.appdirect.services.processing.users;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bvarba.appdirect.domain.dal.UserProfileDAL;
import com.bvarba.appdirect.domain.dal.entities.SubscriptionAccount;
import com.bvarba.appdirect.domain.dal.entities.UserProfile;
import com.bvarba.appdirect.domain.dal.repository.SubscriptionAccountRepository;
import com.bvarba.appdirect.domain.dal.repository.UserProfileRepository;
import com.bvarba.appdirect.domain.rules.handlers.EventBusinessRuleHandler;
import com.bvarba.appdirect.domain.rules.handlers.subscriptions.SubscriptionAccountExistsRuleHandler;
import com.bvarba.appdirect.domain.rules.handlers.users.UserProfileExistsRuleHandler;
import com.bvarba.appdirect.domain.rules.handlers.users.UserProfileIsNewRuleHandler;
import com.bvarba.appdirect.domain.rules.handlers.users.UserProfileUnAssignmnetIsNotAdminHandler;
import com.bvarba.appdirect.services.processing.EventProcessorWithRules;
import com.bvarba.appdirect.web.dtos.Event;
import com.bvarba.appdirect.web.response.NotificationEventResponse;
import com.bvarba.appdirect.web.response.SuccessNotificationEventResponse;

/**
 * @author Boris Varbanov
 *
 */

@Service("UserUnAssignmentProcessor")
public class UserUnAssignmentProcessor extends EventProcessorWithRules {

	private static Logger logger = Logger.getLogger(UserUnAssignmentProcessor.class);
	@Autowired
	private UserProfileRepository userProfileRepo;// TODO possibly move to dal
	private SubscriptionAccountRepository subscriptionAccountRepo;// TODO move to dal

	@Override
	protected EventBusinessRuleHandler buildBusinessRulesHandlersChain() {
		EventBusinessRuleHandler businessRule = new SubscriptionAccountExistsRuleHandler(subscriptionAccountRepo)
				.setSuccessor(new UserProfileExistsRuleHandler(userProfileRepo))
				.setSuccessor(new UserProfileUnAssignmnetIsNotAdminHandler(userProfileRepo));
		return businessRule;
	}

	@Override
	protected NotificationEventResponse processEventLogic(Event event) {
		String accountIdentifier = event.getPayload().getAccount().getAccountIdentifier();
		String userUuid = event.getPayload().getUser().getUuid();

		UserProfile userProfile = userProfileRepo.findByUuidAndSubscriptionAccount_accountIdentifier(userUuid,
				accountIdentifier);
		logger.info("User Unassignment: Deleting user with UUID " + userUuid + " from subscription account: "
				+ accountIdentifier);
		userProfileRepo.delete(userProfile);
		return new SuccessNotificationEventResponse();
	}
}
