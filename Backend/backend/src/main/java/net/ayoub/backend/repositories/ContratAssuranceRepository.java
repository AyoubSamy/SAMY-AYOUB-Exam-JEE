package net.ayoub.backend.repositories;

import net.ayoub.backend.entities.ContratAssurance;
import org.hibernate.boot.models.JpaAnnotations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratAssuranceRepository extends JpaRepository<ContratAssurance,Long> {

}
