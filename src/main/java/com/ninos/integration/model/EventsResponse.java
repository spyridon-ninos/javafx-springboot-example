package com.ninos.integration.model;

import com.ninos.business.model.Event;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

public class EventsResponse {
	private List<EventError> errors;
	private List<Event> responseBody;

	public List<EventError> getErrors() {
		return errors;
	}

	public void setErrors(List<EventError> errors) {
		this.errors = errors;
	}

	public List<Event> getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(List<Event> responseBody) {
		this.responseBody = responseBody;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
