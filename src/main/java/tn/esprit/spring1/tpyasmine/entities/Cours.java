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
    @Setter(AccessLevel.NONE)
    int id;

    Long numCours;
    int niveau;
    float prix;
    int creneau;
    @Enumerated(EnumType.STRING)
    TypeCours typeCours;

    @Enumerated(EnumType.STRING)
    Support support;

    @OneToMany(mappedBy = "cours")
    Set<Inscription> inscription;

    @ManyToOne
    Moniteur moniteur;

    public void setId(int id) {
        this.id = id;
    }


}
