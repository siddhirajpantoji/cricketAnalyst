package com.cricketanalyse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cricketanalyse.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
