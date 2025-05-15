package com.monprojet.rpg_api.model;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "pouvoir_type")
public abstract class Pouvoir {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private String cout; // Enum à affiner
    // getters/setters
}