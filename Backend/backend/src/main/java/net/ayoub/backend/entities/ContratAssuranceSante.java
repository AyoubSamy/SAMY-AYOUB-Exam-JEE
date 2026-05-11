package net.ayoub.backend.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.ayoub.backend.enums.NiveauCouverture;
@Entity
@DiscriminatorValue("CS")
@Data @NoArgsConstructor  @AllArgsConstructor
public class ContratAssuranceSante extends ContratAssurance{
    private NiveauCouverture niveauCouverture;
    private int nbPersonnesCouvertes;
}
