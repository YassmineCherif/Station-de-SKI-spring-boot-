package tn.esprit.spring1.tpyasmine.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring1.tpyasmine.Service.IMoniteurService;
import tn.esprit.spring1.tpyasmine.entities.Moniteur;

import java.util.List;

@RestController
@RequestMapping("moniteurs")
public class MoniteurController {

    private final IMoniteurService moniteurService;

    @Autowired
    public MoniteurController(IMoniteurService moniteurService) {
    this.moniteurService = moniteurService;
    }


    @PostMapping
    public Moniteur addMoniteur(@RequestBody Moniteur moniteur) {
        return moniteurService.addMoniteur(moniteur);
    }

    @PutMapping("/{id}")
    public Moniteur updateMoniteur(@PathVariable int id, @RequestBody Moniteur moniteur) {
        moniteur.setId(id);
        return moniteurService.updateMoniteur(moniteur);
    }


    @GetMapping
    public List<Moniteur> findAll() {

        return moniteurService.findAll();
    }

    @GetMapping("/{id}")
    public Moniteur findById(@PathVariable int id) {

        return moniteurService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {

        moniteurService.delete(id);
    }
}
