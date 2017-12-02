package com.bvarba.appdirect.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bvarba.appdirect.domain.processing.EventProcessor;
import com.bvarba.appdirect.domain.processing.EventProcessorFactory;
import com.bvarba.appdirect.web.client.Client;
import com.bvarba.appdirect.web.dto.NotificationEventResponse;
import com.bvarba.appdirect.web.dtos.Event;

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
