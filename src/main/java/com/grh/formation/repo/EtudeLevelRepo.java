package com.grh.formation.repo;

import com.grh.formation.model.EtudeLevel;
import com.sun.istack.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EtudeLevelRepo extends JpaRepository<EtudeLevel,Long> {
    @NotNull
    Optional<EtudeLevel> findById(@NotNull Long id);

}