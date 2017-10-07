package com.cricketanalyse.response;

import java.util.Map;

import org.springframework.http.HttpStatus;

public class ValidationResponse extends BaseResponse {

	private Map<String,String> messageMap;
	public ValidationResponse(HttpStatus status, String message) {
		super(status, message);
	}
	public Map<String, String> getMessageMap() {
		return messageMap;
	}
	public void setMessageMap(Map<String, String> messageMap) {
		this.messageMap = messageMap;
	}
	public ValidationResponse(HttpStatus status, String message, Map<String, String> messageMap) {
		super(status, message);
		this.messageMap = messageMap;
	}
}
