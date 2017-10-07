package com.cricketanalyse.validatedObjects;

import com.cricketanalyse.entities.BattingNoOfRunsScored;

public class ValidatedBattingNoOfRunsScored extends BaseValidEntity {

	private BattingNoOfRunsScored battingNoOfRunsScored;
	
	public ValidatedBattingNoOfRunsScored(Boolean isErrorPresent, String message) {
		super(isErrorPresent, message);
	}
	
	public ValidatedBattingNoOfRunsScored(BattingNoOfRunsScored battingNoOfRunsScored) {
		super(false, "");
		this.battingNoOfRunsScored = battingNoOfRunsScored;
	}

	public BattingNoOfRunsScored getBattingNoOfRunsScored() {
		return battingNoOfRunsScored;
	}

	public void setBattingNoOfRunsScored(BattingNoOfRunsScored battingNoOfRunsScored) {
		this.battingNoOfRunsScored = battingNoOfRunsScored;
	}
	
}
