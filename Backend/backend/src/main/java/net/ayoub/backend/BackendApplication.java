package net.ayoub.backend;

import net.ayoub.backend.entities.*;
import net.ayoub.backend.enums.NiveauCouverture;
import net.ayoub.backend.enums.StatutContrat;
import net.ayoub.backend.enums.TypeLogement;
import net.ayoub.backend.enums.TypePaiement;
import net.ayoub.backend.repositories.ClientOperationRepository;
import net.ayoub.backend.repositories.ContratAssuranceRepository;
import net.ayoub.backend.repositories.PaimentOperationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ClientOperationRepository clientRepository,
							ContratAssuranceRepository contratRepository,
							PaimentOperationRepository paiementRepository) {
		return args -> {

			Client c1 = new Client(null, "Samy Ayoub", "samy@example.com", null);
			clientRepository.save(c1);

			ContratAssuranceAuto auto = new ContratAssuranceAuto();
			auto.setClient(c1);
			auto.setDateSouscription(LocalDate.now());
			auto.setStatut(StatutContrat.VALIDE);
			auto.setMontantCotisation(1200.50);
			auto.setNumImmatriculation("1234-A-6");
			auto.setMarque("Audi");
			auto.setModele("A3");
			contratRepository.save(auto);

			// 3. Création d'un contrat Santé
			ContratAssuranceSante sante = new ContratAssuranceSante();
			sante.setClient(c1);
			sante.setDateSouscription(LocalDate.now());
			sante.setStatut(StatutContrat.EN_COURS);
			sante.setNiveauCouverture(NiveauCouverture.PREMIUM);
			sante.setNbPersonnesCouvertes(3);
			contratRepository.save(sante);

			// 4. Ajout d'un paiement pour le contrat auto
			Paiment p1 = new Paiment(null, LocalDate.now(), 150.0, TypePaiement.MENSUALITE, auto);
			paiementRepository.save(p1);

			System.out.println("Données de test insérées avec succès !");
		};
	}
}
