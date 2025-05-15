package com.monprojet.rpg_api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.monprojet.rpg_api.model.Elfe;
import com.monprojet.rpg_api.model.Humain;
import com.monprojet.rpg_api.model.Metier;
import com.monprojet.rpg_api.model.Nain;
import com.monprojet.rpg_api.model.Orc;
import com.monprojet.rpg_api.model.P_Energie;
import com.monprojet.rpg_api.model.P_Magique;
import com.monprojet.rpg_api.model.P_Physique;
import com.monprojet.rpg_api.model.Personnage;
import com.monprojet.rpg_api.model.Pouvoir;
import com.monprojet.rpg_api.model.Race;
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
    public String home(Model model) {
        model.addAttribute("races", raceRepository.findAll());
        model.addAttribute("pouvoirs", pouvoirRepository.findAll());
        model.addAttribute("metiers", metierRepository.findAll());
        model.addAttribute("statsList", statsRepository.findAll());
        model.addAttribute("personnages", personnageRepository.findAll());
        return "home";
    }

    @PostMapping("/create-race")
    public String createRace(@RequestParam String nom, @RequestParam int bonusStat, @RequestParam String type) {
        Race race;
        switch (type) {
            case "Elfe": race = new Elfe(); break;
            case "Nain": race = new Nain(); break;
            case "Orc": race = new Orc(); break;
            case "Humain": race = new Humain(); break;
            default: race = new Humain();
        }
        race.setNom(nom);
        race.setBonusStat(bonusStat);
        raceRepository.save(race);
        return "redirect:/";
    }

    @PostMapping("/create-pouvoir")
    public String createPouvoir(@RequestParam String nom, @RequestParam String cout, @RequestParam String type) {
        Pouvoir pouvoir;
        switch (type) {
            case "P_Magique": pouvoir = new P_Magique(); break;
            case "P_Physique": pouvoir = new P_Physique(); break;
            case "P_Energie": pouvoir = new P_Energie(); break;
            default: pouvoir = new P_Magique();
        }
        pouvoir.setNom(nom);
        pouvoir.setCout(cout);
        pouvoirRepository.save(pouvoir);
        return "redirect:/";
    }

    @PostMapping("/create-metier")
    public String createMetier(@RequestParam String nom, @RequestParam boolean legal, @RequestParam float salaire) {
        Metier metier = new Metier();
        metier.setNom(nom);
        metier.setLegal(legal);
        metier.setSalaire(salaire);
        metierRepository.save(metier);
        return "redirect:/";
    }

    @PostMapping("/create-stats")
    public String createStats(@RequestParam String nom, @RequestParam int valeur, @RequestParam int bonus) {
        Stats stats = new Stats();
        stats.setNom(nom);
        stats.setValeur(valeur);
        stats.setBonus(bonus);
        statsRepository.save(stats);
        return "redirect:/";
    }

    @PostMapping("/create-personnage")
    public String createPersonnage(
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
        return "redirect:/";
    }
} 