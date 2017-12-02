/**
 * 
 */
package com.bvarba.appdirect.domain.processing;

import com.bvarba.appdirect.web.dto.NotificationEventResponse;
import com.bvarba.appdirect.web.dtos.Event;

/**
 * @author Boris Varbanov
 *
 */
public interface EventProcessor {
	NotificationEventResponse processEvent(Event event);
}
