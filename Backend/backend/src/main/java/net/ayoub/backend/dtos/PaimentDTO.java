package net.ayoub.backend.dtos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.ayoub.backend.entities.ContratAssurance;
import net.ayoub.backend.enums.TypePaiement;

import java.time.LocalDate;


@Data
public class PaimentDTO {

    private Long id;

    private LocalDate date;
    private double montant;


    private TypePaiement type;

}
