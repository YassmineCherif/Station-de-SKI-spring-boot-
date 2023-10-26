package tn.esprit.spring1.tpyasmine.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring1.tpyasmine.Repository.AbonnementRepository;
import tn.esprit.spring1.tpyasmine.entities.Abonnement;
import java.util.List;

@Service

public class IAbonnementServiceImp implements IAbonnementService{
    @Autowired//TO DO
    AbonnementRepository abonnementRepository;
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
    public Abonnement findById(int id) {
        return abonnementRepository.findById(id).orElse(null);
//        return pisteRepository.findById(id)
//                        .orElseThrow(() -> new IllegalArgumentException("no piste found with this id "));
    }

    @Override
    public void delete(int id) {
        abonnementRepository.deleteById(id);
    }
}
