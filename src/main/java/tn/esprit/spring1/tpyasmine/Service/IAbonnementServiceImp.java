package tn.esprit.spring1.tpyasmine.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring1.tpyasmine.Repository.AbonnementRepository;
import tn.esprit.spring1.tpyasmine.Repository.SkieurRepository;
import tn.esprit.spring1.tpyasmine.entities.Abonnement;
import tn.esprit.spring1.tpyasmine.entities.Inscription;
import tn.esprit.spring1.tpyasmine.entities.Skieur;
import tn.esprit.spring1.tpyasmine.entities.enums.TypeAbonnement;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
@Slf4j


public class IAbonnementServiceImp implements IAbonnementService{
    @Autowired//TO DO
    AbonnementRepository abonnementRepository;
    @Autowired
    SkieurRepository skieurRepository;
    @Override
    public Abonnement addAbonnement(Abonnement abonnement) {

        return abonnementRepository.save(abonnement);
    }


    @Override
    public Abonnement updateAbonnement(Abonnement abonnement) {

        return abonnementRepository.save(abonnement);
    }

    @Override
    public List<Abonnement> findAll() {
        return (List<Abonnement>) abonnementRepository.findAll() ;
    }

    @Override
    public Abonnement findById(long numAbonnement) {

        return abonnementRepository.findById(numAbonnement).orElse(null);
    }

    @Override
    public void delete(long numAbonnement) {

        abonnementRepository.deleteById(numAbonnement);
    }

    @Override
    public List<Abonnement> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate) {
        return abonnementRepository.getSubscriptionsByDatedebutBetween(startDate, endDate);
    }


    @Override
    public Set<Abonnement> getSubscriptionByType(TypeAbonnement type) {
        return abonnementRepository.findByTypeSubOrderByDatedebutAsc(type);
    }



    public void retrieveSubscriptions() {
        for (Abonnement sub: abonnementRepository.findDistinctOrderByDateFinAsc()) {
            Skieur skieur = skieurRepository.findByAbonnement(sub);
            log.info(sub.getId() + " | "+ sub.getDateFin().toString()
                    + " | "+ skieur.getPrenomS() + " " + skieur.getNomS());
        }
    }


    public void showMonthlyRecurringRevenue() {
        Float revenue = abonnementRepository.recurringRevenueByTypeSubEquals(TypeAbonnement.Mensuel)
                + abonnementRepository.recurringRevenueByTypeSubEquals(TypeAbonnement.Semesteriel)/6
                + abonnementRepository.recurringRevenueByTypeSubEquals(TypeAbonnement.Annuel)/12;
        log.info("Monthly Revenue = " + revenue);
    }


}