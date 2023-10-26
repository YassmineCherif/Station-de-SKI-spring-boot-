package tn.esprit.spring1.tpyasmine.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.spring1.tpyasmine.entities.enums.TypeAbonnement;

import java.util.Date;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) //les attribues vont etre privee
@Entity
public class Abonnement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    int id;
    Long numAbon;
    Date dateDebut;
    Date dateFin;
    Float prixAbon;
    TypeAbonnement typeAbonnement;

    @OneToOne
    Skieur skieur;

    public void setId(int id) {
        this.id = id;
    }

}
