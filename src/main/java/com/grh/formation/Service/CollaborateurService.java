package com.grh.formation.Service;

import com.grh.formation.model.Collaborateur;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface CollaborateurService {
    List<Collaborateur> getAllCollaborateurs();

    Optional<Collaborateur> getCollaborateurById(Long id);

    Collaborateur saveCollaborateur(
            Collaborateur collaborateur,
            Long etudeNatureId,
            Long etudeLevelId,
            Long contractTypeId,
            Long salaryAdvantageId,
            Long posteId,
            Long responsableId
    );

    void deleteCollaborateur(Long id);

    Collaborateur updateCollaborateur(
            Long etudeNatureId,
            Long etudeLevelId,
            Long contractTypeId,
            Long salaryAdvantageId,
            Long posteId,
            Long responsableId,
            boolean withDocument,
            Collaborateur updatedCollaborateur
    );

    double calculateMassSalariale();

    double calculateAverageSalary();

    Map<Integer, Long> calculateAgePyramid();
}
