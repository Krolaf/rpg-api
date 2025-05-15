package com.monprojet.rpg_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Metier {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private boolean legal;
    private float salaire;

    // getters/setters
}
