package tn.esprit.spring1.tpyasmine.Service;
import tn.esprit.spring1.tpyasmine.entities.Abonnement;
import tn.esprit.spring1.tpyasmine.entities.Inscription;
import tn.esprit.spring1.tpyasmine.entities.enums.TypeAbonnement;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface IAbonnementService {
    Abonnement addAbonnement(Abonnement abonnement);
    Abonnement updateAbonnement(Abonnement abonnement);
    List<Abonnement> findAll();
    Abonnement findById (long numAbonnement);
    void delete (long numAbonnement);

    Set<Abonnement> getSubscriptionByType(TypeAbonnement type);
    List<Abonnement> retrieveSubscriptionsByDates(LocalDate datedebut, LocalDate dateFin);

    void retrieveSubscriptions();
     void showMonthlyRecurringRevenue() ;

    }
