package com.cricketanalyse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cricketanalyse.entities.BattingRunsAtEndOfScored;

public interface BattingRunsAtEndOfScoredRepo extends JpaRepository<BattingRunsAtEndOfScored, Long>{
	
	public BattingRunsAtEndOfScored findByIdentifier(Long identifier);
}
