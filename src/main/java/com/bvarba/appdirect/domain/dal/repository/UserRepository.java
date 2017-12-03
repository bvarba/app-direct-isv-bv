package com.bvarba.appdirect.domain.dal.repository;

import org.springframework.data.repository.CrudRepository;

import com.bvarba.appdirect.domain.dal.entities.SubscriptionAccount;

/**
 * @author Boris Varbanov
 *
 */
public interface UserRepository extends CrudRepository<SubscriptionAccount, Long> {

}
