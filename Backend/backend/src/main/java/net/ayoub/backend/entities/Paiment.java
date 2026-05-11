package net.ayoub.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.ayoub.backend.enums.TypePaiement;

import java.util.Date;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Paiment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;
    private double montant;


    private TypePaiement type;

    @ManyToOne
    private ContratAssurance contrat;
}
