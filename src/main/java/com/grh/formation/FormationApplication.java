package com.grh.formation;

import com.grh.formation.model.*;
import com.grh.formation.repo.*;
import com.grh.formation.service.CollaborateurService;
import com.grh.formation.service.PosteService;
import com.grh.formation.service.SalaryAdvantageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@SpringBootApplication
public class FormationApplication {




	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		SpringApplication.run(FormationApplication.class, args);
	}

	@Bean
	CommandLineRunner run(SalaryAdvantageService salaryAdvantageService,EtudeLevelRepo etudeLevelRepo,
						  ContractTypeRepo contractTypeRepo,
						  DepartementRepo departementRepo,
						  EtudeNatureRepo etudeNatureRepo,
						  ResponsableRepo responsableRepo,
						  SalaryAdvantageRepo salaryAdvantageRepo, PiecesJointesRepo piecesJointesRepo, PosteService posteService, CollaborateurService collaborateurService) {


		return args -> {
			ContractType civp = contractTypeRepo.save(new ContractType("CIVP",1000));
			ContractType cdi = contractTypeRepo.save(new ContractType("CDI",1200));
			ContractType cdd = contractTypeRepo.save(new ContractType("CDD",1500));

			PiecesJointes cin = piecesJointesRepo.save(new PiecesJointes("cin"));
			PiecesJointes passport = piecesJointesRepo.save(new PiecesJointes("Passport"));
			PiecesJointes resume = piecesJointesRepo.save(new PiecesJointes("Resume"));
			PiecesJointes diplome = piecesJointesRepo.save(new PiecesJointes("Diplome"));

			contractTypeRepo.saveAll(List.of(cdi, civp, cdd));

			// Salary Advantages

			salaryAdvantageService.addSalaryAdvantage(new SalaryAdvantage("Bonus CIVP",10),1);
			salaryAdvantageService.addSalaryAdvantage(new SalaryAdvantage("Bonus CDI",20),2);
			salaryAdvantageService.addSalaryAdvantage(new SalaryAdvantage("Bonus CDD",30),3);






			// Etude Levels
			etudeLevelRepo.save(new EtudeLevel("BAC"));
			etudeLevelRepo.save(new EtudeLevel("License"));
			etudeLevelRepo.save(new EtudeLevel("Ingénieur"));
			etudeLevelRepo.save(new EtudeLevel("Master"));

			// Departements
			departementRepo.save(new Departement("IT"));
			departementRepo.save(new Departement("Finance"));
			departementRepo.save(new Departement("HR"));

			// Etude Nature
			etudeNatureRepo.save(new EtudeNature("Informatique"));
			etudeNatureRepo.save(new EtudeNature("Finance"));
			etudeNatureRepo.save(new EtudeNature("Ressources Humaines"));

			// Postes

			posteService.addPoste(new Poste("Développeur"),1);
			posteService.addPoste(new Poste("Analyste Financier"),2);
			posteService.addPoste(new Poste("RH"),3);
			posteService.addPoste(new Poste("Responsable"),1);
			posteService.addPoste(new Poste("Responsable"),2);
			posteService.addPoste(new Poste("Responsable"),3);


			// Responsables
			responsableRepo.save(new Responsable("John Doe"));
			responsableRepo.save(new Responsable("Jane Smith"));



			//add collabs
			collaborateurService.saveCollaborateur(new Collaborateur(
					12345678,
					"John Doe",
					987654321,
					1234567890123L,
					123456789,
					new Date(2010-1900,5,10),
					"123 Main St",
					"john.doe@example.com",
					"Java Certification",
					5,
					new Date(),
					3000,
					true,
					"Recommender",
					"Great employee"
			),1L,1L,1L,1L,1L,1L);
			// Add more instances of Collaborateur with different data and related entity IDs
			collaborateurService.saveCollaborateur(new Collaborateur(
					87654321,
					"Jane Doe",
					123456789,
					9876543210123L,
					987654321,
					new Date(1990-1900,5,5),
					"456 Oak St",
					"jane.doe@example.com",
					"Python Certification",
					3,
					new Date(),
					1500,
					false,
					null,
					"Good employee"
			), 1L, 1L, 1L, 1L, 1L, 1L);

			collaborateurService.saveCollaborateur(new Collaborateur(
					55555555,
					"Alice Wonderland",
					917154321,
					9855543210123L,
					123456789,
					new Date(2001-1900,12,20),
					"789 Wonderland Ave",
					"alice@example.com",
					"React Certification",
					2,
					new Date(),
					2000,
					true,
					"John Doe",
					"Exceptional employee"
			), 2L, 2L, 2L, 1L, 2L, 1L);

			collaborateurService.saveCollaborateur(new Collaborateur(
					99999999,
					"Bob Builder",
					548756512,
					1231267890123L,
					555555555,
					new Date(1950-1900,12,20),
					"456 Construction St",
					"bob@example.com",
					"Architecture Certification",
					8,
					new Date(),
					1500,
					false,
					null,
					"Skilled builder"
			), 3L, 3L, 3L, 1L, 3L, 1L);


		};

	}

}


