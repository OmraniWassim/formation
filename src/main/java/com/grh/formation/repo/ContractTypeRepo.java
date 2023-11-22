package com.grh.formation.repo;

import com.grh.formation.model.ContractType;
import com.grh.formation.model.Poste;
import com.sun.istack.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContractTypeRepo extends JpaRepository<ContractType,Long> {
    @NotNull
    Optional<ContractType> findById(@NotNull Long id);

    ContractType findByType(String contractTypeName);

}