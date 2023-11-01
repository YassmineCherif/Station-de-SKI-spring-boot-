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

    @PutMapping
    public Piste updatePiste(@RequestBody Piste piste) {
        return pisteService.updatePiste(piste);
    }


    @GetMapping
    public List<Piste> findAll() {

        return pisteService.findAll();
    }

    @GetMapping("/{numPiste}")
    public Piste FindById(@PathVariable long numPiste){

        return pisteService. findById(numPiste);
    }


    @DeleteMapping("/{numPiste}")
    public void delete(@RequestBody long  numPiste)    {

        pisteService.delete(numPiste);
    }

}
