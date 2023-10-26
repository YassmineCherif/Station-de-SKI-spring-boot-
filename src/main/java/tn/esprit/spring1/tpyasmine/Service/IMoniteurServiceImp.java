package tn.esprit.spring1.tpyasmine.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring1.tpyasmine.Repository.MoniteurRepository;
import tn.esprit.spring1.tpyasmine.entities.Moniteur;
import java.util.List;

@Service

public class IMoniteurServiceImp implements IMoniteurService{
    @Autowired//TO DO
    MoniteurRepository moniteurRepository;
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
    public Moniteur findById(int id) {
        return moniteurRepository.findById(id).orElse(null);
//        return pisteRepository.findById(id)
//                        .orElseThrow(() -> new IllegalArgumentException("no piste found with this id "));
    }

    @Override
    public void delete(int id) {
        moniteurRepository.deleteById(id);
    }
}
