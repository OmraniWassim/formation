package com.grh.formation.repository;

import com.grh.formation.model.ContractType;
import com.sun.istack.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContractTypeRepo extends JpaRepository<ContractType,Long> {
    @NotNull
    Optional<ContractType> findById(@NotNull Long id);

    ContractType findByType(String contractTypeName);

}