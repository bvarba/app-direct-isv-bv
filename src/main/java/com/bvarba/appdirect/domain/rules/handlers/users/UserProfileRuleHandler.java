package com.bvarba.appdirect.domain.rules.handlers.users;

import com.bvarba.appdirect.domain.dal.repository.UserProfileRepository;
import com.bvarba.appdirect.domain.rules.handlers.EventBusinessRuleHandler;

public abstract class UserProfileRuleHandler extends EventBusinessRuleHandler{
	
	private UserProfileRepository userProfileRepo;
	
	public UserProfileRuleHandler(UserProfileRepository userProfileRepo){
		this.userProfileRepo = userProfileRepo;
	}

	public UserProfileRepository getRepository() {
		return userProfileRepo;
	}
}
