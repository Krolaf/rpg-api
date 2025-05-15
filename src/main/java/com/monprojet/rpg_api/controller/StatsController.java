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

import com.monprojet.rpg_api.model.Stats;
import com.monprojet.rpg_api.repository.StatsRepository;

@RestController
@RequestMapping("/api/stats")
public class StatsController {
    @Autowired
    private StatsRepository statsRepository;

    @GetMapping
    public List<Stats> getAll() {
        return statsRepository.findAll();
    }

    @GetMapping("/{id}")
    public Stats getById(@PathVariable Long id) {
        return statsRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Stats create(@RequestBody Stats stats) {
        return statsRepository.save(stats);
    }

    @PutMapping("/{id}")
    public Stats update(@PathVariable Long id, @RequestBody Stats stats) {
        stats.setId(id);
        return statsRepository.save(stats);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        statsRepository.deleteById(id);
    }
} 