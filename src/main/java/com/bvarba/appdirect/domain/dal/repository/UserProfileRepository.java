package com.bvarba.appdirect.domain.dal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bvarba.appdirect.domain.dal.entities.UserProfile;

/**
 * @author Boris Varbanov
 *
 */
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
	UserProfile findByUuid(String uuid);
	UserProfile findByUuidAndSubscriptionAccount_accountIdentifier(String uuid, String accountIdentifier);
}
