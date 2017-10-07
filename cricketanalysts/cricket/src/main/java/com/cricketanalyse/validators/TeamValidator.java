package com.cricketanalyse.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cricketanalyse.entities.Team;
import com.cricketanalyse.repositories.TeamRepository;
import com.cricketanalyse.requests.TeamRequest;
import com.cricketanalyse.util.ValidationMessages;
import com.cricketanalyse.validatedObjects.ValidatedTeam;

@Component
public class TeamValidator {

	@Autowired
	TeamRepository teamRepository;
	
	/**
	 * To Parse Request to Object 
	 * @param teamRequest
	 * @param playerId
	 * @return
	 */
	public Team getTeamFromRequest( TeamRequest teamRequest)
	{
			return new Team(teamRequest.getName(), teamRequest.getStatus());
	}
	/**
	 * To Validate the Player Information 
	 * @param teamId
	 * @return
	 */
	public ValidatedTeam getTeamFromId ( Long teamId)
	{
		if( null == teamId )
			return new ValidatedTeam(true, ValidationMessages.TEAM_ID_NOT_EMPTY);
		Team team = teamRepository.findOne(teamId);
		if( null == team )
		{
			return new ValidatedTeam(true, ValidationMessages.TEAM_DOES_NOT_EXIST);
		}
		return new ValidatedTeam(team);
	}
}
