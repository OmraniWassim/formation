package com.grh.formation.repo;

import com.grh.formation.model.EtudeNature;
import com.sun.istack.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EtudeNatureRepo extends JpaRepository<EtudeNature,Long> {
    @NotNull
    Optional<EtudeNature> findById(@NotNull Long id);

}