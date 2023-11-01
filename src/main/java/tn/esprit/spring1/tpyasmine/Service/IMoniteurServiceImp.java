package tn.esprit.spring1.tpyasmine.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring1.tpyasmine.Repository.MoniteurRepository;
import tn.esprit.spring1.tpyasmine.Repository.CoursRepository;
import tn.esprit.spring1.tpyasmine.entities.Cours;
import tn.esprit.spring1.tpyasmine.entities.Moniteur;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

@Service

public class IMoniteurServiceImp implements IMoniteurService{
    @Autowired//TO DO
    MoniteurRepository moniteurRepository;
    CoursRepository coursRepository;
    @Override
    public Moniteur addMoniteur(Moniteur moniteur) {

        return moniteurRepository.save(moniteur);
    }


    @Override
    public Moniteur updateMoniteur(Moniteur moniteur) {
        return moniteurRepository.save(moniteur);
    }

    @Override
    public List<Moniteur> findAll() {
        return (List<Moniteur>) moniteurRepository.findAll() ;
    }

    @Override
    public Moniteur findById(long numMoniteur) {

        return moniteurRepository.findById(numMoniteur).orElse(null);
    }


    @Override
    public void delete(long numMoniteur) {
        moniteurRepository.deleteById(numMoniteur);
    }

    @Override
    public Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, long numCours) {
        Cours cours= coursRepository.findById(numCours).orElse(null);
        Set<Cours> coursSet=new HashSet<>();
        coursSet.add(cours);
        moniteur.setCours(coursSet);
        return moniteurRepository.save(moniteur);


    }


}
