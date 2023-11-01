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
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE) //ignorer la creation du setter pour l'id
    long numAbon;
    Date datedebut;
    Date dateFin;
    Float PrixAbon;
    @Enumerated(EnumType.STRING)
    TypeAbonnement typeAbonnement;

}
