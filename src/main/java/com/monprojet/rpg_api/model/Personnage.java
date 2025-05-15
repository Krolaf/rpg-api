package com.monprojet.rpg_api.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

// Personnage.java
@Entity
public class Personnage {
    @Id @GeneratedValue
    private Long id;
    private String nom;
    private int age;
    @ManyToOne
    private Race race;
    @ManyToOne
    private Pouvoir pouvoir;
    @ManyToOne
    private Metier metier;
    @OneToMany
    private List<Stats> stats;
    // getters/setters
    
}
