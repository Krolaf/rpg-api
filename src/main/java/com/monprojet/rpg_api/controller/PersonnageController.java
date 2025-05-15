package com.monprojet.rpg_api.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.monprojet.rpg_api.model.Personnage;
import com.monprojet.rpg_api.model.Stats;
import com.monprojet.rpg_api.repository.MetierRepository;
import com.monprojet.rpg_api.repository.PersonnageRepository;
import com.monprojet.rpg_api.repository.PouvoirRepository;
import com.monprojet.rpg_api.repository.RaceRepository;
import com.monprojet.rpg_api.repository.StatsRepository;

@Controller
@RequestMapping("/personnages")
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
    public String listPersonnages(Model model) {
        model.addAttribute("personnages", personnageRepository.findAll());
        model.addAttribute("races", raceRepository.findAll());
        model.addAttribute("pouvoirs", pouvoirRepository.findAll());
        model.addAttribute("metiers", metierRepository.findAll());
        model.addAttribute("statsList", statsRepository.findAll());
        return "personnages";
    }

    @PostMapping("/add")
    public String addPersonnage(
            @RequestParam String nom,
            @RequestParam int age,
            @RequestParam Long raceId,
            @RequestParam Long pouvoirId,
            @RequestParam Long metierId,
            @RequestParam(required = false) List<Long> statsIds
    ) {
        Personnage personnage = new Personnage();
        personnage.setNom(nom);
        personnage.setAge(age);
        personnage.setRace(raceRepository.findById(raceId).orElse(null));
        personnage.setPouvoir(pouvoirRepository.findById(pouvoirId).orElse(null));
        personnage.setMetier(metierRepository.findById(metierId).orElse(null));
        if (statsIds != null) {
            List<Stats> statsList = new ArrayList<>();
            for (Long id : statsIds) {
                statsRepository.findById(id).ifPresent(statsList::add);
            }
            personnage.setStats(statsList);
        }
        personnageRepository.save(personnage);
        return "redirect:/personnages";
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