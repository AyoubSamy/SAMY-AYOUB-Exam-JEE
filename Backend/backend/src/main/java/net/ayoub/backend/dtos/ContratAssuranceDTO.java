package net.ayoub.backend.dtos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.ayoub.backend.entities.Client;
import net.ayoub.backend.entities.Paiment;
import net.ayoub.backend.enums.StatutContrat;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
public class ContratAssuranceDTO {
    private Long id;
    private LocalDate dateSouscription;
    private String statut;
    private LocalDate dateValidation;
    private double montantCotisation;
    private int duree;
    private double tauxCouverture;

}
