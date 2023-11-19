package com.grh.formation.service;

import com.grh.formation.model.Collaborateur;
import com.grh.formation.model.ScannedDocument;
import com.grh.formation.repo.CollaborateurRepo;
import com.grh.formation.repo.ScannedDocumentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CollaborateurService {
    private final CollaborateurRepo collaborateurRepository;
    private final ScannedDocumentRepo scannedDocumentRepo;




    public List<Collaborateur> getAllCollaborateurs() {
        return collaborateurRepository.findAll();
    }

    public Optional<Collaborateur> getCollaborateurById(Long id) {
        return collaborateurRepository.findById(id);
    }

    public Collaborateur saveCollaborateur(Collaborateur collaborateur) {
        return collaborateurRepository.save(collaborateur);
    }

    public void deleteCollaborateur(Long id) {
        collaborateurRepository.deleteById(id);
    }

    public void assignDocumentToCollab(long idDoc,long idCollab){
        ScannedDocument scannedDocument=scannedDocumentRepo.findById(idDoc).orElse(null);
        Collaborateur collaborateur=collaborateurRepository.findById(idCollab).orElse(null);
        assert collaborateur != null;
        assert scannedDocument != null;
        collaborateur.setPiecesJointe(scannedDocument);
        scannedDocument.setCollaborateur(collaborateur);
        collaborateurRepository.save(collaborateur);
        scannedDocumentRepo.save(scannedDocument);


    }
}

