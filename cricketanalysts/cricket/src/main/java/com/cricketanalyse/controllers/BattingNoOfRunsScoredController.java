package com.cricketanalyse.controllers;

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

import com.cricketanalyse.entities.BattingNoOfRunsScored;
import com.cricketanalyse.entities.BattingRunRatePerOver;
import com.cricketanalyse.entities.BattingRunsAtEndOfScored;
import com.cricketanalyse.repositories.BattingNoOfRunsScoredRepository;
import com.cricketanalyse.repositories.BattingRunRatePerOverRepository;
import com.cricketanalyse.repositories.BattingRunsAtEndOfScoredRepo;
import com.cricketanalyse.requests.BattingNoOfRunsScoredRequest;
import com.cricketanalyse.response.BattingNoOfRunsScoredResponse;
import com.cricketanalyse.util.CricketProcessingUtils;
import com.cricketanalyse.util.Messages;
import com.cricketanalyse.util.RestEndpointConstants;
import com.cricketanalyse.util.ValidationMessages;
import com.cricketanalyse.validatedObjects.ValidatedBattingNoOfRunsScored;
import com.cricketanalyse.validators.BattingNoOfRunsScoredValidator;

@RestController
public class BattingNoOfRunsScoredController {

	@Autowired
	BattingNoOfRunsScoredValidator battingNoOfRunsScoredValidator;
	
	@Autowired
	BattingRunsAtEndOfScoredRepo battingScoreRepo;
	
	@Autowired
	CricketProcessingUtils cricketProcessingUtils;

	@Autowired
	BattingNoOfRunsScoredRepository noOfRunsScoredRepo;
	
	@Autowired
	BattingRunRatePerOverRepository runRateRepo;
	
	@RequestMapping ( method= RequestMethod.GET, value= RestEndpointConstants.BATTING_NO_OF_RUNS_SCORED_END_POINT)
	public @ResponseBody ResponseEntity<BattingNoOfRunsScoredResponse> getPlayerInfo(@PathVariable @NotBlank(message =ValidationMessages.PLAYER_ID_NOT_EMPTY) Long Id)
	{
		return getValidatedForID(Id);
	}
	
	@Transactional(  rollbackOn= Exception.class )
	@RequestMapping ( method= RequestMethod.POST, value= RestEndpointConstants.BATTING_NO_OF_RUNS_SCORED_BASE_VAR)
	public @ResponseBody ResponseEntity<BattingNoOfRunsScoredResponse> createBattingRecordInfo(@RequestBody  @Valid BattingNoOfRunsScoredRequest battingNoOfRunsScoredRequest)
	{
		ValidatedBattingNoOfRunsScored battingNoOfRunsScored = battingNoOfRunsScoredValidator.getObjectFromRequest(battingNoOfRunsScoredRequest);
		if( battingNoOfRunsScored.getIsErrorPresent() ){
			return new ResponseEntity<BattingNoOfRunsScoredResponse>(new BattingNoOfRunsScoredResponse(HttpStatus.BAD_REQUEST, battingNoOfRunsScored.getMessage()), HttpStatus.BAD_REQUEST);
		}	
		BattingNoOfRunsScored scored = noOfRunsScoredRepo.save(battingNoOfRunsScored.getBattingNoOfRunsScored());
		BattingRunsAtEndOfScored atEndOfScored =cricketProcessingUtils.calculateAtEndOfForCurrentOver(scored);
		cricketProcessingUtils.calculateRunRate(atEndOfScored);
		return new ResponseEntity<BattingNoOfRunsScoredResponse>(new BattingNoOfRunsScoredResponse(HttpStatus.OK, Messages.EVERYTHING_OK, scored), HttpStatus.OK);
	}
	
