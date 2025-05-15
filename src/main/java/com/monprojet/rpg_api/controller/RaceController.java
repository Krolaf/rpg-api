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

import com.monprojet.rpg_api.model.Race;
import com.monprojet.rpg_api.repository.RaceRepository;

@RestController
@RequestMapping("/api/races")
public class RaceController {
    @Autowired
    private RaceRepository raceRepository;

    @GetMapping
    public List<Race> getAll() {
        return raceRepository.findAll();
    }


    @GetMapping("/{id}")
    public Race getById(@PathVariable Long id) {
        return raceRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Race create(@RequestBody Race race) {
        return raceRepository.save(race);
    }

    @PutMapping("/{id}")
    public Race update(@PathVariable Long id, @RequestBody Race race) {
        race.setId(id);
        return raceRepository.save(race);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        raceRepository.deleteById(id);
    }
} 