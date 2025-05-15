package com.monprojet.rpg_api.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

// Nain.java (hérite de Race)
@Entity
@DiscriminatorValue("Nain")
public class Nain extends Race {
    
}
