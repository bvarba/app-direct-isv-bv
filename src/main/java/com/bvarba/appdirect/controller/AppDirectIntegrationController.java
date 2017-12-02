package com.bvarba.appdirect.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bvarba.appdirect.controller.dto.SubscriptionNotificationResponse;

@Controller
@RequestMapping(path = "/api/developer/integration/v1")
public class AppDirectIntegrationController {

	  private static Logger LOGGER = Logger.getLogger(AppDirectIntegrationController.class);


	  @RequestMapping(value="createSubscription",method = RequestMethod.GET)
	  public ResponseEntity<SubscriptionNotificationResponse> createSubscription(@RequestParam("event") String urlEvent) {
		  
		     LOGGER.info("Entered here! createSubscription");
		     System.out.println("HERE yes createSubscription:"+urlEvent);
	
		  return new ResponseEntity<SubscriptionNotificationResponse>(new SubscriptionNotificationResponse(true),HttpStatus.OK);
	  }

	  @RequestMapping(value="cancelSubscription",method = RequestMethod.GET)
	  public ResponseEntity<SubscriptionNotificationResponse> cancelSubscription(@RequestParam("event") String urlEvent) {
		  
		     LOGGER.info("Entered here! cancelSubscription");
		     System.out.println("cancelSubscription yea:"+urlEvent);
		  return new ResponseEntity<SubscriptionNotificationResponse>(new SubscriptionNotificationResponse(true),HttpStatus.OK);
	  }
	  
	  
	  @RequestMapping(value="consumeNotification",method = RequestMethod.GET)
	  public ResponseEntity<SubscriptionNotificationResponse> consumeNotification(@RequestParam("event") String urlEvent) {
	  
		     LOGGER.info("Entered here!");
		     System.out.println("HERE yea:"+urlEvent);
		
		  return new ResponseEntity<SubscriptionNotificationResponse>(new SubscriptionNotificationResponse(true),HttpStatus.OK);
	  }
}
