package dev.mfaydali.data;

import dev.mfaydali.models.Event;

public interface EventDAO extends GenericDAO<Event> {

	public boolean createEvent(Event eventName);

	public boolean updateEvent(Event event);

	public boolean deleteEvent(int eventId);

}
