package com.monprojet.rpg_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.monprojet.rpg_api.model.Pouvoir;

public interface PouvoirRepository extends JpaRepository<Pouvoir, Long> {
    @Query("SELECT p FROM Pouvoir p WHERE TYPE(p) = P_Physique")
    List<Pouvoir> findAllPhysiques();
} 