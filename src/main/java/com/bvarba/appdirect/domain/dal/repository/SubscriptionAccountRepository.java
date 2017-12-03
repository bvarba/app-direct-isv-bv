package com.bvarba.appdirect.domain.dal.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import com.bvarba.appdirect.domain.dal.entities.SubscriptionAccount;

/**
 * @author Boris Varbanov
 *
 */
public interface SubscriptionAccountRepository extends JpaRepository<SubscriptionAccount, Long> {	
	SubscriptionAccount findByAccountIdentifier(String accountIdentifier);
	
	@Modifying
	@Transactional
	void deleteByAccountIdentifier(String accountIdentifier);
}
