package com.bvarba.appdirect.services.processing;

import com.bvarba.appdirect.domain.rules.handlers.EventBusinessRuleHandler;
import com.bvarba.appdirect.web.dtos.Event;
import com.bvarba.appdirect.web.response.NotificationEventResponse;

public abstract class EventProcessorWithRules implements EventProcessor{

	public NotificationEventResponse processEvent(Event event) {
		//buildBusinessRulesHandlersChain().execute(event);
		return processEventLogic(event);
	}
	protected abstract NotificationEventResponse processEventLogic(Event event) ;
	protected abstract EventBusinessRuleHandler buildBusinessRulesHandlersChain();
}
