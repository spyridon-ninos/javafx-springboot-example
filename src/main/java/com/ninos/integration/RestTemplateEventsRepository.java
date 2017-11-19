package com.ninos.integration;

import com.ninos.business.EventsRepository;
import com.ninos.business.model.Event;
import com.ninos.integration.model.EventsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;
import java.util.List;

@Repository
public class RestTemplateEventsRepository implements EventsRepository {

	private static Logger logger = LoggerFactory.getLogger(RestTemplateEventsRepository.class);

	private final RestTemplate restTemplate;
	private final String eventsUrl;

	@Inject
	public RestTemplateEventsRepository(
			RestTemplate restTemplate,
			@Value("${eventsEndpoint.url:SET_ME}") String eventsUrl
	) {
		this.restTemplate = restTemplate;
		this.eventsUrl = eventsUrl;
	}

	@Override
	public List<Event> getAllEvents() {
		EventsResponse response = restTemplate.getForObject(eventsUrl, EventsResponse.class);
		return response.getResponseBody();
	}
}
