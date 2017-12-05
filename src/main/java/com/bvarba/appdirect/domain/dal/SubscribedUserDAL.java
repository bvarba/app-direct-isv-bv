package com.bvarba.appdirect.domain.dal;

import org.springframework.beans.factory.annotation.Autowired;

import com.bvarba.appdirect.domain.dal.entities.User;
import com.bvarba.appdirect.domain.dal.repository.UserRepository;


public class SubscribedUserDAL {
	@Autowired
	private UserRepository userRepo;
	
	private SubscribedUserDAL() {
		
	}

}
