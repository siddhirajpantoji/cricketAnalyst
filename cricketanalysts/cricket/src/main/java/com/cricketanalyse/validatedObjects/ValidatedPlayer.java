package com.cricketanalyse.validatedObjects;

import com.cricketanalyse.entities.Player;

public class ValidatedPlayer extends BaseValidEntity {

	private Player player;
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ValidatedPlayer(Boolean isErrorPresent, String message) {
		super(isErrorPresent, message);
	}

	public ValidatedPlayer(Player player) {
		super(false, "");
		this.player = player;
	}

}
