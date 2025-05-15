package com.monprojet.rpg_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monprojet.rpg_api.model.Personnage;

public interface PersonnageRepository extends JpaRepository<Personnage, Long> {
} 