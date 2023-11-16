package com.grh.formation.service;

import com.grh.formation.model.Collaborateur;
import com.grh.formation.repo.CollaborateurRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CollaborateurService {
    private final CollaborateurRepo collaborateurRepository;



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
}

