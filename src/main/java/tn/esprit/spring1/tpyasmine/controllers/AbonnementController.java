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

    @PutMapping
    public Abonnement updateAbonnement( @RequestBody Abonnement abonnement) {
        return abonnementService.updateAbonnement(abonnement);
    }


    @GetMapping
    public List<Abonnement> findAll() {

        return abonnementService.findAll();
    }

    @GetMapping("/{numAbonnement}")
    public Abonnement findById(@PathVariable long numAbonnement){

        return abonnementService. findById(numAbonnement);
    }


    @DeleteMapping("/{numCours}")
    public void delete(@RequestBody long  numCours)    {

        abonnementService.delete(numCours);
    }



}
