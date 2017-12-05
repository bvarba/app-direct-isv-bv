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
import com.bvarba.appdirect.domain.rules.handlers.users.UserProfileIsNewRuleHandler;
import com.bvarba.appdirect.services.processing.EventProcessorWithRules;
import com.bvarba.appdirect.web.dtos.Event;
import com.bvarba.appdirect.web.response.NotificationEventResponse;
import com.bvarba.appdirect.web.response.SuccessNotificationEventResponse;

/**
 * @author Boris Varbanov
 *
 */

@Service("UserAssignmentProcessor")
public class UserAssignmentProcessor extends EventProcessorWithRules{

	  private static Logger logger = Logger.getLogger(UserAssignmentProcessor.class);
	@Autowired
	private UserProfileRepository userProfileRepo;//TODO possibly move to dal
	@Autowired
	private SubscriptionAccountRepository subscriptionAccountRepo;//TODO move to dal

	@Override
	protected EventBusinessRuleHandler buildBusinessRulesHandlersChain() {
		EventBusinessRuleHandler businessRule = new SubscriptionAccountExistsRuleHandler(subscriptionAccountRepo).
				setSuccessor(new UserProfileIsNewRuleHandler(userProfileRepo));
		return businessRule;
	}
	
	@Override
	protected NotificationEventResponse processEventLogic(Event event) {
	    String accountidentifier = event.getPayload().getAccount().getAccountIdentifier();
	    SubscriptionAccount subscriptionAccount = subscriptionAccountRepo.findByAccountIdentifier(accountidentifier);

	    UserProfile newUserProfile = UserProfileDAL.createNewUserProfile(event);
	    newUserProfile.setSubscriptionAccount(subscriptionAccount);
	    logger.info("User assignment with UUID " + newUserProfile.getUuid() + " to SubscriptionAccount for account/company with UUID " + accountidentifier);
	    userProfileRepo.save(newUserProfile);
		
		return new SuccessNotificationEventResponse();
	}
}
