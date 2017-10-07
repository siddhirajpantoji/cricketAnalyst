package com.cricketanalyse.validators;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cricketanalyse.entities.BattingNoOfRunsScored;
import com.cricketanalyse.entities.Player;
import com.cricketanalyse.entities.Team;
import com.cricketanalyse.repositories.BattingNoOfRunsScoredRepository;
import com.cricketanalyse.repositories.PlayerRepository;
import com.cricketanalyse.repositories.TeamRepository;
import com.cricketanalyse.requests.BattingNoOfRunsScoredRequest;
import com.cricketanalyse.util.ValidationMessages;
import com.cricketanalyse.validatedObjects.ValidatedBattingNoOfRunsScored;

@Component
public class BattingNoOfRunsScoredValidator {

	@Autowired
	BattingNoOfRunsScoredRepository battingNoOfRunsScoredRepository;

	@Autowired
	PlayerRepository playerRepository;

	@Autowired
	TeamRepository teamRepository;
	/**
	 * To Parse Request to Object 
	 * @param teamRequest
	 * @param playerId
	 * @return
	 */
	public ValidatedBattingNoOfRunsScored getObjectFromRequest( BattingNoOfRunsScoredRequest battingNoOfRunsScoredRequest)
	{
		Player player = playerRepository.findOne(battingNoOfRunsScoredRequest.getPlayerId());
		if( null == player )
		{
			return new ValidatedBattingNoOfRunsScored(true, ValidationMessages.PLAYER_DOES_NOT_EXIST);
		}
		Team team = teamRepository.findOne(battingNoOfRunsScoredRequest.getTeamId());
		if( null == team )
		{
			return new ValidatedBattingNoOfRunsScored(true, ValidationMessages.TEAM_DOES_NOT_EXIST);
		}
		BattingNoOfRunsScored  battingNoOfRunsScored = new BattingNoOfRunsScored(player, team);
		BeanUtils.copyProperties(battingNoOfRunsScoredRequest, battingNoOfRunsScored);
		return new ValidatedBattingNoOfRunsScored(battingNoOfRunsScored);
	}
	
	public ValidatedBattingNoOfRunsScored getPlayerBattingRecordFromId ( Long recordId)
	{
		if( null == recordId )
			return new ValidatedBattingNoOfRunsScored(true, ValidationMessages.BATTING_NO_OF_RUNS_ID_NOT_EMPTY);
		
		BattingNoOfRunsScored battingRecord = battingNoOfRunsScoredRepository.findOne(recordId);
		if( null == battingRecord )
		{
			return new ValidatedBattingNoOfRunsScored( true, ValidationMessages.BATTING_NO_OF_RUNS_DOES_NOT_EXIST );
		}
		
		return new ValidatedBattingNoOfRunsScored(battingRecord);
	}
}
