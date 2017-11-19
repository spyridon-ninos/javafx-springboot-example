package com.ninos.business;

import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class EventsService {

	private final EventsRepository eventsRepository;

	@Inject
	public EventsService(
			EventsRepository eventsRepository
	) {
		this.eventsRepository = eventsRepository;
	}
}
