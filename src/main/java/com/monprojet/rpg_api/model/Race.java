package com.monprojet.rpg_api.model;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;

// Race.java (classe parente)
@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "race_type")
public abstract class Race {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private int bonusStat;
    // getters/setters
}
