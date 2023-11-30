package tn.esprit.spring1.tpyasmine.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.esprit.spring1.tpyasmine.entities.Abonnement;
import tn.esprit.spring1.tpyasmine.entities.Skieur;
import tn.esprit.spring1.tpyasmine.entities.enums.Couleur;
import tn.esprit.spring1.tpyasmine.entities.enums.TypeAbonnement;

import java.util.List;

public interface SkieurRepository extends CrudRepository<Skieur, Long> {
    Skieur findBySubscription(Abonnement abonnement);
    List<Skieur> findBySubscription_TypeSub(TypeAbonnement typeSubscription);


    List<Skieur> findByNomSAndAbonnement_TypeAbonnementAndPisteSetCouleur(String nomS, TypeAbonnement abonnement_typeAbonnement, Couleur pisteSet_couleur);

    @Query("SELECT s FROM Skieur s ORDER BY SIZE(s.pisteSet)")
    List<Skieur> getSkieurOrderByPistenumber();


}
