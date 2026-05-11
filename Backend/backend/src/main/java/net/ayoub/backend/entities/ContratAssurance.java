package net.ayoub.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.ayoub.backend.enums.StatutContrat;

import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE" , length = 4)
@Data @AllArgsConstructor @NoArgsConstructor
public class ContratAssurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dateSouscription;


    private StatutContrat statut;

    private Date dateValidation;
    private double montantCotisation;
    private int duree;
    private double tauxCouverture;

    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "ContratAssurance",fetch = FetchType.EAGER)
    private List<Paiment> paiments;

}
