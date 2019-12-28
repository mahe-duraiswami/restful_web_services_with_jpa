package com.mahe.rest.webservices.restfulwebservices.exception;

import java.util.Date;

public class ExceptionResponse {
	
	private Date errorTimeStamp;
	private String errorMessage;
	private String errorDetails;

	public ExceptionResponse(Date errorTimeStamp, String errorMessage, String errorDetails) {
		super();
		this.errorTimeStamp = errorTimeStamp;
		this.errorMessage = errorMessage;
		this.errorDetails = errorDetails;
	}
	
	public Date getErrorTimeStamp() {
		return errorTimeStamp;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getErrorDetails() {
		return errorDetails;
	}

}
