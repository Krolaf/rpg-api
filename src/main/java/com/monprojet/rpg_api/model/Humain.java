package com.monprojet.rpg_api.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

// Humain.java (hérite de Race)
@Entity
@DiscriminatorValue("Humain")
public class Humain extends Race {
    
}
