package com.cricketanalyse.response;

import org.springframework.http.HttpStatus;

import com.cricketanalyse.entities.Team;

public class TeamResponse extends BaseResponse{

	private Team team;
	public TeamResponse(HttpStatus status, String message) {
		super(status, message);
	}
	
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}

	public TeamResponse(HttpStatus status, String message, Team team) {
		super(status, message);
		this.team = team;
	}
}
