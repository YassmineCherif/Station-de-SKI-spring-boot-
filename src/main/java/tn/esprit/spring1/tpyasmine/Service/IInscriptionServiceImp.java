package tn.esprit.spring1.tpyasmine.Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tn.esprit.spring1.tpyasmine.Repository.*;
import tn.esprit.spring1.tpyasmine.entities.*;
import tn.esprit.spring1.tpyasmine.entities.enums.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDate;
import java.time.Period;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class IInscriptionServiceImp implements IInscriptionService{
    @Autowired//TO DO
    InscriptionRepository inscriptionRepository;
    @Autowired
    SkieurRepository skieurRepository;
    @Autowired
     CoursRepository coursRepository;
    @Autowired
    MoniteurRepository moniteurRepository;


    @Override
    public Inscription addInscription(Inscription inscription) {

        return inscriptionRepository.save(inscription);
    }


    @Override
    public Inscription updateInscription(Inscription inscription) {
        return inscriptionRepository.save(inscription);
    }

    @Override
    public List<Inscription> findAll() {
        return (List<Inscription>) inscriptionRepository.findAll() ;
    }

    @Override
    public Inscription findById(long numInscription) {
        return inscriptionRepository.findById(numInscription).orElse(null);
    }

    @Override
    public void delete(long numInscription) {
        inscriptionRepository.deleteById(numInscription);
    }


    @Override
    public Inscription addRegistrationAndAssignToSkier(Inscription inscription, long numSkieur) {
        Skieur skieur=skieurRepository.findById(numSkieur).orElse(null);
        inscription.setSkieur(skieur);
        return inscriptionRepository.save(inscription);
    }


    @Override
    public Inscription assignRegistrationToCourse(Long numInscription, Long numCours){
        Inscription inscription = inscriptionRepository.findById(numInscription).orElse(null);
        Cours cours = coursRepository.findById(numCours).orElse(null);

        // Assign the Inscription to the Cours
        inscription.setCours(cours);
        return inscriptionRepository.save(inscription);

    }

    @Override
    public Inscription addRegistrationAndAssignToSkierAndCourse(Inscription inscription, Long numSkieur, Long numCours) {

        Skieur skieur = skieurRepository.findById(numSkieur).orElse(null);
        Cours cours = coursRepository.findById(numCours).orElse(null);

        Assert.notNull(skieur,"No Skieur found with this id : "+numSkieur);
        Assert.notNull(cours,"No Skieur found with this id : "+numSkieur);


        if(inscriptionRepository.countDistinctByNumWeekAndSkier_NumSkierAndCourse_NumCourse(inscription.getNumSemaine(), skieur.getId(), cours.getId()) >=1){
            log.info("Deja inscrit dans le cours du semaine :" + inscription.getNumSemaine());
            return null;
        }

        int ageSkieur = Period.between(skieur.getDateNaissance(), LocalDate.now()).getYears();
        log.info("Age " + ageSkieur);

        switch (cours.getTypeCours()) {
            case Particulier:
                log.info("Ajouter sans tests");
                return assignRegistration(inscription, skieur, cours);

            case Collectif_enfant:
                if (ageSkieur < 16) {
                    if (inscriptionRepository.countByCoursAndNumSemaine(cours, inscription.getNumSemaine()) < 6) {

                        log.info("Cours ajouté avec succes !");
                        return assignRegistration(inscription, skieur, cours);
                    } else {
                        log.info("cours saturées !");
                        return null;
                    }
                }
                else{
                    log.info("votre age nest pas compatible avec ce cours !");
                }
                break;

            default:
                if (ageSkieur >= 16) {
                    if (inscriptionRepository.countByCoursAndNumSemaine(cours, inscription.getNumSemaine()) < 6) {
                        log.info("Cours ajouté avec succes ");
                        return assignRegistration(inscription, skieur, cours);
                    } else {
                        log.info("cours saturées !");
                        return null;
                    }
                }
                log.info("votre age nest pas compatible avec ce cours ! ");
        }
        return inscription;

    }


    private Inscription assignRegistration (Inscription inscription, Skieur skieur, Cours cours){
        inscription.setSkieur(skieur);
        inscription.setCours(cours);
        return inscriptionRepository.save(inscription);
    }



    @Override
    public List<Integer> numWeeksCourseOfInstructorBySupport(Long numInstructor, Support support) {

        Map<Cours, List<Integer>> map = moniteurRepository.findById(numInstructor)
                .orElseThrow(() -> new IllegalArgumentException("No Instructor Found with this id " + numInstructor))
                .getCours().stream()
                .filter(course -> course.getSupport().equals(support))
                .map(Cours::getInsecriptionSet)
                .flatMap(Collection::stream)
                // .map(Registration::getNumWeek)
                .collect(Collectors.groupingBy(
                        Inscription::getCours,
                        Collectors.mapping(Inscription::getNumSemaine, Collectors.toList())
                ));

        return inscriptionRepository.numWeeksCourseOfInstructorBySupport(numInstructor, support);
    }



}
