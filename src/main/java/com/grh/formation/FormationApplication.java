package com.grh.formation;

import com.grh.formation.model.*;
import com.grh.formation.repo.*;
import com.grh.formation.service.ContractTypeService;
import com.grh.formation.service.PosteService;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.yaml.snakeyaml.events.Event;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FormationApplication {




	public static void main(String[] args) {
		SpringApplication.run(FormationApplication.class, args);
	}

	/*@Bean
	CommandLineRunner run(EtudeLevelRepo etudeLevelRepo,
						  ContractTypeRepo contractTypeRepo,
						  DepartementRepo departementRepo,
						  EtudeNatureRepo etudeNatureRepo,
						  PosteRepo posteRepo,
						  ResponsableRepo responsableRepo,
						  SalaryAdvantageRepo salaryAdvantageRepo, PiecesJointesRepo piecesJointesRepo, PosteService posteService) {


		return args -> {
			ContractType cdi = contractTypeRepo.save(new ContractType("CDI",1200));
			ContractType civp = contractTypeRepo.save(new ContractType("CIVP",1000));
			ContractType cdd = contractTypeRepo.save(new ContractType("CDD",1500));

			// Save pieces jointes
			PiecesJointes cin = piecesJointesRepo.save(new PiecesJointes("cin"));
			PiecesJointes passport = piecesJointesRepo.save(new PiecesJointes("Passport"));
			PiecesJointes resume = piecesJointesRepo.save(new PiecesJointes("Resume"));
			PiecesJointes diplome = piecesJointesRepo.save(new PiecesJointes("Diplome"));






			contractTypeRepo.saveAll(List.of(cdi, civp, cdd));

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
			posteService.addPoste(new Poste("Responsable RH"),3);


			// Responsables
			responsableRepo.save(new Responsable("John Doe"));
			responsableRepo.save(new Responsable("Jane Smith"));

			// Salary Advantages
			salaryAdvantageRepo.save(new SalaryAdvantage("Bonus"));
			salaryAdvantageRepo.save(new SalaryAdvantage("Health Insurance"));
		};

	}*/

}


