package com.practise.microservice.datamodel;

import javax.ws.rs.core.Response;

public class Message {

	private Response response;

	protected String errorCode;

	protected String title;

	protected String detail;

	public Message(Response response) {
		super();
		this.response = response;
	}

	public Message() {
	}

	public Response getResponse() {
		return response;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getTitle() {
		return title;
	}

	public String getDetail() {
		return detail;
	}
	
	

}
