package tn.esprit.spring1.tpyasmine.Service;

import tn.esprit.spring1.tpyasmine.entities.*;
import tn.esprit.spring1.tpyasmine.entities.enums.TypeAbonnement;

import java.util.List;

public interface ISkieurService {
    Skieur addSkieur(Skieur skieur);
    Skieur updateSkieur(Skieur skieur);
    List<Skieur> findAll();
    Skieur findById (long numSkieur);
    void delete (long numSkieur);
     Skieur assignSkierToPiste(Long numSkieur, Long numPiste);
    Skieur addSkierAndAssignToCourse(Skieur skieur, Long numCourse);

    List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement);

}
