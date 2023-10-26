package tn.esprit.spring1.tpyasmine.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring1.tpyasmine.Repository.SkieurRepository;
import tn.esprit.spring1.tpyasmine.Repository.InscriptionRepository;
import tn.esprit.spring1.tpyasmine.entities.Skieur;
import tn.esprit.spring1.tpyasmine.entities.Inscription;
import java.util.List;

@Service

public class IInscriptionServiceImp implements IInscriptionService{
    @Autowired//TO DO
    InscriptionRepository inscriptionRepository;
    @Autowired
    SkieurRepository skieurRepository;
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
    public Inscription findById(int id) {
        return inscriptionRepository.findById(id).orElse(null);
//        return pisteRepository.findById(id)
//                        .orElseThrow(() -> new IllegalArgumentException("no piste found with this id "));
    }

    @Override
    public void delete(int id) {
        inscriptionRepository.deleteById(id);
    }


    @Override
    public Inscription addInscriptionAndAssignToSkier(Inscription inscription, int id) {
        Skieur skieur = skieurRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Skier not found"));
        inscription.setSkieur(skieur);
        return inscriptionRepository.save(inscription);
    }

}
