package com.cricketanalyse.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cricketanalyse.entities.Player;
import com.cricketanalyse.repositories.PlayerRepository;
import com.cricketanalyse.requests.PlayerRequest;
import com.cricketanalyse.util.ValidationMessages;
import com.cricketanalyse.validatedObjects.ValidatedPlayer;

@Component
public class PlayerValidator {
	
	@Autowired
	PlayerRepository playerRepository;
	
	/**
	 * To Parse Request to Object 
	 * @param playerRequest
	 * @param playerId
	 * @return
	 */
	public Player getPlayerFromRequest( PlayerRequest playerRequest)
	{
			return new Player(playerRequest.getName(), playerRequest.getStatus());
	}
	/**
	 * To Validate the Player Information 
	 * @param playerId
	 * @return
	 */
	public ValidatedPlayer getPlayerFromId ( Long playerId)
	{
		if( null == playerId )
			return new ValidatedPlayer(true, ValidationMessages.PLAYER_ID_NOT_EMPTY);
		
		Player player = playerRepository.findOne(playerId);
		if( null == player )
		{
			return new ValidatedPlayer(true, ValidationMessages.PLAYER_DOES_NOT_EXIST);
		}
		
		return new ValidatedPlayer(player);
	}

}
