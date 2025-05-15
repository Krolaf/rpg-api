package com.monprojet.rpg_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.monprojet.rpg_api.model.Elfe;
import com.monprojet.rpg_api.model.Humain;
import com.monprojet.rpg_api.model.Nain;
import com.monprojet.rpg_api.model.Orc;
import com.monprojet.rpg_api.model.Race;
import com.monprojet.rpg_api.repository.RaceRepository;

@Controller
@RequestMapping("/races")
public class RaceController {
    @Autowired
    private RaceRepository raceRepository;

    @GetMapping
    public String listRaces(Model model) {
        model.addAttribute("races", raceRepository.findAll());
        return "races";
    }

    @PostMapping("/add")
    public String addRace(@RequestParam String nom, @RequestParam int bonusStat, @RequestParam String type) {
        Race race;
        switch (type) {
            case "Elfe": race = new Elfe(); break;
            case "Nain": race = new Nain(); break;
            case "Orc": race = new Orc(); break;
            case "Humain": race = new Humain(); break;
            default: race = new Humain(); // fallback
        }
        race.setNom(nom);
        race.setBonusStat(bonusStat);
        raceRepository.save(race);
        return "redirect:/races";
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