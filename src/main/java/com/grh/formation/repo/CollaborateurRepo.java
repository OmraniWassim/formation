package com.grh.formation.repo;

import com.grh.formation.model.Collaborateur;
import com.sun.istack.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CollaborateurRepo extends JpaRepository<Collaborateur,Long> {
    boolean existsByCin(int cin);

    boolean existsByNumCompte(long numCompte);

    boolean existsByNumTelephone(int numTelephone);

    boolean existsByEmail(String email);

    boolean existsByNumSecuriteSociale(long numSecuriteSociale);
    @NotNull
    Optional<Collaborateur> findById(@NotNull Long id);

    Collaborateur findByCin(int cin);


    ;
}
