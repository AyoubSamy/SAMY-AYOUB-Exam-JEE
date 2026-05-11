package net.ayoub.backend.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.ayoub.backend.enums.TypeLogement;

@Entity
@DiscriminatorValue("CH")
@Data @NoArgsConstructor @AllArgsConstructor
public class ContratAssuranceHabita extends ContratAssurance {
    private TypeLogement typeLogement;
    private String adresse;
    private double superficie;
}
