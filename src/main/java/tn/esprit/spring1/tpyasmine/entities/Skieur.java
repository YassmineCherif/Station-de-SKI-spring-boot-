package tn.esprit.spring1.tpyasmine.entities;

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
    @Setter(AccessLevel.NONE)
    int id;
    String nomS;
    String prenomS;
    Date dateNaissance;
    String ville;


    @OneToMany(mappedBy = "skieur")
    Set<Inscription> inscription;

    @ManyToMany
    Set<Piste>pistes;

    @OneToOne(cascade=CascadeType.ALL)
    Abonnement abonnements;


    public void setId(int id) {
        this.id = id;
    }

}
