package net.ayoub.backend.services;

import net.ayoub.backend.dtos.ClientDTO;
import net.ayoub.backend.dtos.ContratAssuranceAutoDTO;
import net.ayoub.backend.dtos.ContratAssuranceDTO;
import net.ayoub.backend.dtos.ContratAssuranceHabitaDTO;
import net.ayoub.backend.entities.*;
import net.ayoub.backend.enums.TypePaiement;
import net.ayoub.backend.mappers.DtoMappers;
import net.ayoub.backend.repositories.ClientOperationRepository;
import net.ayoub.backend.repositories.ContratAssuranceRepository;
import net.ayoub.backend.repositories.PaimentOperationRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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
        return clientRepository.findAll().stream()
                .map(mapper::fromClient)
                .collect(Collectors.toList());
    }

    @Override
    public ContratAssuranceAutoDTO saveContratAuto(ContratAssuranceAutoDTO dto, Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));

        ContratAssuranceAuto entity = mapper.toAssuranceAuto(dto);
        entity.setClient(client);
        entity.setDateSouscription(LocalDate.now());

        return mapper.fromAssuranceAuto(contratRepository.save(entity));
    }

    @Override
    public ContratAssuranceHabitaDTO saveContratHabitation(ContratAssuranceHabitaDTO dto, Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));

        ContratAssuranceHabita entity = mapper.toAssuranceHabitation(dto);
        entity.setClient(client);
        entity.setDateSouscription(LocalDate.now());

        return mapper.fromAssuranceHabitation(contratRepository.save(entity));
    }

    @Override
    public List<ContratAssuranceDTO> listAllContrats() {
        return contratRepository.findAll().stream()
                .map(c -> {
                    ContratAssuranceDTO dto = new ContratAssuranceDTO();
                    org.springframework.beans.BeanUtils.copyProperties(c, dto);
                    dto.setStatut(c.getStatut().name());
                    return dto;
                }).collect(Collectors.toList());
    }

    @Override
    public void payerContrat(Long contratId, double montant, String typePaiement) {
        ContratAssurance contrat = contratRepository.findById(contratId)
                .orElseThrow(() -> new RuntimeException("Contrat non trouvé"));

        Paiment paiement = new Paiment();
        paiement.setDate(LocalDate.now());
        paiement.setMontant(montant);
        paiement.setType(TypePaiement.valueOf(typePaiement));
        paiement.setContrat(contrat);

        paiementRepository.save(paiement);

    }
}
