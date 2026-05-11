package net.ayoub.backend.dtos;

import lombok.Data;

import java.time.LocalDate;
@Data
public class ContratAssuranceAutoDTO extends ContratAssuranceDTO {

        private String numImmatriculation;
        private String marque;
        private String modele;
}
