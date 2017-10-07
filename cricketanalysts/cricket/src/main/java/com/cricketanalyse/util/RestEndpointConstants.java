package com.cricketanalyse.util;

public class RestEndpointConstants {
	public static final String PLAYERS_BASE_VAR = "/players";
	public static final String PLAYERS_END_POINT = PLAYERS_BASE_VAR+"/{Id}";
	public static final String PLAYER_GET_ALL = PLAYERS_BASE_VAR+ "-all";
	
	public static final String TEAMS_BASE_VAR = "/teams";
	public static final String TEAMS_END_POINT = TEAMS_BASE_VAR+"/{Id}";
	public static final String TEAMS_GET_ALL = TEAMS_BASE_VAR + "-all";
	public static final String BATTING_NO_OF_RUNS_SCORED_BASE_VAR = "/battingNoOfRunsScoreds";
	public static final String BATTING_NO_OF_RUNS_SCORED_END_POINT = BATTING_NO_OF_RUNS_SCORED_BASE_VAR+"/{Id}";
}
