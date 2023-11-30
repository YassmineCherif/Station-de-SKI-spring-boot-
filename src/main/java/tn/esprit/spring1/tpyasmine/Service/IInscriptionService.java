package tn.esprit.spring1.tpyasmine.Service;
import tn.esprit.spring1.tpyasmine.entities.*;
import tn.esprit.spring1.tpyasmine.entities.enums.*;

import java.util.List;
import java.util.Set;

public interface IInscriptionService {
    Inscription addInscription(Inscription inscription);
    Inscription updateInscription(Inscription inscription);
    List<Inscription> findAll();
    Inscription findById(long numInscription);
    void delete (long numInscription);
    Inscription addRegistrationAndAssignToSkier(Inscription inscription, long numSkieur);

    Inscription assignRegistrationToCourse(Long numInscription, Long numCours);

    Inscription addRegistrationAndAssignToSkierAndCourse(Inscription inscription, Long numSkieur, Long numCours);

    List<Integer> numWeeksCourseOfInstructorBySupport(Long numInstructor, Support support);

}
