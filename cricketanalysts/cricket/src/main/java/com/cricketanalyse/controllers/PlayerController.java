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

import com.cricketanalyse.entities.Player;
import com.cricketanalyse.repositories.PlayerRepository;
import com.cricketanalyse.requests.PlayerRequest;
import com.cricketanalyse.response.PlayerResponse;
import com.cricketanalyse.util.Messages;
import com.cricketanalyse.util.RestEndpointConstants;
import com.cricketanalyse.util.ValidationMessages;
import com.cricketanalyse.validatedObjects.ValidatedPlayer;
import com.cricketanalyse.validators.PlayerValidator;

@RestController
//@CrossOrigin
public class PlayerController {

	@Autowired
	private	PlayerRepository playerRepository;

	@Autowired
	private 	PlayerValidator playerValidator;

	@RequestMapping ( method= RequestMethod.GET, value= RestEndpointConstants.PLAYERS_END_POINT)
	public @ResponseBody ResponseEntity<PlayerResponse> getPlayerInfo(@PathVariable @NotBlank(message =ValidationMessages.PLAYER_ID_NOT_EMPTY) Long Id)
	{
		return getValidatedResponse(Id);
	}

	@Transactional(  rollbackOn= Exception.class )
	@RequestMapping ( method= RequestMethod.POST, value= RestEndpointConstants.PLAYERS_BASE_VAR)
	public @ResponseBody ResponseEntity<PlayerResponse> createPlayerInfo(@RequestBody @Valid PlayerRequest playerRequest)
	{
		Player player = playerRepository.save(playerValidator.getPlayerFromRequest(playerRequest));
		return new ResponseEntity<PlayerResponse>(new PlayerResponse(HttpStatus.OK, Messages.EVERYTHING_OK, player), HttpStatus.OK);
	}


	@Transactional(  rollbackOn= Exception.class )
	@RequestMapping ( method= {RequestMethod.PUT, RequestMethod.PATCH }, value= RestEndpointConstants.PLAYERS_END_POINT)
	public @ResponseBody ResponseEntity<PlayerResponse> updatePlayerInfo(@PathVariable @NotBlank(message =ValidationMessages.PLAYER_ID_NOT_EMPTY) Long Id,@RequestBody @Valid PlayerRequest playerRequest)
	{
		ResponseEntity<PlayerResponse> responseEntity = getValidatedResponse(Id);

		if(! HttpStatus.OK.equals(responseEntity.getStatusCode()))
		{
			return responseEntity;
		}

		Player player = responseEntity.getBody().getPlayer();
		BeanUtils.copyProperties(playerRequest, player);
		player = playerRepository.save(player);
		return new ResponseEntity<PlayerResponse>(new PlayerResponse(HttpStatus.OK, Messages.EVERYTHING_OK, player), HttpStatus.OK);
	}

	@Transactional(  rollbackOn= Exception.class )
	@RequestMapping ( method= { RequestMethod.DELETE }, value= RestEndpointConstants.PLAYERS_END_POINT)
	public @ResponseBody ResponseEntity<PlayerResponse> deletePlayerInfo(@PathVariable @NotBlank(message =ValidationMessages.PLAYER_ID_NOT_EMPTY) Long Id)
	{
		ResponseEntity<PlayerResponse> responseEntity = getValidatedResponse(Id);
		if(! HttpStatus.OK.equals(responseEntity.getStatusCode()))
		{
			return responseEntity;
		}
		Player player = responseEntity.getBody().getPlayer();
		playerRepository.delete(player);
		return new ResponseEntity<PlayerResponse>(new PlayerResponse(HttpStatus.OK, Messages.EVERYTHING_OK, player), HttpStatus.OK);
	}

	public ResponseEntity<PlayerResponse> getValidatedResponse(Long playerID)
	{
		ValidatedPlayer validatedPlayer = playerValidator.getPlayerFromId(playerID);
		if( validatedPlayer.getIsErrorPresent() ){
			return new ResponseEntity<PlayerResponse>(new PlayerResponse(HttpStatus.BAD_REQUEST, validatedPlayer.getMessage()), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<PlayerResponse>(new PlayerResponse(HttpStatus.OK, Messages.EVERYTHING_OK, validatedPlayer.getPlayer()), HttpStatus.OK);
	}


	@RequestMapping ( method= RequestMethod.GET, value= RestEndpointConstants.PLAYERS_BASE_VAR)
	public @ResponseBody Page<Player> getPlayerInfo( Pageable pageable)
	{
		return playerRepository.findAll(pageable); 
	}
	
	@RequestMapping ( method= RequestMethod.GET, value= RestEndpointConstants.PLAYER_GET_ALL)
	public @ResponseBody List<Player> getPlayerInfo()
	{
		return playerRepository.findAll();
	}	
}