package com.cricketanalyse.response;

import org.springframework.http.HttpStatus;

import com.cricketanalyse.entities.Player;

public class PlayerResponse extends BaseResponse {

	private Player player;

	public PlayerResponse(HttpStatus status, String message, Player player) {
		super(status, message);
		this.player = player;
	}

	public PlayerResponse(HttpStatus status, String message) {
		super(status, message);
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
}
