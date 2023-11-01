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
    public Abonnement findById(long numAbonnement) {

        return abonnementRepository.findById(numAbonnement).orElse(null);
    }

    @Override
    public void delete(long numAbonnement) {

        abonnementRepository.deleteById(numAbonnement);
    }
}