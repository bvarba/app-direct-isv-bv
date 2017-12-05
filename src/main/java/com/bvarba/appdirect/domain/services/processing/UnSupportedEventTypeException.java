package com.bvarba.appdirect.domain.services.processing;

import com.bvarba.appdirect.web.dtos.EventType;

public class UnSupportedEventTypeException extends RuntimeException{

	private static final long serialVersionUID = 795331077113862243L;
	public UnSupportedEventTypeException(EventType eventType) {
		super(eventType +"is not supported");
	}
}
