package com.grh.formation.repo;

import com.grh.formation.model.Collaborateur;
import com.sun.istack.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface CollaborateurRepo extends JpaRepository<Collaborateur,Long> {
    boolean existsByCin(int cin);

    boolean existsByNumCompte(long numCompte);
    boolean existsByEmail(String email);

    boolean existsByNumSecuriteSociale(long numSecuriteSociale);
    @NotNull
    Optional<Collaborateur> findById(@NotNull Long id);

    Collaborateur findByCin(int cin);

    @Query(value = "SELECT calculate_mass_salariale() FROM DUAL", nativeQuery = true)
    Double calculateMassSalariale();

    @Query(value = "SELECT calculate_average_salary() FROM DUAL", nativeQuery = true)
    Double calculateAverageSalary();





}
