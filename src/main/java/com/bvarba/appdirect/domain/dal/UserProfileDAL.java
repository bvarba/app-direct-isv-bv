package com.bvarba.appdirect.domain.dal;

import org.springframework.beans.factory.annotation.Autowired;

import com.bvarba.appdirect.domain.dal.entities.UserProfile;
import com.bvarba.appdirect.domain.dal.repository.UserProfileRepository;
import com.bvarba.appdirect.web.dtos.Creator;
import com.bvarba.appdirect.web.dtos.Event;
import com.bvarba.appdirect.web.dtos.User;

public class UserProfileDAL {
	@Autowired
	private UserProfileRepository userRepo;

	private UserProfileDAL() {

	}

	public static UserProfile createNewUserAdministrator(Event event) {
		UserProfile admin = new UserProfile();
		Creator creator = event.getCreator();
		updateUserProfile(admin, creator);
		admin.setIsAdmin(true);
		return admin;
	}
	
	public static UserProfile createNewUserProfile(Event event) {
		UserProfile userProfile = new UserProfile();
		updateUserProfileFromEvent(userProfile, event);
		userProfile.setIsAdmin(false);
		return userProfile;
	}

	private static void updateUserProfileFromEvent(UserProfile userProfile, Event event) {
		User user = event.getPayload().getUser();
		updateUserProfile(userProfile, user);
	}

	private static void updateUserProfile(UserProfile userProfile, User user) {
		userProfile.setFirstName(user.getFirstName());
		userProfile.setLastName(user.getLastName());
		userProfile.setLanguage(user.getLanguage());
		userProfile.setEmail(user.getEmail());
		userProfile.setUuid(user.getUuid());
	}

}
