package tn.esprit.spring1.tpyasmine.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring1.tpyasmine.Repository.InscriptionRepository;
import tn.esprit.spring1.tpyasmine.Repository.SkieurRepository;
import tn.esprit.spring1.tpyasmine.Repository.CoursRepository;
import tn.esprit.spring1.tpyasmine.entities.Cours;
import tn.esprit.spring1.tpyasmine.entities.Inscription;
import tn.esprit.spring1.tpyasmine.entities.Skieur;

import java.util.List;

@Service

public class IInscriptionServiceImp implements IInscriptionService{
    @Autowired//TO DO
    InscriptionRepository inscriptionRepository;
    @Autowired
    SkieurRepository skieurRepository;
    @Autowired
     CoursRepository coursRepository;
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

}
