package com.grh.formation;

import com.grh.formation.model.*;
import com.grh.formation.repo.*;
import com.grh.formation.service.ContractTypeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;
import java.util.TimeZone;

@SpringBootApplication
public class FormationApplication {




	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		SpringApplication.run(FormationApplication.class, args);
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


