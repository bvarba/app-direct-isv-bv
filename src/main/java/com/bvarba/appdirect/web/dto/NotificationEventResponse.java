package com.bvarba.appdirect.web.dto;

public class NotificationEventResponse {
	  private Boolean success;

	  public NotificationEventResponse(Boolean success) {
	    this.success = success;
	  }

	  public Boolean getSuccess() {
	    return success;
	  }

	  public void setSuccess(Boolean success) {
	    this.success = success;
	  }
}
