package tn.esprit.spring1.tpyasmine.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring1.tpyasmine.Service.IPisteService;
import tn.esprit.spring1.tpyasmine.entities.Piste;

import java.util.List;

@RestController
@RequestMapping("pistes")
public class PisteController {

    private final IPisteService pisteService;

    @Autowired
    public PisteController(IPisteService pisteService) {

        this.pisteService = pisteService;
    }

    @PostMapping
    public Piste addPiste(@RequestBody Piste piste) {

        return pisteService.addPiste(piste);
    }

    @PutMapping("/{id}")
    public Piste updatePiste(@PathVariable int id, @RequestBody Piste piste) {
        piste.setId(id);
        return pisteService.updatePiste(piste);
    }


    @GetMapping
    public List<Piste> findAll() {

        return pisteService.findAll();
    }

    @GetMapping("/{id}")
    public Piste findById(@PathVariable int id) {

        return pisteService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {

        pisteService.delete(id);
    }
}
