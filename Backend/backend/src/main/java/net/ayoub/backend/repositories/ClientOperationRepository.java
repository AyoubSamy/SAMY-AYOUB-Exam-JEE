package net.ayoub.backend.repositories;

import net.ayoub.backend.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientOperationRepository extends JpaRepository<Client,Long> {

}
