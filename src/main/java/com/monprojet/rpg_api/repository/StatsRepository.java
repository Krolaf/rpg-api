package com.monprojet.rpg_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monprojet.rpg_api.model.Stats;

public interface StatsRepository extends JpaRepository<Stats, Long> {
} 