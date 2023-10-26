package tn.esprit.spring1.tpyasmine.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring1.tpyasmine.Service.ISkieurService;
import tn.esprit.spring1.tpyasmine.entities.Skieur;

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

    @PutMapping("/{id}")
    public Skieur updateSkieur(@PathVariable int id, @RequestBody Skieur skieur) {
        skieur.setId(id);
        return skieurService.updateSkieur(skieur);
    }


    @GetMapping
    public List<Skieur> findAll() {

        return skieurService.findAll();
    }

    @GetMapping("/{id}")
    public Skieur getById(@PathVariable int id) {

        return skieurService.findById(id);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {

        skieurService.delete(id);
    }
}
