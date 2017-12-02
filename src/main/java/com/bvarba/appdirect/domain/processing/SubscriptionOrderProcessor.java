package com.bvarba.appdirect.domain.processing;

import org.springframework.stereotype.Service;

import com.bvarba.appdirect.web.dto.NotificationEventResponse;
import com.bvarba.appdirect.web.dto.SuccessNotificationEventResponse;
import com.bvarba.appdirect.web.dtos.Event;

/**
 * @author Boris Varbanov
 *
 */

@Service("SubscriptionCreateProcessor")
public class SubscriptionOrderProcessor implements EventProcessor{
	@Override
	public NotificationEventResponse processEvent(Event event) {
		return new SuccessNotificationEventResponse(event.getApplicationUuid());
	}
}
