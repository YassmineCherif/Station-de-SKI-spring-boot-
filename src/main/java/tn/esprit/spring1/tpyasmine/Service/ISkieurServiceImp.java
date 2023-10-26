package tn.esprit.spring1.tpyasmine.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring1.tpyasmine.Repository.SkieurRepository;
import tn.esprit.spring1.tpyasmine.entities.Skieur;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ISkieurServiceImp implements ISkieurService{


    private final SkieurRepository skieurRepository;
    @Override

    public Skieur addSkieur(Skieur skieur) {

        return skieurRepository.save(skieur);
    }

        @Override
        public Skieur updateSkieur(Skieur skieur) {

        return skieurRepository.save(skieur);
        }



        @Override
        public  List<Skieur> findAll() {

        return (List<Skieur>) skieurRepository.findAll() ;
        }

        @Override
        public Skieur findById(int id) {

        return skieurRepository.findById(id).orElse(null);
        }




    @Override
    public void delete(int id) {
        skieurRepository.deleteById(id);

    }
}
