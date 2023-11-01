package tn.esprit.spring1.tpyasmine.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring1.tpyasmine.Service.IInscriptionService;
import tn.esprit.spring1.tpyasmine.entities.Inscription;

import java.util.List;

@RestController
@RequestMapping("inscriptions")
public class InscriptionController {

    private final IInscriptionService inscriptionService;

    @Autowired
    public InscriptionController(IInscriptionService inscriptionService) {
        this.inscriptionService = inscriptionService;
    }

    @PostMapping
    public Inscription addInscription(@RequestBody Inscription inscription) {
        return inscriptionService.addInscription(inscription);
    }

    @PutMapping
    public Inscription updateInscription( @RequestBody Inscription inscription) {
        return inscriptionService.updateInscription(inscription);
    }


    @GetMapping
    public List<Inscription> findAll() {

        return inscriptionService.findAll();
    }

    @GetMapping("/{numInscription}")
    public Inscription findById(@PathVariable long numInscription){
        return inscriptionService. findById(numInscription);
    }

    @DeleteMapping("/{numInscription}")
    public void delete(@RequestBody long  numInscription)    {

        inscriptionService.delete(numInscription);
    }



    @PostMapping("/{numSkieur}")
    public Inscription addRegistrationAndAssignToSkier( @RequestBody Inscription inscription,@PathVariable long numSkieur){
        return inscriptionService.addRegistrationAndAssignToSkier(inscription,numSkieur);
    }


    @PostMapping("/{numInscription}/assign/{numCours}")
    public Inscription assignRegistrationToCourse( @PathVariable Long numInscription,@PathVariable Long numCours){
        return inscriptionService.assignRegistrationToCourse(numInscription,numCours);
    }







}
