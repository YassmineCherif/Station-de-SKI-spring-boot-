package tn.esprit.spring1.tpyasmine.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.esprit.spring1.tpyasmine.entities.Cours;
import tn.esprit.spring1.tpyasmine.entities.Inscription;
import tn.esprit.spring1.tpyasmine.entities.enums.*;
import java.util.List;
import java.util.Set;

public interface InscriptionRepository extends CrudRepository<Inscription, Long>{


    long countByCoursAndNumSemaine(Cours cours, int numWeek);
    @Query("select ins.numSemaine " +
            "from Inscription ins " +
            "join Moniteur mo " +
            "on ins.cours member mo.cours " +
            "where mo.id = :idIns and ins.cours.support = :support")
    List<Integer> numWeeksCourseOfInstructorBySupport(@Param("idIns") Long numInstructor, @Param("support") Support support);

    @Query("select count(distinct ins) from Inscription ins " +
            "where ins.numSemaine = ?1 and ins.Skieur.id = ?2 and ins.cours.id = ?3")
    long countDistinctByNumWeekAndSkier_NumSkierAndCourse_NumCourse(int numSemaine, Long numSkier, Long numCourse);



}
