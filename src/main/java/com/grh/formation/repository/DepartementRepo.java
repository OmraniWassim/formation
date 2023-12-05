package com.grh.formation.repository;

import com.grh.formation.model.Departement;
import com.sun.istack.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartementRepo extends JpaRepository<Departement,Long> {
    @NotNull
    Optional<Departement> findById(@NotNull Long id);

}