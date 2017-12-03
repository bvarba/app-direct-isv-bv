/**
 * 
 */
package com.bvarba.appdirect.domain.services.processing;

import com.bvarba.appdirect.web.dtos.Event;
import com.bvarba.appdirect.web.response.NotificationEventResponse;

/**
 * @author Boris Varbanov
 *
 */
public interface EventProcessor {
	NotificationEventResponse processEvent(Event event);
}
