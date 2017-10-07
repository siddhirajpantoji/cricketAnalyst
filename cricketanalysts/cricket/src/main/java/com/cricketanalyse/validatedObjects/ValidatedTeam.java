package com.cricketanalyse.validatedObjects;

import com.cricketanalyse.entities.Team;

public class ValidatedTeam   extends BaseValidEntity {

	private Team team;
	
	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public ValidatedTeam(Boolean isErrorPresent, String message) {
		super(isErrorPresent, message);
	}

	public ValidatedTeam(Team team) {
		super(false, "");
		this.team = team;
	}

}
