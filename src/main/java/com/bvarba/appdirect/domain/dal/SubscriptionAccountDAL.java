package com.bvarba.appdirect.domain.dal;

import org.springframework.beans.factory.annotation.Autowired;

import com.bvarba.appdirect.domain.dal.entities.SubscriptionAccount;
import com.bvarba.appdirect.domain.dal.repository.SubscriptionAccountRepository;
import com.bvarba.appdirect.web.dtos.Company;
import com.bvarba.appdirect.web.dtos.Event;
import com.bvarba.appdirect.web.dtos.Marketplace;
import com.bvarba.appdirect.web.dtos.Order;

public class SubscriptionAccountDAL {
	@Autowired
	private SubscriptionAccountRepository subscriptionRepo;
	
	public   SubscriptionAccountDAL() {
		
	}

	public static SubscriptionAccount createSubscriptionFromEvent(Event event) {
		SubscriptionAccount subscriptionAccount = new SubscriptionAccount();
		
		Company company = event.getPayload().getCompany();
		subscriptionAccount.setCompanyCountry(company.getCountry());
		subscriptionAccount.setCompanyName(company.getName());
		subscriptionAccount.setCompanyWebsite(company.getWebsite());
		subscriptionAccount.setCompanyUuid(company.getUuid());
		
		Marketplace marketplace = event.getMarketplace();
		subscriptionAccount.setMarketplaceBaseUrl(marketplace.getBaseUrl());
		subscriptionAccount.setMarketplaceParner(marketplace.getPartner());
		
		Order order = event.getPayload().getOrder();
		subscriptionAccount.setOrderEditionCode(order.getEditionCode());
		subscriptionAccount.setOrderEditionCode(order.getEditionCode());
		
		//the account is identified by the company uuid
		subscriptionAccount.setAccountIdentifier(subscriptionAccount.getCompanyUuid());
		
		return subscriptionAccount;
	}

	public static boolean updateSubscriptionOrder(SubscriptionAccount subscriptionAccount, Event event) {

		Order order = event.getPayload().getOrder();
		subscriptionAccount.setOrderEditionCode(order.getEditionCode());
		subscriptionAccount.setOrderPricingDuration(order.getPricingDuration());
		//subscriptionAccount.setOrderItemsQuantity(order.get());
		return true;
	}
}
