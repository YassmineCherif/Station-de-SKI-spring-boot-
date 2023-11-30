package tn.esprit.spring1.tpyasmine.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.spring1.tpyasmine.entities.enums.Support;
import tn.esprit.spring1.tpyasmine.entities.enums.TypeCours;


import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) //les attribues vont etre privee
@Entity
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE) //ignorer la creation du setter pour l'id
    long id;
    long numCours;
    int niveau;
    float Prix;
    int creneau;

    @Enumerated(EnumType.STRING)
    Support support;

    @Enumerated(EnumType.STRING)
    TypeCours typeCours;

    @OneToMany(mappedBy="cours")//la meme mot que dans la classe inscription
    Set <Inscription> insecriptionSet;


}
