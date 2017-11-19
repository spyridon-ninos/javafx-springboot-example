package com.ninos.business;

import com.ninos.business.model.Event;

import java.util.List;

public interface EventsRepository {
	List<Event> getAllEvents();
}
