/**
 * 
 */
package com.bvarba.appdirect.web.response;

/**
 * @author Boris Varbanov
 *
 */
public class ErrorNotificationEventResponse extends NotificationEventResponse {

	private String message;
	private ErrorCode errorCode;
	public ErrorNotificationEventResponse() {
		super(false);
	}

	public ErrorNotificationEventResponse(String message, ErrorCode errorCode) {
		super(true);
		this.message = message;
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}
}
