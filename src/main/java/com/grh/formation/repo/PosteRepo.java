package com.grh.formation.repo;

import com.grh.formation.model.Poste;
import com.sun.istack.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PosteRepo extends JpaRepository<Poste,Long> {
    @NotNull
    Optional<Poste> findById(@NotNull Long id);

}