package tn.esprit.spring1.tpyasmine.Service;
import tn.esprit.spring1.tpyasmine.entities.Cours;

import java.util.List;

public interface ICoursService {
    Cours addCours(Cours cours);
    Cours updateCours(Cours cours);
    List<Cours> findAll();
    Cours findById (long numCours);
    void delete (long numCours);

}
