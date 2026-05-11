package net.ayoub.backend.repositories;

import net.ayoub.backend.entities.Paiment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaimentOperationRepository extends JpaRepository<Paiment,Long> {
}
