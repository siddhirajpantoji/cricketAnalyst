package com.cricketanalyse.response;

import org.springframework.http.HttpStatus;

public class BaseResponse {

	protected HttpStatus status;
	protected String message;

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public BaseResponse(HttpStatus status, String message) {
		this.status = status;
		this.message = message;
	}

}
