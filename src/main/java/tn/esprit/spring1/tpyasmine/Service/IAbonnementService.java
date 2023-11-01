package tn.esprit.spring1.tpyasmine.Service;
import tn.esprit.spring1.tpyasmine.entities.Abonnement;

import java.util.List;

public interface IAbonnementService {
    Abonnement addAbonnement(Abonnement abonnement);
    Abonnement updateAbonnement(Abonnement abonnement);
    List<Abonnement> findAll();
    Abonnement findById (long numAbonnement);
    void delete (long numAbonnement);

}
