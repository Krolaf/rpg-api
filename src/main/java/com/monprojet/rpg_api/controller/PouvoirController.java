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

import com.monprojet.rpg_api.model.Pouvoir;
import com.monprojet.rpg_api.repository.PersonnageRepository;
import com.monprojet.rpg_api.repository.PouvoirRepository;

@RestController
@RequestMapping("/api/pouvoirs")
public class PouvoirController {
    @Autowired
    private PouvoirRepository pouvoirRepository;
    @Autowired
    private PersonnageRepository personnageRepository;

    @GetMapping
    public List<Pouvoir> getAll() {
        return pouvoirRepository.findAll();
    }


    @GetMapping("/{id}")
    public Pouvoir getById(@PathVariable Long id) {
        return pouvoirRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Pouvoir create(@RequestBody Pouvoir pouvoir) {
        return pouvoirRepository.save(pouvoir);
    }

    @PutMapping("/{id}")
    public Pouvoir update(@PathVariable Long id, @RequestBody Pouvoir pouvoir) {
        pouvoir.setId(id);
        return pouvoirRepository.save(pouvoir);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        pouvoirRepository.deleteById(id);
    }
} 