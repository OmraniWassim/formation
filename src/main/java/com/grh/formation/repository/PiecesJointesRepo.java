package com.grh.formation.repository;

import com.grh.formation.model.PiecesJointes;
import com.sun.istack.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PiecesJointesRepo extends JpaRepository<PiecesJointes,Long> {
    @NotNull
    Optional<PiecesJointes> findById(@NotNull Long id);

    PiecesJointes findByName(String pieceJointeName);
}
