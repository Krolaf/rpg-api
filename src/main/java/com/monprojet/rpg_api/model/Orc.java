package com.monprojet.rpg_api.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

// Orc.java (hérite de Race)
@Entity
@DiscriminatorValue("Orc")
public class Orc extends Race {
    
}