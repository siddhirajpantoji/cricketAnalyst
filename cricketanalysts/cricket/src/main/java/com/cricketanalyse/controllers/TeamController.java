package com.cricketanalyse.controllers;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cricketanalyse.entities.Team;
import com.cricketanalyse.repositories.TeamRepository;
import com.cricketanalyse.requests.TeamRequest;
import com.cricketanalyse.response.TeamResponse;
import com.cricketanalyse.util.Messages;
import com.cricketanalyse.util.RestEndpointConstants;
import com.cricketanalyse.util.ValidationMessages;
import com.cricketanalyse.validatedObjects.ValidatedTeam;
import com.cricketanalyse.validators.TeamValidator;

@RestController
public class TeamController {

	@Autowired
	private	TeamRepository teamRepository;
	
	@Autowired
	private TeamValidator teamValidator;
	
	@RequestMapping ( method= RequestMethod.GET, value= RestEndpointConstants.TEAMS_END_POINT)
	public @ResponseBody ResponseEntity<TeamResponse> getTeamInfo(@PathVariable @NotBlank(message =ValidationMessages.PLAYER_ID_NOT_EMPTY) Long Id)
	{
		return getValidatedResponse(Id);
	}
	
	@Transactional(  rollbackOn= Exception.class )
	@RequestMapping ( method= RequestMethod.POST, value= RestEndpointConstants.TEAMS_BASE_VAR)
	public @ResponseBody ResponseEntity<TeamResponse> createPlayerInfo(@RequestBody @Valid TeamRequest TeamResponse)
	{
		Team team = teamRepository.save(teamValidator.getTeamFromRequest(TeamResponse));
		return new ResponseEntity<TeamResponse>(new TeamResponse(HttpStatus.OK, Messages.EVERYTHING_OK, team), HttpStatus.OK);
	}
	
	
	@Transactional(  rollbackOn= Exception.class )
	@RequestMapping ( method= {RequestMethod.PUT, RequestMethod.PATCH }, value= RestEndpointConstants.TEAMS_END_POINT)
	public @ResponseBody ResponseEntity<TeamResponse> updatePlayerInfo( @PathVariable @NotBlank(message =ValidationMessages.TEAM_ID_NOT_EMPTY) Long Id,  @Valid @RequestBody TeamRequest teamRequest)
	{
		ResponseEntity<TeamResponse> responseEntity = getValidatedResponse(Id);

		if(! HttpStatus.OK.equals(responseEntity.getStatusCode()))
		{
			return responseEntity;
		}

		Team team = responseEntity.getBody().getTeam();
		BeanUtils.copyProperties(teamRequest, team);
		team = teamRepository.save(team);
		return new ResponseEntity<TeamResponse>(new TeamResponse(HttpStatus.OK, Messages.EVERYTHING_OK, team), HttpStatus.OK);
	}
	
	@Transactional(  rollbackOn= Exception.class )
	@RequestMapping ( method= { RequestMethod.DELETE }, value= RestEndpointConstants.TEAMS_END_POINT )
	public @ResponseBody ResponseEntity<TeamResponse> deleteTeamInfo(@PathVariable @NotBlank(message =ValidationMessages.PLAYER_ID_NOT_EMPTY) Long Id)
	{
		ResponseEntity<TeamResponse> responseEntity = getValidatedResponse(Id);
		if(! HttpStatus.OK.equals(responseEntity.getStatusCode()))
		{
			return responseEntity;
		}
		Team team = responseEntity.getBody().getTeam();
		teamRepository.delete(team);
		return new ResponseEntity<TeamResponse>(new TeamResponse(HttpStatus.OK, Messages.EVERYTHING_OK, team), HttpStatus.OK);
	}

	public ResponseEntity<TeamResponse> getValidatedResponse(Long teamId)
	{
		ValidatedTeam validatedTeam = teamValidator.getTeamFromId(teamId);
		if( validatedTeam.getIsErrorPresent() ){
			return new ResponseEntity<TeamResponse>(new TeamResponse(HttpStatus.BAD_REQUEST, validatedTeam.getMessage()), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<TeamResponse>(new TeamResponse(HttpStatus.OK, Messages.EVERYTHING_OK, validatedTeam.getTeam()), HttpStatus.OK);
	}
	
	@RequestMapping ( method= RequestMethod.GET, value= RestEndpointConstants.TEAMS_BASE_VAR)
	public @ResponseBody Page<Team> getPlayerInfo( Pageable pageable)
	{
		return teamRepository.findAll(pageable); 
	}
	
	@RequestMapping ( method= RequestMethod.GET, value= RestEndpointConstants.TEAMS_GET_ALL)
	public @ResponseBody List<Team> getTeamInfo()
	{
		return teamRepository.findAll();
	}	
}
