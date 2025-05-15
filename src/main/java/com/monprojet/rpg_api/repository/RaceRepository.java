package com.monprojet.rpg_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.monprojet.rpg_api.model.Race;

public interface RaceRepository extends JpaRepository<Race, Long> {
    @Query("SELECT r FROM Race r WHERE TYPE(r) = Nain")
    List<Race> findAllNains();
} 