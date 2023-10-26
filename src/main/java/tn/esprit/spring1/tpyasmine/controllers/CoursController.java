package tn.esprit.spring1.tpyasmine.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring1.tpyasmine.Service.ICoursService;
import tn.esprit.spring1.tpyasmine.entities.Cours;

import java.util.List;

@RestController
@RequestMapping("courss")
public class CoursController {

    private final ICoursService coursService;

    @Autowired
    public CoursController(ICoursService coursService) {

        this.coursService = coursService;
    }

    @PostMapping
    public Cours addCours(@RequestBody Cours cours) {

        return coursService.addCours(cours);
    }

    @PutMapping("/{id}")
    public Cours updateCours(@PathVariable int id, @RequestBody Cours cours) {
        cours.setId(id);
        return coursService.updateCours(cours);
    }


    @GetMapping
    public List<Cours> findAll() {

        return coursService.findAll();
    }

    @GetMapping("/{id}") //same name here and the name declared as a parameter
    public Cours findById(@PathVariable int id) {

        return coursService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {

        coursService.delete(id);
    }
}
