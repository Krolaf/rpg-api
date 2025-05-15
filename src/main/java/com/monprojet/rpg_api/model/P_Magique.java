package com.monprojet.rpg_api.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

// P_Magique.java (hérite de Race)
@Entity
@DiscriminatorValue("P_Magique")
public class P_Magique extends Pouvoir {
    
}
