package com.bvarba.appdirect.domain.dal;

import org.springframework.beans.factory.annotation.Autowired;

import com.bvarba.appdirect.domain.dal.entities.OrderLineItemUnitType;
import com.bvarba.appdirect.domain.dal.entities.SubscriptionAccount;
import com.bvarba.appdirect.domain.dal.repository.SubscriptionAccountRepository;
import com.bvarba.appdirect.web.dtos.Company;
import com.bvarba.appdirect.web.dtos.Event;
import com.bvarba.appdirect.web.dtos.Marketplace;
import com.bvarba.appdirect.web.dtos.Order;
import com.bvarba.appdirect.web.dtos.OrderItem;

public class SubscriptionAccountDAL {
	@Autowired
	private SubscriptionAccountRepository subscriptionRepo;
	
	public SubscriptionAccountDAL() {
		
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
		
		updateSubscriptionOrderFromEvent(subscriptionAccount,event);
		
		//the account is identified by the company uuid
		subscriptionAccount.setAccountIdentifier(subscriptionAccount.getCompanyUuid());
		return subscriptionAccount;
	}

	public static void updateSubscriptionOrderFromEvent(SubscriptionAccount subscriptionAccount, Event event) {
		Order order = event.getPayload().getOrder();
		subscriptionAccount.setOrderEditionCode(order.getEditionCode());
		subscriptionAccount.setOrderPricingDuration(order.getPricingDuration());

		OrderItem orderItem = order.getOrderItem();
	    if (orderItem != null) {
	    	subscriptionAccount.setOrderItemQuantity(orderItem.getQuantity());
	    	subscriptionAccount.setOrderItemUnit(OrderLineItemUnitType.valueOf(orderItem.getOrderItemUnit()));
	    }
	}
	
}
