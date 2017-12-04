package com.bvarba.appdirect.domain.rules.exceptions;

import com.bvarba.appdirect.web.response.ErrorNotificationEventResponse;

public class BusinessRuleFailedNotificationEventException extends BusinessRuleFailedException {

	private static final long serialVersionUID = -4368669692566003268L;
	private ErrorNotificationEventResponse errortResponse;

	public BusinessRuleFailedNotificationEventException(String message) {
		super(message);
	}

	public BusinessRuleFailedNotificationEventException(ErrorNotificationEventResponse errortResponse) {
	    super(errortResponse.getMessage());
	    this.errortResponse = errortResponse;
	}
	
	public ErrorNotificationEventResponse getErrorNotificationResponse() {
	    return this.errortResponse;
	}
	
}
