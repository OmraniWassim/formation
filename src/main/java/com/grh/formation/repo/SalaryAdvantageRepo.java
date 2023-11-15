package com.grh.formation.repo;

import com.grh.formation.model.SalaryAdvantage;
import com.sun.istack.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SalaryAdvantageRepo extends JpaRepository<SalaryAdvantage,Long> {
    @NotNull
    Optional<SalaryAdvantage> findById(@NotNull Long id);

}
