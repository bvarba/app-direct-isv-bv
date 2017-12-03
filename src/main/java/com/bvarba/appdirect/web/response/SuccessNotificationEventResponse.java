/**
 * 
 */
package com.bvarba.appdirect.web.response;

/**
 * @author Boris Varbanov
 *
 */
public class SuccessNotificationEventResponse extends NotificationEventResponse {

	private String accountIdentifier;

	public SuccessNotificationEventResponse() {
		super(true);
	}

	public SuccessNotificationEventResponse(String accountIdentifier) {
		super(true);
		this.accountIdentifier = accountIdentifier;
	}

	public String getAccountIdentifier() {
		return accountIdentifier;
	}

	public void setAccountIdentifier(String accountIdentifier) {
		this.accountIdentifier = accountIdentifier;
	}

}
