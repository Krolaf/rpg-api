package com.monprojet.rpg_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monprojet.rpg_api.model.Race;

public interface RaceRepository extends JpaRepository<Race, Long> {
} 