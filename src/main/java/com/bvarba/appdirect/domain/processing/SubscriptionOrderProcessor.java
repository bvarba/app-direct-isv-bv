package com.bvarba.appdirect.domain.processing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bvarba.appdirect.domain.entities.Subscription;
import com.bvarba.appdirect.domain.entities.SubscriptionRepository;
import com.bvarba.appdirect.web.dto.NotificationEventResponse;
import com.bvarba.appdirect.web.dto.SuccessNotificationEventResponse;
import com.bvarba.appdirect.web.dtos.Company;
import com.bvarba.appdirect.web.dtos.Event;
import com.bvarba.appdirect.web.dtos.Marketplace;

/**
 * @author Boris Varbanov
 *
 */

@Service("SubscriptionOrderProcessor")
public class SubscriptionOrderProcessor implements EventProcessor{
	@Autowired
	private SubscriptionRepository subscriptionRepo;
	
	@Override
	public NotificationEventResponse processEvent(Event event) {
		Subscription subscription = createSubscription(event);
		subscriptionRepo.save(subscription);
		
		return new SuccessNotificationEventResponse(event.getApplicationUuid());
	}

	public static Subscription createSubscription(Event event) {
		Subscription subscription = new Subscription();
		Company company = event.getPayload().getCompany();
		subscription.setCompanyCountry(company.getCountry());
		subscription.setCompanyName(company.getName());
		subscription.setCompanyWebsite(company.getWebsite());
		subscription.setCompanyUuid(company.getUuid());
		
		Marketplace marketplace = event.getMarketplace();
		subscription.setMarketplaceBaseUrl(marketplace.getBaseUrl());
		subscription.setMarketplaceParner(marketplace.getPartner());
		return subscription;
	}

}
