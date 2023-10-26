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

    @PutMapping("/{id}")
    public Inscription updateInscription(@PathVariable int id, @RequestBody Inscription inscription) {
        inscription.setId(id);
        return inscriptionService.updateInscription(inscription);
    }


    @GetMapping
    public List<Inscription> findAll() {

        return inscriptionService.findAll();
    }

    @GetMapping("/{id}")
    public Inscription findById(@PathVariable int id) {

        return inscriptionService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {

        inscriptionService.delete(id);
    }




    @PostMapping("/addRegistrationAndAssignToSkier/{id}")
    public Inscription addRegistrationAndAssignToSkier(@RequestBody Inscription inscription, @PathVariable int id) { //id du skieur
        return inscriptionService.addInscriptionAndAssignToSkier(inscription, id);


    }



}
