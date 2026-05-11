package net.ayoub.backend.services;

import net.ayoub.backend.dtos.ClientDTO;
import net.ayoub.backend.dtos.ContratAssuranceAutoDTO;
import net.ayoub.backend.dtos.ContratAssuranceDTO;
import net.ayoub.backend.dtos.ContratAssuranceHabitaDTO;

import java.util.List;

public interface AssuranceService {
    ClientDTO saveClient(ClientDTO clientDTO);
    List<ClientDTO> listClients();


    ContratAssuranceAutoDTO saveContratAuto(ContratAssuranceAutoDTO dto, Long clientId);
    ContratAssuranceHabitaDTO saveContratHabitation(ContratAssuranceHabitaDTO dto, Long clientId);
    List<ContratAssuranceDTO> listAllContrats();


    void payerContrat(Long contratId, double montant, String typePaiement);
}
