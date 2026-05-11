package net.ayoub.backend.dtos;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.ayoub.backend.entities.ContratAssurance;
import net.ayoub.backend.enums.TypeLogement;

@Data
public class ContratAssuranceHabitaDTO extends ContratAssurance {
    private String typeLogement;
    private String adresse;
    private double superficie;
}
