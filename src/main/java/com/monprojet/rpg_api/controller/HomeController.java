package com.monprojet.rpg_api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.monprojet.rpg_api.model.Personnage;
import com.monprojet.rpg_api.model.Stats;
import com.monprojet.rpg_api.repository.MetierRepository;
import com.monprojet.rpg_api.repository.PersonnageRepository;
import com.monprojet.rpg_api.repository.PouvoirRepository;
import com.monprojet.rpg_api.repository.RaceRepository;
import com.monprojet.rpg_api.repository.StatsRepository;

@Controller
public class HomeController {
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

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping("/create-personnage")
    public String createPersonnage(
            @RequestParam String nom,
            @RequestParam int age,
            @RequestParam Long raceId,
            @RequestParam Long pouvoirId,
            @RequestParam Long metierId,
            @RequestParam(required = false) String statsIds,
            Model model
    ) {
        Personnage personnage = new Personnage();
        personnage.setNom(nom);
        personnage.setAge(age);
        personnage.setRace(raceRepository.findById(raceId).orElse(null));
        personnage.setPouvoir(pouvoirRepository.findById(pouvoirId).orElse(null));
        personnage.setMetier(metierRepository.findById(metierId).orElse(null));
        if (statsIds != null && !statsIds.isEmpty()) {
            String[] ids = statsIds.split(",");
            List<Stats> statsList = new ArrayList<>();
            for (String id : ids) {
                statsRepository.findById(Long.parseLong(id.trim())).ifPresent(statsList::add);
            }
            personnage.setStats(statsList);
        }
        personnageRepository.save(personnage);
        model.addAttribute("message", "Personnage créé avec succès !");
        return "home";
    }
} 