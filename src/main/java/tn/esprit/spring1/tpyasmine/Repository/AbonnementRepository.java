package tn.esprit.spring1.tpyasmine.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.esprit.spring1.tpyasmine.entities.Abonnement;
import tn.esprit.spring1.tpyasmine.entities.Inscription;
import tn.esprit.spring1.tpyasmine.entities.enums.TypeAbonnement;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface AbonnementRepository extends CrudRepository<Abonnement, Long>{

    List<Abonnement> getSubscriptionsByStartDateBetween(LocalDate dd, LocalDate df);

    @Query("select a from Abonnement a where a.typeAbonnement = :typeAb order by a.datedebut")
    Set<Abonnement> findByTypeSubOrderByStartDateAsc(@Param("typeAb") TypeAbonnement typeAb);


    @Query("select distinct s from Abonnement s where s.dateFin <= CURRENT_TIME order by s.dateFin")
    List<Abonnement> findDistinctOrderByEndDateAsc();


    @Query("select (sum(s.PrixAbon))/(count(s)) from Abonnement s where s.typeAbonnement = ?1")
    Float recurringRevenueByTypeSubEquals(TypeAbonnement typeSub);


}
