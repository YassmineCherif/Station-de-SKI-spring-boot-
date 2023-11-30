package tn.esprit.spring1.tpyasmine.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.spring1.tpyasmine.entities.Cours;

import java.util.List;

public interface CoursRepository extends CrudRepository<Cours, Long>{
   @Query (value = " SELECT * \n " +
           "FROM cours C JOIN moniteur_cours_set mc ON c.num_cours=mn.moniteur_num_moniteur \n " +
           "JOIN moniteur m ON m.num_moniteur=mc.moniteur_num_moniteur \n " +
           "WHERE m.nomm=?1 AND m.prenomm=?2 ", nativeQuery = true)
   List<Cours>findByMoniteurNameSQL (String name , String prenom);


   @Query(value = "SELECT c FROM Cours c JOIN Moniteur m ON c member m.cours " +
           "WHERE m.nomM = :name AND m.prenomM = :prenom")
   List<Cours> findByMoniteurNameJPQL(String name, String prenom);




}
