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

import com.monprojet.rpg_api.model.Metier;
import com.monprojet.rpg_api.repository.MetierRepository;

@Controller
@RequestMapping("/metiers")
public class MetierController {
    @Autowired
    private MetierRepository metierRepository;

    @GetMapping
    public String listMetiers(Model model) {
        model.addAttribute("metiers", metierRepository.findAll());
        return "metiers";
    }

    @PostMapping("/add")
    public String addMetier(@RequestParam String nom, @RequestParam boolean legal, @RequestParam float salaire) {
        Metier metier = new Metier();
        metier.setNom(nom);
        metier.setLegal(legal);
        metier.setSalaire(salaire);
        metierRepository.save(metier);
        return "redirect:/metiers";
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