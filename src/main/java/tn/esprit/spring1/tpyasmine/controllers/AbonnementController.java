package tn.esprit.spring1.tpyasmine.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring1.tpyasmine.Service.IAbonnementService;
import tn.esprit.spring1.tpyasmine.entities.Abonnement;

import java.util.List;

@RestController
@RequestMapping("abonnements")
public class AbonnementController {

    private final IAbonnementService abonnementService;

    @Autowired
    public AbonnementController(IAbonnementService abonnementService) {

        this.abonnementService = abonnementService;
    }

    @PostMapping
    public Abonnement addAbonnement(@RequestBody Abonnement abonnement) {
        return abonnementService.addAbonnement(abonnement);
    }

    @PutMapping("/{id}")
    public Abonnement updateAbonnement(@PathVariable int id, @RequestBody Abonnement abonnement) {
        abonnement.setId(id);
        return abonnementService.updateAbonnement(abonnement);
    }


    @GetMapping
    public List<Abonnement> findAll() {

        return abonnementService.findAll();
    }

    @GetMapping("/{id}")
    public Abonnement findById(@PathVariable int id) {

        return abonnementService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {

        abonnementService.delete(id);
    }
}
