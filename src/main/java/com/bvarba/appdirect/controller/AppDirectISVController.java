package com.bvarba.appdirect.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.bvarba.appdirect.domain.services.EventHandlerService;
import com.bvarba.appdirect.web.dto.NotificationEventResponse;

@Controller
@RequestMapping(path = "/api/developer/integration/v1")
public class AppDirectISVController {

	  private static Logger LOGGER = Logger.getLogger(AppDirectISVController.class);

	  @Autowired
	  private EventHandlerService eventHandlerService;
	  
	  @RequestMapping(value="createSubscription",method = RequestMethod.GET)
	  public ResponseEntity<NotificationEventResponse> createSubscription(@RequestParam("event") String urlEvent) {
		  try {
			  NotificationEventResponse response = eventHandlerService.handleEventUrl(urlEvent);
			  LOGGER.info("Entered here! createSubscription");
			  System.out.println("HERE yes createSubscription:"+urlEvent);
		
			  return new ResponseEntity<NotificationEventResponse>(response,HttpStatus.OK);
			  }catch(Exception ex) {
				  LOGGER.error("Error happend"+ ex);
				  return new ResponseEntity<NotificationEventResponse>(new NotificationEventResponse(false),HttpStatus.BAD_REQUEST);
			  }
	  }
	  @RequestMapping(value="cancelSubscription",method = RequestMethod.GET)
	  public ResponseEntity<NotificationEventResponse> cancelSubscription(@RequestParam("event") String urlEvent) {
		  
		     LOGGER.info("Entered here! cancelSubscription");
		     System.out.println("cancelSubscription yea:"+urlEvent);
		  return new ResponseEntity<NotificationEventResponse>(new NotificationEventResponse(true),HttpStatus.OK);
	  }
	  
	  
	  @RequestMapping(value="consumeNotification",method = RequestMethod.GET)
	  public ResponseEntity<NotificationEventResponse> consumeNotification(@RequestParam("event") String urlEvent) {
	  
		     LOGGER.info("Entered here!");
		     System.out.println("HERE yea:"+urlEvent);
		
		  return new ResponseEntity<NotificationEventResponse>(new NotificationEventResponse(true),HttpStatus.OK);
	  }
}
