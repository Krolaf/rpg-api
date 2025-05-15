package com.monprojet.rpg_api.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

// P_Energie.java (hérite de Race)
@Entity
@DiscriminatorValue("P_Energie")
public class P_Energie extends Pouvoir {
    
}
