package tn.esprit.spring1.tpyasmine.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) //les attribues vont etre privee
@Entity
public class Skieur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE) //ignorer la creation du setter pour l'id
    long numSkieur;
    String nomS;
    String prenomS;
    Date dateNaissance;
    String Ville;
    @ManyToMany(cascade = CascadeType.ALL)
    Set<Piste> pisteSet;
    @JsonIgnore
    @OneToMany(mappedBy="Skieur")//la meme mot que dans la classe inscription
    Set <Inscription> inscriptionSet;
    @OneToOne(cascade = CascadeType.ALL)
    Abonnement abonnement ;


}
