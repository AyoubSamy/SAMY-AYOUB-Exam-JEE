package net.ayoub.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.ayoub.backend.enums.StatutContrat;

import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class ContratAssurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dateSouscription;


    private StatutContrat statut;

    private LocalDate dateValidation;
    private double montantCotisation;
    private int duree;
    private double tauxCouverture;

    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "contrat", cascade = CascadeType.ALL)
    private List<Paiement> paiements;

}
