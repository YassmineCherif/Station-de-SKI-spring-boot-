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

    @PutMapping
    public Moniteur updateMoniteur( @RequestBody Moniteur moniteur) {
        return moniteurService.updateMoniteur(moniteur);
    }


    @GetMapping
    public List<Moniteur> findAll() {

        return moniteurService.findAll();
    }

    @GetMapping("/{numMoniteur}")
    public Moniteur findById(@PathVariable long numMoniteur){

        return moniteurService. findById(numMoniteur);
    }


    @DeleteMapping("/{numMoniteur}")
    public void delete(@RequestBody long  numMoniteur)    {

        moniteurService.delete(numMoniteur);
    }


    @PostMapping("/{numCourse}")
    public Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, @PathVariable long numCours){

        return moniteurService.addInstructorAndAssignToCourse(moniteur,numCours);
    }

}
