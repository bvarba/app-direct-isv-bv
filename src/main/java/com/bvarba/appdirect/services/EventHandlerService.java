package com.bvarba.appdirect.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bvarba.appdirect.services.processing.EventProcessor;
import com.bvarba.appdirect.services.processing.EventProcessorFactory;
import com.bvarba.appdirect.web.client.Client;
import com.bvarba.appdirect.web.dtos.Event;
import com.bvarba.appdirect.web.response.NotificationEventResponse;

@Service
public class EventHandlerService {

	@Autowired
	private Client client;
	
	@Autowired
	private EventProcessorFactory eventProcessorFactory;
	
	public NotificationEventResponse handleEventUrl(String eventUrl) {
		    Event event = client.fetchEventFromUrl(eventUrl);
			EventProcessor eventProcessor = eventProcessorFactory.getEventProcessor(event.getType());
			NotificationEventResponse response =  eventProcessor.processEvent(event);
			return response;
	}	
}
