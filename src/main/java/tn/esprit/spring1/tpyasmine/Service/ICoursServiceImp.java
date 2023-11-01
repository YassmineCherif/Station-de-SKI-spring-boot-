package tn.esprit.spring1.tpyasmine.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring1.tpyasmine.Repository.CoursRepository;
import tn.esprit.spring1.tpyasmine.entities.Cours;
import java.util.List;

@Service

public class ICoursServiceImp implements ICoursService{
    @Autowired//TO DO
    CoursRepository coursRepository;
    @Override
    public Cours addCours(Cours cours) {

        return coursRepository.save(cours);
    }


    @Override
    public Cours updateCours(Cours cours) {
        return coursRepository.save(cours);
    }

    @Override
    public List<Cours> findAll() {
        return (List<Cours>) coursRepository.findAll() ;
    }

    @Override
    public Cours findById(long numCours) {

        return coursRepository.findById(numCours).orElse(null);
    }

    @Override
    public void delete(long numCours) {
        coursRepository.deleteById(numCours);
    }

}
