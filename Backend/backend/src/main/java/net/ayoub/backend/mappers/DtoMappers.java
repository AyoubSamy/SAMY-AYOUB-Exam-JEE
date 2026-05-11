package net.ayoub.backend.mappers;

import net.ayoub.backend.dtos.ClientDTO;
import net.ayoub.backend.dtos.ContratAssuranceAutoDTO;
import net.ayoub.backend.dtos.ContratAssuranceHabitaDTO;
import net.ayoub.backend.entities.Client;
import net.ayoub.backend.entities.ContratAssuranceAuto;
import net.ayoub.backend.entities.ContratAssuranceHabita;
import net.ayoub.backend.enums.StatutContrat;
import net.ayoub.backend.enums.TypeLogement;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class DtoMappers {

    public ClientDTO fromClient(Client client) {
        ClientDTO CientDto = new ClientDTO();
        BeanUtils.copyProperties(client, CientDto);
        return CientDto;
    }

    public Client toClient(ClientDTO ClientDto) {
        Client client = new Client();
        BeanUtils.copyProperties(ClientDto, client);
        return client;
    }

    public ContratAssuranceAutoDTO fromAssuranceAuto(ContratAssuranceAuto assuranceAuto) {
        ContratAssuranceAutoDTO dto = new ContratAssuranceAutoDTO();
        BeanUtils.copyProperties(assuranceAuto, dto);
        dto.setStatut(assuranceAuto.getStatut().name());
        return dto;
    }

    public ContratAssuranceAuto toAssuranceAuto(ContratAssuranceAutoDTO dto) {
        ContratAssuranceAuto entity = new ContratAssuranceAuto();
        BeanUtils.copyProperties(dto, entity);
        entity.setStatut(StatutContrat.valueOf(dto.getStatut()));
        return entity;
    }

    public ContratAssuranceHabitaDTO fromAssuranceHabitation(ContratAssuranceHabita habitation) {
        ContratAssuranceHabitaDTO dto = new ContratAssuranceHabitaDTO();
        BeanUtils.copyProperties(habitation, dto);
        dto.setTypeLogement(habitation.getTypeLogement().name());
        return dto;
    }

    public ContratAssuranceHabita toAssuranceHabitation(ContratAssuranceHabitaDTO dto) {
        ContratAssuranceHabita entity = new ContratAssuranceHabita();
        BeanUtils.copyProperties(dto, entity);
        entity.setTypeLogement(TypeLogement.valueOf(dto.getTypeLogement()));
        return entity;
    }




}
