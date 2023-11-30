package tn.esprit.spring1.tpyasmine.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring1.tpyasmine.Service.ISkieurService;
import tn.esprit.spring1.tpyasmine.entities.Skieur;
import tn.esprit.spring1.tpyasmine.entities.enums.TypeAbonnement;

import java.util.List;

@RestController
@RequestMapping("skieurs")
public class SkieurController {

    private final ISkieurService skieurService;

    @Autowired
    public SkieurController(ISkieurService skieurService) {


        this.skieurService = skieurService;
    }

    @PostMapping
    public Skieur addSkieur(@RequestBody Skieur skieur) {

        return skieurService.addSkieur(skieur);
    }

    @PutMapping
    public Skieur updateSkieur (@RequestBody  Skieur skieur){
        return skieurService.updateSkieur(skieur);
    }



    @GetMapping
    public List<Skieur> findAll() {

        return skieurService.findAll();
    }

    @GetMapping("/{numSkieur}")
    public Skieur getById(@PathVariable long numSkieur){

        return skieurService. findById(numSkieur);
    }



    @DeleteMapping("/{numSkieur}")
    public void delete(@RequestBody long  numSkieur)    {

        skieurService.delete(numSkieur);
    }

    @PostMapping("/{numSkieur}/pistes/{numPiste}")
    public Skieur assignSkieurToPiste(@PathVariable Long numSkieur, @PathVariable Long numPiste) {
            return skieurService.assignSkierToPiste(numSkieur, numPiste);
    }

    @PostMapping("/{numCourse}")
    public Skieur addSkierAndAssignToCourse(@RequestBody Skieur skieur, @PathVariable Long numCourse) {
        return skieurService.addSkierAndAssignToCourse(skieur, numCourse);
    }

    @GetMapping("/getSkiersBySubscription")
    public List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement) {
        return skieurService.retrieveSkiersBySubscriptionType(typeAbonnement);
    }

}
