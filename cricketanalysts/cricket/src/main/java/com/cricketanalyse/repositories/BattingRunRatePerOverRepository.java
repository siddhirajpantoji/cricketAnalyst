package com.cricketanalyse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cricketanalyse.entities.BattingRunRatePerOver;

public interface BattingRunRatePerOverRepository extends JpaRepository<BattingRunRatePerOver, Long> {

	BattingRunRatePerOver findByIdentifier(Long identifier);
}
