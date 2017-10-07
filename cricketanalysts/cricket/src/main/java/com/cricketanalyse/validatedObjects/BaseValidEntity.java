package com.cricketanalyse.validatedObjects;

public class BaseValidEntity {
	
	protected Boolean isErrorPresent;
	
	protected String message;

	public Boolean getIsErrorPresent() {
		return isErrorPresent;
	}

	public void setIsErrorPresent(Boolean isErrorPresent) {
		this.isErrorPresent = isErrorPresent;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public BaseValidEntity(Boolean isErrorPresent, String message) {
		this.isErrorPresent = isErrorPresent;
		this.message = message;
	}
}
