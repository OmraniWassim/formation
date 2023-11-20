package com.grh.formation.repo;

import com.grh.formation.model.Collaborateur;
import com.sun.istack.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CollaborateurRepo extends JpaRepository<Collaborateur,Long> {
    @NotNull
    Optional<Collaborateur> findById(@NotNull Long id);

    boolean existsByEtudeNature_Nature(String nature);



}