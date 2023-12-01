package tn.esprit.spring1.tpyasmine.Service;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.spring1.tpyasmine.Repository.PisteRepository;
import tn.esprit.spring1.tpyasmine.Repository.SkieurRepository;
import tn.esprit.spring1.tpyasmine.Repository.AbonnementRepository;
import tn.esprit.spring1.tpyasmine.Repository.InscriptionRepository;
import tn.esprit.spring1.tpyasmine.entities.Inscription;
import tn.esprit.spring1.tpyasmine.entities.Abonnement;
import tn.esprit.spring1.tpyasmine.entities.Cours;
import tn.esprit.spring1.tpyasmine.entities.Piste;
import tn.esprit.spring1.tpyasmine.entities.Skieur;
import tn.esprit.spring1.tpyasmine.entities.enums.TypeAbonnement;


import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class ISkieurServiceImp implements ISkieurService{

    private SkieurRepository skieurRepository;
    private AbonnementRepository abonnementRepository;
    private InscriptionRepository inscriptionRepository;
    private ICoursService coursService;
    private final SkieurRepository skieurRepo;
    private final PisteRepository pisteRepository ;

    @Override
    public Skieur addSkieur(Skieur skieur) {

        return skieurRepo.save(skieur);
    }

    @Override
    public Skieur updateSkieur(Skieur skieur) {

        return skieurRepo.save(skieur);
    }

    @Override
    public List<Skieur> findAll() {

        return (List<Skieur>)skieurRepo.findAll();
    }

    @Override
    public Skieur findById(long numSkieur) {

        return skieurRepo.findById(numSkieur).orElse(null);
    }

    @Override
    public void delete(long numSkieur) {

        skieurRepo.deleteById(numSkieur);
    }

    @Override
    public Skieur assignSkierToPiste(Long numSkieur, Long numPiste){
        Skieur skieur = skieurRepository.findById(numSkieur).orElse(null);
        Piste piste = pisteRepository.findById(numPiste).orElse(null);
        skieur.getPisteSet().add(piste);
        return skieurRepository.save(skieur);

    }


    @Override
    public Skieur addSkierAndAssignToCourse(Skieur skieur, Long numCourse) {
        // Create and set Abonnement for the Skieur
        Abonnement abonnement = new Abonnement();
        // Set abonnement properties if needed
        skieur.setAbonnement(abonnement);

        // Create and set Inscription for the Skieur
        Inscription inscription = new Inscription();
        // Set inscription properties if needed
        inscription.setSkieur(skieur);

        // Get the Cours based on numCourse
        Cours cours = coursService.findById(numCourse);

        // Assign Inscription and Abonnement to the Cours
        inscription.setCours(cours);
     //   abonnement.setInscription(inscription);

        // Save the Skieur, which cascades to Abonnement, Inscription, and Cours
        return  skieurRepository.save(skieur);
    }

    @Override
    public List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement) {
        return skieurRepository.findByAbonnement_TypeAbonnement(typeAbonnement);
    }

    @Scheduled(fixedRate = 60000) // we must add @EnableScheduling f main
    public void testSchedule(){
          log.info(" test Schedule ");

    }

}
