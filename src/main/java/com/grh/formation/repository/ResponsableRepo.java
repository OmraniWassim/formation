package com.grh.formation.repository;

import com.grh.formation.model.Responsable;
import com.sun.istack.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResponsableRepo extends JpaRepository<Responsable,Long> {
    @NotNull
    Optional<Responsable> findById(@NotNull Long id);

}
