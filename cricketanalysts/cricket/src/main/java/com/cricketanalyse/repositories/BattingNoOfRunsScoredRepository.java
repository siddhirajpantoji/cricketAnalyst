package com.cricketanalyse.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cricketanalyse.entities.BattingNoOfRunsScored;

@RepositoryRestResource ( path="noOfRunsScored", exported = true)
public interface BattingNoOfRunsScoredRepository extends JpaRepository<BattingNoOfRunsScored, Long> {

	BattingNoOfRunsScored findByIdentifier(Long identifier);
	
	@Query ( nativeQuery=true ,value ="Select * From batting_no_of_runs_scored where team_id = :againstTeam and player_id = :player")
	public List<BattingNoOfRunsScored> findByAgainstTeamAndPlayer(@Param("againstTeam")Long againstTeam,@Param("player")Long player);
}
