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

import com.monprojet.rpg_api.model.Metier;
import com.monprojet.rpg_api.repository.MetierRepository;

@RestController
@RequestMapping("/api/metiers")
public class MetierController {
    @Autowired
    private MetierRepository metierRepository;

    @GetMapping
    public List<Metier> getAll() {
        return metierRepository.findAll();
    }

    @GetMapping("/{id}")
    public Metier getById(@PathVariable Long id) {
        return metierRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Metier create(@RequestBody Metier metier) {
        return metierRepository.save(metier);
    }

    @PutMapping("/{id}")
    public Metier update(@PathVariable Long id, @RequestBody Metier metier) {
        metier.setId(id);
        return metierRepository.save(metier);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        metierRepository.deleteById(id);
    }
} 