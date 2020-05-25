package com.practise.microservice.datamodel;

public class ErrorMessage extends Message {

	public ErrorMessage(String errorCode, String title, String detail) {
		this.errorCode = errorCode;
		this.title = title;
		this.detail = detail;
	}

}
