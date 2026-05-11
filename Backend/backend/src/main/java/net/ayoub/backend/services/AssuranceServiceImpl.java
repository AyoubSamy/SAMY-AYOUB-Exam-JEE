package net.ayoub.backend.services;

import net.ayoub.backend.dtos.ClientDTO;
import net.ayoub.backend.dtos.ContratAssuranceAutoDTO;
import net.ayoub.backend.dtos.ContratAssuranceDTO;
import net.ayoub.backend.dtos.ContratAssuranceHabitaDTO;
import net.ayoub.backend.entities.Client;
import net.ayoub.backend.mappers.DtoMappers;
import net.ayoub.backend.repositories.ClientOperationRepository;
import net.ayoub.backend.repositories.ContratAssuranceRepository;
import net.ayoub.backend.repositories.PaimentOperationRepository;

import java.util.List;

public class AssuranceServiceImpl implements AssuranceService{

    private ClientOperationRepository clientRepository;
    private ContratAssuranceRepository contratRepository; // Repository de la classe mère
    private PaimentOperationRepository paiementRepository;
    private DtoMappers mapper;
    @Override
    public ClientDTO saveClient(ClientDTO clientDTO) {
        Client client = mapper.toClient(clientDTO);
        return mapper.fromClient(clientRepository.save(client));
    }

    @Override
    public List<ClientDTO> listClients() {

    }

    @Override
    public ContratAssuranceAutoDTO saveContratAuto(ContratAssuranceAutoDTO dto, Long clientId) {
        return null;
    }

    @Override
    public ContratAssuranceHabitaDTO saveContratHabitation(ContratAssuranceHabitaDTO dto, Long clientId) {
        return null;
    }

    @Override
    public List<ContratAssuranceDTO> listAllContrats() {
        return List.of();
    }

    @Override
    public void payerContrat(Long contratId, double montant, String typePaiement) {

    }
}
