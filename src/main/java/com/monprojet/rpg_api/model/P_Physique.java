package com.monprojet.rpg_api.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

// P_Physique.java (hérite de Race)
@Entity
@DiscriminatorValue("P_Physique")
public class P_Physique extends Pouvoir {
    
}
