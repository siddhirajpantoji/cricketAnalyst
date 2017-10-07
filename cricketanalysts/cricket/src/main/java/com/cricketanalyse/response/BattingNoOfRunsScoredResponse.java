package com.cricketanalyse.response;

import org.springframework.http.HttpStatus;

import com.cricketanalyse.entities.BattingNoOfRunsScored;

public class BattingNoOfRunsScoredResponse extends BaseResponse {

	private BattingNoOfRunsScored battingNoOfRunsScored;

	public BattingNoOfRunsScoredResponse(HttpStatus status, String message) {
		super(status, message);
	}

	public BattingNoOfRunsScoredResponse(HttpStatus status, String message,
			BattingNoOfRunsScored battingNoOfRunsScored) {
		super(status, message);
		this.battingNoOfRunsScored = battingNoOfRunsScored;
	}

	public BattingNoOfRunsScored getBattingNoOfRunsScored() {
		return battingNoOfRunsScored;
	}

	public void setBattingNoOfRunsScored(BattingNoOfRunsScored battingNoOfRunsScored) {
		this.battingNoOfRunsScored = battingNoOfRunsScored;
	}

}
