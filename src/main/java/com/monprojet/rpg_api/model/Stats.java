package com.monprojet.rpg_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Stats {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private int valeur;
    private int bonus;

    // getters/setters
}
