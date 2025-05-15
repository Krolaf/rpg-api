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

import com.monprojet.rpg_api.model.P_Energie;
import com.monprojet.rpg_api.model.P_Magique;
import com.monprojet.rpg_api.model.P_Physique;
import com.monprojet.rpg_api.model.Pouvoir;
import com.monprojet.rpg_api.repository.PouvoirRepository;

@Controller
@RequestMapping("/pouvoirs")
public class PouvoirController {
    @Autowired
    private PouvoirRepository pouvoirRepository;

    @GetMapping
    public String listPouvoirs(Model model) {
        model.addAttribute("pouvoirs", pouvoirRepository.findAll());
        return "pouvoirs";
    }

    @PostMapping("/add")
    public String addPouvoir(@RequestParam String nom, @RequestParam String cout, @RequestParam String type) {
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
        return "redirect:/pouvoirs";
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