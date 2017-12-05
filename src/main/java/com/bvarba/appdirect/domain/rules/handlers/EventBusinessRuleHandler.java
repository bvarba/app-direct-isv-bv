package com.bvarba.appdirect.domain.rules.handlers;

import com.bvarba.appdirect.web.dtos.Event;

public abstract class EventBusinessRuleHandler extends BusinessRuleHandler<Event>{
	public EventBusinessRuleHandler setSuccessor(EventBusinessRuleHandler successor) {
		super.setSuccessor(successor);
		return successor;
	}

}
