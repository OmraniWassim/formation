package com.grh.formation.service;

import com.grh.formation.model.*;
import com.grh.formation.repo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CollaborateurService {
    private final CollaborateurRepo collaborateurRepo;
    private final ScannedDocumentRepo scannedDocumentRepo;
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
        // Fetch related entities from the database
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
            Long id,
            Long etudeNatureId,
            Long etudeLevelId,
            Long contractTypeId,
            Long salaryAdvantageId,
            Long posteId,
            Long responsableId,
            Collaborateur updatedCollaborateur
    ) {
        if (collaborateurRepo.findById(id).isEmpty()) {
            throw new EntityNotFoundException("Collaborateur not found with id: " + id);
        }

        // Fetch related entities from the database
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

        updatedCollaborateur.setId(id);
        updatedCollaborateur.setEtudeNature(etudeNature);
        updatedCollaborateur.setEtudeLevel(etudeLevel);
        updatedCollaborateur.setContractType(contractType);
        updatedCollaborateur.setSalaryAdvantage(salaryAdvantage);
        updatedCollaborateur.setPoste(poste);
        updatedCollaborateur.setResponsable(responsable);

        return collaborateurRepo.save(updatedCollaborateur);
    }


    public void assignDocumentToCollab(long idDoc,long idCollab){
        ScannedDocument scannedDocument=scannedDocumentRepo.findById(idDoc).orElse(null);
        Collaborateur collaborateur=collaborateurRepo.findById(idCollab).orElse(null);
        assert collaborateur != null;
        assert scannedDocument != null;
        collaborateur.setPiecesJointe(scannedDocument);
        scannedDocument.setCollaborateur(collaborateur);
        collaborateurRepo.save(collaborateur);
        scannedDocumentRepo.save(scannedDocument);


    }
}

