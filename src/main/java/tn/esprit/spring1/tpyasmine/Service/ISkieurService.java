package tn.esprit.spring1.tpyasmine.Service;

import tn.esprit.spring1.tpyasmine.entities.Skieur;

import java.util.List;

public interface ISkieurService {
    Skieur addSkieur(Skieur skieur);
    Skieur updateSkieur(Skieur skieur);
    List<Skieur> findAll();
    Skieur findById(int id);

    void delete (int id);

}
