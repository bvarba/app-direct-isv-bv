package com.bvarba.appdirect.web.controller;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bvarba.appdirect.domain.rules.exceptions.BusinessRuleFailedNotificationEventException;
import com.bvarba.appdirect.services.EventHandlerService;
import com.bvarba.appdirect.services.processing.UnSupportedEventTypeException;
import com.bvarba.appdirect.web.response.ErrorCode;
import com.bvarba.appdirect.web.response.ErrorNotificationEventResponse;
import com.bvarba.appdirect.web.response.NotificationEventResponse;

@Controller
@RequestMapping(path = "/api/developer/integration/v1")
public class AppDirectISVController {

	  private static Logger logger = Logger.getLogger(AppDirectISVController.class);

	  @Autowired
	  private EventHandlerService eventHandlerService;
	  
	  @RequestMapping(value="consumeEvent",method = RequestMethod.GET)
	  public ResponseEntity<NotificationEventResponse> consumeEvent(@RequestParam("event") String urlEvent	   ) {
		  try {
			  NotificationEventResponse response = eventHandlerService.handleEventUrl(urlEvent);
			  logger.info("Consuming Event: "+urlEvent);
			  return new ResponseEntity<NotificationEventResponse>(response,HttpStatus.OK);
		  }catch(BusinessRuleFailedNotificationEventException ex) {
			  logger.error("Error passing business rules validation", ex);
			  return new ResponseEntity<NotificationEventResponse>(ex.getErrorNotificationResponse(),HttpStatus.OK);
		  }catch(IllegalArgumentException ex) {
			  logger.error("Invalid Argument found: ", ex);
		      return new ResponseEntity<NotificationEventResponse>(
		    		  new ErrorNotificationEventResponse(ex.getMessage(),ErrorCode.FORBIDDEN),HttpStatus.OK);
		  }catch(UnSupportedEventTypeException ex) {
			  logger.error("Requested event is not supported: ", ex);
		      return new ResponseEntity<NotificationEventResponse>(
		    		  new ErrorNotificationEventResponse(ex.getMessage(),ErrorCode.CONFIGURATION_ERROR),HttpStatus.OK);
		  }catch(Exception ex) {
		      return new ResponseEntity<NotificationEventResponse>(
		    		  new ErrorNotificationEventResponse(ex.getMessage(),ErrorCode.UNKNOWN_ERROR),HttpStatus.OK);
		  }
	  }
}
