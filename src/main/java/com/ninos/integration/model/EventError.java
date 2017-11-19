package com.ninos.integration.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class EventError {
	private EventErrorType errorType;
	private String message;

	public EventErrorType getErrorType() {
		return errorType;
	}

	public void setErrorType(EventErrorType errorType) {
		this.errorType = errorType;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
