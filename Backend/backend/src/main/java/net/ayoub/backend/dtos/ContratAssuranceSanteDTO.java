package net.ayoub.backend.dtos;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.ayoub.backend.entities.ContratAssurance;
import net.ayoub.backend.enums.NiveauCouverture;


@Data
public class ContratAssuranceSanteDTO extends ContratAssurance {
    private String niveauCouverture;
    private int nbPersonnesCouvertes;
}
