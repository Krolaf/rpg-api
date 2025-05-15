package com.monprojet.rpg_api.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

// Elfe.java (hérite de Race)
@Entity
@DiscriminatorValue("Elfe")
public class Elfe extends Race {
    
}
