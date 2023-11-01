package tn.esprit.spring1.tpyasmine.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.spring1.tpyasmine.entities.enums.TypeCours;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) //les attribues vont etre privee
@Entity
public class Moniteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE) //ignorer la creation du setter pour l'id
    long numMoniteur ;
    String nomM;
    String prenomM;
    Date dateRecu;

    @Enumerated(EnumType.STRING)
    TypeCours typeCours;
    @OneToMany(cascade = CascadeType.ALL)
    Set <Cours> cours;



}
