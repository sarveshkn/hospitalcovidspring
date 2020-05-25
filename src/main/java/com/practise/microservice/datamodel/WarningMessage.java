package com.practise.microservice.datamodel;

public class WarningMessage extends Message {

	public WarningMessage(String errorCode, String title, String detail) {
		this.errorCode = errorCode;
		this.title = title;
		this.detail = detail;
	}

}
