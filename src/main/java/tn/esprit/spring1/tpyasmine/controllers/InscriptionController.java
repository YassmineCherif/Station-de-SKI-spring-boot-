package tn.esprit.spring1.tpyasmine.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring1.tpyasmine.Service.*;
import tn.esprit.spring1.tpyasmine.entities.*;
import tn.esprit.spring1.tpyasmine.entities.enums.*;


import java.util.List;
import java.util.Set;

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

    @PutMapping("/addAndAssignToSkierAndCourse/{numSkieur}/{numCourse}")
    public Inscription addAndAssignToSkierAndCourse(@RequestBody Inscription inscription, @PathVariable("numSkieur") Long numSkieur,@PathVariable("numCourse") Long numCours)
    {
        return  inscriptionService.addRegistrationAndAssignToSkierAndCourse(inscription,numSkieur,numCours);
    }

    @GetMapping("/numWeeks/{numInstructor}/{support}")
    public List<Integer> numWeeksCourseOfInstructorBySupport(@PathVariable("numInstructor")Long numInstructor, @PathVariable("support") Support support) {
        return inscriptionService.numWeeksCourseOfInstructorBySupport(numInstructor,support);
    }





}
