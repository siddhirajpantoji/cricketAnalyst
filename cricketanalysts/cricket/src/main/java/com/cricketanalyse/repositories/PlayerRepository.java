package com.cricketanalyse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cricketanalyse.entities.Player;

@RepositoryRestResource
public interface PlayerRepository extends JpaRepository<Player, Long> {

}
