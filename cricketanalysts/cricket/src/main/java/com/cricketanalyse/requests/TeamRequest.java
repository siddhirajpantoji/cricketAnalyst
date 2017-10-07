package com.cricketanalyse.requests;

import javax.validation.constraints.NotNull;

import com.cricketanalyse.util.ValidationMessages;

public class TeamRequest extends BaseRequest {
	
	@NotNull ( message = ValidationMessages.TEAM_NAME_NOT_EMPTY )
	//@NotBlank (message = ValidationMessages.TEAM_NAME_NOT_EMPTY)
	private String name;
	
	private Boolean status;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
}
