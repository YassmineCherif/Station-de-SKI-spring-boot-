package tn.esprit.spring1.tpyasmine.Service;
import tn.esprit.spring1.tpyasmine.entities.Piste;

import java.util.List;

public interface IPisteService {
    Piste addPiste(Piste piste);
    Piste updatePiste(Piste piste);
    List<Piste> findAll();
    Piste findById (long numPiste);
    void delete (long numPiste);
}