	public ResponseEntity<BattingNoOfRunsScoredResponse> getValidatedForID( Long recordId)
	{
		ValidatedBattingNoOfRunsScored validatedBattingNoOfRunsScored = battingNoOfRunsScoredValidator.getPlayerBattingRecordFromId(recordId);
		if( validatedBattingNoOfRunsScored.getIsErrorPresent() ){
			return new ResponseEntity<BattingNoOfRunsScoredResponse>(new BattingNoOfRunsScoredResponse(HttpStatus.BAD_REQUEST, validatedBattingNoOfRunsScored.getMessage()), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<BattingNoOfRunsScoredResponse>(new BattingNoOfRunsScoredResponse(HttpStatus.OK, Messages.EVERYTHING_OK, validatedBattingNoOfRunsScored.getBattingNoOfRunsScored()), HttpStatus.OK);
	}
	
	@Transactional(  rollbackOn= Exception.class )
	@RequestMapping ( method= {RequestMethod.PUT, RequestMethod.PATCH }, value= RestEndpointConstants.BATTING_NO_OF_RUNS_SCORED_END_POINT)
	public @ResponseBody ResponseEntity<BattingNoOfRunsScoredResponse> updatePlayerInfo(@PathVariable @NotBlank( message = ValidationMessages.BATTING_NO_OF_RUNS_ID_NOT_EMPTY ) Long Id,@RequestBody @Valid BattingNoOfRunsScoredRequest singlePlayerRuns)
	{
		ResponseEntity<BattingNoOfRunsScoredResponse> responseEntity = getValidatedForID(Id);
		if(! HttpStatus.OK.equals(responseEntity.getStatusCode()))
		{
			return responseEntity;
		}
		ValidatedBattingNoOfRunsScored battingNoOfRunsScoredValid = battingNoOfRunsScoredValidator.getObjectFromRequest(singlePlayerRuns);
		if( battingNoOfRunsScoredValid.getIsErrorPresent() ){
			return new ResponseEntity<BattingNoOfRunsScoredResponse>(new BattingNoOfRunsScoredResponse(HttpStatus.BAD_REQUEST, battingNoOfRunsScoredValid.getMessage()), HttpStatus.BAD_REQUEST);
		}
		
		BattingNoOfRunsScored battingNoOfRunsScoredFromDB = responseEntity.getBody().getBattingNoOfRunsScored();
		battingNoOfRunsScoredValid.getBattingNoOfRunsScored().setId(Id);
		battingNoOfRunsScoredValid.getBattingNoOfRunsScored().setCreatedTs(battingNoOfRunsScoredFromDB.getCreatedTs());
		BeanUtils.copyProperties(battingNoOfRunsScoredValid.getBattingNoOfRunsScored(),  battingNoOfRunsScoredFromDB);
		battingNoOfRunsScoredFromDB= noOfRunsScoredRepo.save(battingNoOfRunsScoredFromDB);
		BattingRunsAtEndOfScored atEndOfScored = cricketProcessingUtils.calculateAtEndOfForCurrentOver(battingNoOfRunsScoredFromDB);
		cricketProcessingUtils.calculateRunRate(atEndOfScored);
		return new ResponseEntity<BattingNoOfRunsScoredResponse>(new BattingNoOfRunsScoredResponse(HttpStatus.OK, Messages.EVERYTHING_OK, battingNoOfRunsScoredFromDB), HttpStatus.OK);
	}
	
	@Transactional(  rollbackOn= Exception.class )
	@RequestMapping ( method= { RequestMethod.DELETE }, value= RestEndpointConstants.BATTING_NO_OF_RUNS_SCORED_END_POINT)
	public @ResponseBody ResponseEntity<BattingNoOfRunsScoredResponse> deletePlayerInfo(@PathVariable @NotBlank(message =ValidationMessages.PLAYER_ID_NOT_EMPTY) Long Id)
	{
		ResponseEntity<BattingNoOfRunsScoredResponse> responseEntity = getValidatedForID(Id);
		if(! HttpStatus.OK.equals(responseEntity.getStatusCode()))
		{
			return responseEntity;
		}
		
		BattingNoOfRunsScored battingNoOfRunsScored = responseEntity.getBody().getBattingNoOfRunsScored();
		noOfRunsScoredRepo.delete(battingNoOfRunsScored);
		
		BattingRunsAtEndOfScored battingNoOfRunsScoredForOver = battingScoreRepo.findByIdentifier(battingNoOfRunsScored.getId());
		if( null != battingNoOfRunsScoredForOver )
		battingScoreRepo.delete(battingNoOfRunsScoredForOver);
		
		BattingRunRatePerOver battingRunRatePerOver = runRateRepo.findByIdentifier(battingNoOfRunsScored.getId());
		if( null != battingRunRatePerOver )
		runRateRepo.delete(battingRunRatePerOver);
		
		return new ResponseEntity<BattingNoOfRunsScoredResponse>(new BattingNoOfRunsScoredResponse(HttpStatus.OK, Messages.EVERYTHING_OK, battingNoOfRunsScored), HttpStatus.OK);
	}
	
	@RequestMapping ( method= RequestMethod.GET, value= RestEndpointConstants.BATTING_NO_OF_RUNS_SCORED_BASE_VAR)
	public @ResponseBody Page<BattingNoOfRunsScored> getPlayerInfo( Pageable pageable)
	{
		return noOfRunsScoredRepo.findAll(pageable); 
	}
	
}
