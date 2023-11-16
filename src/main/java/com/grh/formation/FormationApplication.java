package com.grh.formation;

import com.grh.formation.model.*;
import com.grh.formation.repo.*;
import com.grh.formation.service.ContractTypeService;
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
	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		var corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList( "http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Jwt-Token", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Jwt-Token", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials", "Filename"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter();
	}
	@Bean
	CommandLineRunner run(EtudeLevelRepo etudeLevelRepo,
	ContractTypeRepo contractTypeRepo,
	DepartementRepo departementRepo,
	EtudeNatureRepo etudeNatureRepo,
	PosteRepo posteRepo,
	ResponsableRepo responsableRepo,
	SalaryAdvantageRepo salaryAdvantageRepo, PiecesJointesRepo piecesJointesRepo,ContractTypeService contractTypeService) {


		return args -> {
			ContractType cdi = contractTypeRepo.save(new ContractType("CDI"));
			ContractType civp = contractTypeRepo.save(new ContractType("CIVP"));
			ContractType cdd = contractTypeRepo.save(new ContractType("CDD"));

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
			posteRepo.save(new Poste("Développeur"));
			posteRepo.save(new Poste("Analyste Financier"));
			posteRepo.save(new Poste("Responsable RH"));

			// Responsables
			responsableRepo.save(new Responsable("John Doe"));
			responsableRepo.save(new Responsable("Jane Smith"));

			// Salary Advantages
			salaryAdvantageRepo.save(new SalaryAdvantage("Bonus"));
			salaryAdvantageRepo.save(new SalaryAdvantage("Health Insurance"));
		};

	}

}


