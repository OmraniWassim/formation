package com.grh.formation.serviceImpl;

import com.grh.formation.Service.ResponsableService;
import com.grh.formation.model.*;
import com.grh.formation.repo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.Year;
import java.util.*;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class CollaborateurServiceImpl implements com.grh.formation.Service.CollaborateurService {
    private final CollaborateurRepo collaborateurRepo;
    private final EtudeNatureRepo etudeNatureRepo;
    private final EtudeLevelRepo etudeLevelRepo;
    private final ContractTypeRepo contractTypeRepo;
    private final SalaryAdvantageRepo salaryAdvantageRepo;
    private final PosteRepo posteRepo;
    private final ResponsableRepo responsableRepo;
    private final ResponsableService responsableServiceImpl;




    @Override
    public List<Collaborateur> getAllCollaborateurs() {
        return collaborateurRepo.findAll();
    }

    @Override
    public Optional<Collaborateur> getCollaborateurById(Long id) {
        return collaborateurRepo.findById(id);
    }


    @Override
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



        if(responsableId!=0) {
            Responsable responsable = responsableRepo.findById(responsableId)
                    .orElseThrow(() -> new EntityNotFoundException("Responsable not found with id: " + responsableId));
            collaborateur.setResponsable(responsable);
        }
        if(collaborateurRepo.existsByCin(collaborateur.getCin())) throw new RuntimeException("CIN deja existe");
        if(collaborateurRepo.existsByEmail(collaborateur.getEmail())) throw  new RuntimeException("Email deja existe");
        if(collaborateurRepo.existsByNumCompte(collaborateur.getNumCompte())) throw  new RuntimeException("Num de compte deja existe");
        if(collaborateur.getNumSecuriteSociale()!=0 && collaborateurRepo.existsByNumSecuriteSociale(collaborateur.getNumSecuriteSociale())) throw  new RuntimeException("Num securite sociale deja existe");
        if(responsableId==0){
            collaborateur.setResponsable(null);
            responsableServiceImpl.ajouterResponsable(collaborateur.getNomComplet(),collaborateur);
        }
        collaborateur.setEtudeNature(etudeNature);
        collaborateur.setEtudeLevel(etudeLevel);
        collaborateur.setContractType(contractType);
        collaborateur.setSalaryAdvantage(salaryAdvantage);
        collaborateur.setPoste(poste);
        collaborateur.setPostName(poste.getPosteName());
        collaborateur.setType(contractType.getType());
        collaborateur.setSalaireBrute();

        return collaborateurRepo.save(collaborateur);
    }


    @Override
    public void deleteCollaborateur(Long id) {
        collaborateurRepo.deleteById(id);
    }

    @Override
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
            updatedCollaborateur.setPostName(poste.getPosteName());
            updatedCollaborateur.setType(contractType.getType());
            updatedCollaborateur.setSalaireBrute();
        }else{
            updatedCollaborateur.setId(updatedCollaborateur.getId());
            updatedCollaborateur.setEtudeNature(etudeNature);
            updatedCollaborateur.setEtudeLevel(etudeLevel);
            updatedCollaborateur.setContractType(contractType);
            updatedCollaborateur.setSalaryAdvantage(salaryAdvantage);
            updatedCollaborateur.setPoste(poste);
            updatedCollaborateur.setResponsable(responsable);
            updatedCollaborateur.setPostName(poste.getPosteName());
            updatedCollaborateur.setType(contractType.getType());
            updatedCollaborateur.setSalaireBrute();
            updatedCollaborateur.setPiecesJointe(collaborateurRepo.findById(updatedCollaborateur.getId()).get().getPiecesJointe());
        }


        return collaborateurRepo.save(updatedCollaborateur);
    }

    @Override
    public  double calculateMassSalariale() {
        return collaborateurRepo.calculateMassSalariale();
    }

    @Override
    public  double calculateAverageSalary() {
        return collaborateurRepo.calculateAverageSalary();
    }


    @Override
    public Map<Integer, Long> calculateAgePyramid() {
        Map<Integer, Long> agePyramid = new HashMap<>();
        int currentYear = Year.now().getValue();

        for (Collaborateur collaborateur : collaborateurRepo.findAll()) {
            Date birthdate = collaborateur.getDateNaissance();

            if (birthdate != null) {
                int age = currentYear - birthdate.getYear()-1900;
                agePyramid.put(age, agePyramid.getOrDefault(age, 0L) + 1);
            }
        }

        return agePyramid;
    }













}

