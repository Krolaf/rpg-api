package com.monprojet.rpg_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monprojet.rpg_api.model.Personnage;
import com.monprojet.rpg_api.repository.MetierRepository;
import com.monprojet.rpg_api.repository.PersonnageRepository;
import com.monprojet.rpg_api.repository.PouvoirRepository;
import com.monprojet.rpg_api.repository.RaceRepository;
import com.monprojet.rpg_api.repository.StatsRepository;

@RestController
@RequestMapping("/api/personnages")
public class PersonnageController {
    @Autowired
    private PersonnageRepository personnageRepository;
    @Autowired
    private RaceRepository raceRepository;
    @Autowired
    private PouvoirRepository pouvoirRepository;
    @Autowired
    private MetierRepository metierRepository;
    @Autowired
    private StatsRepository statsRepository;

    @GetMapping
    public List<Personnage> getAll() {
        return personnageRepository.findAll();
    }

    @GetMapping("/{id}")
    public Personnage getById(@PathVariable Long id) {
        return personnageRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Personnage create(@RequestBody Personnage personnage) {
        return personnageRepository.save(personnage);
    }

    @PutMapping("/{id}")
    public Personnage update(@PathVariable Long id, @RequestBody Personnage personnage) {
        personnage.setId(id);
        return personnageRepository.save(personnage);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        personnageRepository.deleteById(id);
    }
} 