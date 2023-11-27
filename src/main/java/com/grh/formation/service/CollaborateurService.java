package com.grh.formation.service;

import com.grh.formation.model.*;
import com.grh.formation.repo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.time.Year;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CollaborateurService {
    private final CollaborateurRepo collaborateurRepo;
    private final EtudeNatureRepo etudeNatureRepo;
    private final EtudeLevelRepo etudeLevelRepo;
    private final ContractTypeRepo contractTypeRepo;
    private final SalaryAdvantageRepo salaryAdvantageRepo;
    private final PosteRepo posteRepo;
    private final ResponsableRepo responsableRepo;




    public List<Collaborateur> getAllCollaborateurs() {
        return collaborateurRepo.findAll();
    }

    public Optional<Collaborateur> getCollaborateurById(Long id) {
        return collaborateurRepo.findById(id);
    }


    public Collaborateur saveCollaborateur(
            Collaborateur collaborateur,
            Long etudeNatureId,
            Long etudeLevelId,
            Long contractTypeId,
            Long salaryAdvantageId,
            Long posteId,
            Long responsableId
    ) {
        EtudeNature etudeNature = etudeNatureRepo.findById(etudeNatureId)
                .orElseThrow(() -> new EntityNotFoundException("EtudeNature not found with id: " + etudeNatureId));

        EtudeLevel etudeLevel = etudeLevelRepo.findById(etudeLevelId)
                .orElseThrow(() -> new EntityNotFoundException("EtudeLevel not found with id: " + etudeLevelId));

        ContractType contractType = contractTypeRepo.findById(contractTypeId)
                .orElseThrow(() -> new EntityNotFoundException("ContractType not found with id: " + contractTypeId));

        SalaryAdvantage salaryAdvantage = salaryAdvantageRepo.findById(salaryAdvantageId)
                .orElseThrow(() -> new EntityNotFoundException("SalaryAdvantage not found with id: " + salaryAdvantageId));

        Poste poste = posteRepo.findById(posteId)
                .orElseThrow(() -> new EntityNotFoundException("Poste not found with id: " + posteId));




        Responsable responsable = responsableRepo.findById(responsableId)
                .orElseThrow(() -> new EntityNotFoundException("Responsable not found with id: " + responsableId));

        if(collaborateurRepo.existsByCin(collaborateur.getCin())) throw new RuntimeException("CIN deja existe");
        if(collaborateurRepo.existsByEmail(collaborateur.getEmail())) throw  new RuntimeException("Email deja existe");
        if(collaborateurRepo.existsByNumCompte(collaborateur.getNumCompte())) throw  new RuntimeException("Num de compte deja existe");
        if(collaborateurRepo.existsByNumSecuriteSociale(collaborateur.getNumSecuriteSociale())) throw  new RuntimeException("Num securite sociale deja existe");


        collaborateur.setEtudeNature(etudeNature);
        collaborateur.setEtudeLevel(etudeLevel);
        collaborateur.setContractType(contractType);
        collaborateur.setSalaryAdvantage(salaryAdvantage);
        collaborateur.setPoste(poste);
        collaborateur.setResponsable(responsable);

        return collaborateurRepo.save(collaborateur);
    }


    public void deleteCollaborateur(Long id) {
        collaborateurRepo.deleteById(id);
    }

    public Collaborateur updateCollaborateur(
            Long etudeNatureId,
            Long etudeLevelId,
            Long contractTypeId,
            Long salaryAdvantageId,
            Long posteId,
            Long responsableId,
            boolean withDocument,
            Collaborateur updatedCollaborateur
    ) {
        if (collaborateurRepo.findById(updatedCollaborateur.getId()).isEmpty()) {
            throw new EntityNotFoundException("Collaborateur not found with id: " + updatedCollaborateur.getId());
        }

        EtudeNature etudeNature = etudeNatureRepo.findById(etudeNatureId)
                .orElseThrow(() -> new EntityNotFoundException("EtudeNature not found with id: " + etudeNatureId));

        EtudeLevel etudeLevel = etudeLevelRepo.findById(etudeLevelId)
                .orElseThrow(() -> new EntityNotFoundException("EtudeLevel not found with id: " + etudeLevelId));

        ContractType contractType = contractTypeRepo.findById(contractTypeId)
                .orElseThrow(() -> new EntityNotFoundException("ContractType not found with id: " + contractTypeId));

        SalaryAdvantage salaryAdvantage = salaryAdvantageRepo.findById(salaryAdvantageId)
                .orElseThrow(() -> new EntityNotFoundException("SalaryAdvantage not found with id: " + salaryAdvantageId));

        Poste poste = posteRepo.findById(posteId)
                .orElseThrow(() -> new EntityNotFoundException("Poste not found with id: " + posteId));



        Responsable responsable = responsableRepo.findById(responsableId)
                .orElseThrow(() -> new EntityNotFoundException("Responsable not found with id: " + responsableId));
        if(withDocument){
            updatedCollaborateur.setPiecesJointe(null);
            updatedCollaborateur.setId(updatedCollaborateur.getId());
            updatedCollaborateur.setEtudeNature(etudeNature);
            updatedCollaborateur.setEtudeLevel(etudeLevel);
            updatedCollaborateur.setContractType(contractType);
            updatedCollaborateur.setSalaryAdvantage(salaryAdvantage);
            updatedCollaborateur.setPoste(poste);
            updatedCollaborateur.setResponsable(responsable);
        }else{
            updatedCollaborateur.setId(updatedCollaborateur.getId());
            updatedCollaborateur.setEtudeNature(etudeNature);
            updatedCollaborateur.setEtudeLevel(etudeLevel);
            updatedCollaborateur.setContractType(contractType);
            updatedCollaborateur.setSalaryAdvantage(salaryAdvantage);
            updatedCollaborateur.setPoste(poste);
            updatedCollaborateur.setResponsable(responsable);
            updatedCollaborateur.setPiecesJointe(collaborateurRepo.findById(updatedCollaborateur.getId()).get().getPiecesJointe());
        }


        return collaborateurRepo.save(updatedCollaborateur);
    }

    public double calculateMassSalariale() {
        double massSalariale = 0.0;

        for (Collaborateur collaborateur : collaborateurRepo.findAll()) {
            double salary = collaborateur.getSalaireBrute();
            massSalariale += salary;
        }

        return massSalariale;
    }
    public Map<Integer, Long> calculateAgePyramid() {
        Map<Integer, Long> agePyramid = new HashMap<>();
        int currentYear = Year.now().getValue();

        for (Collaborateur collaborateur : collaborateurRepo.findAll()) {
            Date birthdate = collaborateur.getDateNaissance();

            if (birthdate != null) {
                int age = currentYear - birthdate.getYear();
                agePyramid.put(age, agePyramid.getOrDefault(age, 0L) + 1);
            }
        }

        return agePyramid;
    }



    public double calculateAverageSalary() {
        List<Double> allSalaries = this.getAllSalaries();

        if (allSalaries.isEmpty()) {
            return 0.0;
        }

        double totalSalary = 0.0;
        for (Double salary : allSalaries) {
            totalSalary += salary;
        }

        return totalSalary / allSalaries.size();
    }
    public List<Double> getAllSalaries() {
        return collaborateurRepo.findAll().stream()
                .map(Collaborateur::getSalaireBrute)
                .collect(Collectors.toList());
    }








}

