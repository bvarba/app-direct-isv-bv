package com.bvarba.appdirect.domain.services.processing;

import com.bvarba.appdirect.domain.dal.entities.SubscriptionAccount;
import com.bvarba.appdirect.web.dtos.Company;
import com.bvarba.appdirect.web.dtos.Event;
import com.bvarba.appdirect.web.dtos.Marketplace;
import com.bvarba.appdirect.web.dtos.Order;

public class SubscriptionAccountEntityMapper {
	private  SubscriptionAccountEntityMapper() {
		
	}

	public static SubscriptionAccount mapEventToSubscription(Event event) {
		SubscriptionAccount subscription = new SubscriptionAccount();
		
		Company company = event.getPayload().getCompany();
		subscription.setCompanyCountry(company.getCountry());
		subscription.setCompanyName(company.getName());
		subscription.setCompanyWebsite(company.getWebsite());
		subscription.setCompanyUuid(company.getUuid());
		
		Marketplace marketplace = event.getMarketplace();
		subscription.setMarketplaceBaseUrl(marketplace.getBaseUrl());
		subscription.setMarketplaceParner(marketplace.getPartner());
		
		Order order = event.getPayload().getOrder();
		subscription.setOrderEditionCode(order.getEditionCode());
		subscription.setOrderEditionCode(order.getEditionCode());
		
		//the account is identified by the company uuid
		subscription.setAccountIdentifier(subscription.getCompanyUuid());
		
		return subscription;
	}
	

}
