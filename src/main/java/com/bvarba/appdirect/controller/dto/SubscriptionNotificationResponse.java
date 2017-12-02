package com.bvarba.appdirect.controller.dto;

public class SubscriptionNotificationResponse {
	  private Boolean success;

	  public SubscriptionNotificationResponse(Boolean success) {
	    this.success = success;
	  }

	  public Boolean getSuccess() {
	    return success;
	  }

	  public void setSuccess(Boolean success) {
	    this.success = success;
	  }
}
