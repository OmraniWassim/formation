package com.grh.formation.service;

import com.grh.formation.model.Departement;
import com.grh.formation.model.Poste;
import com.grh.formation.repo.DepartementRepo;
import com.grh.formation.repo.PosteRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PosteService {

    private final DepartementRepo departementRepo;
    private final PosteRepo posteRepo;
    public Poste addPoste(Poste poste,long departement_id){
        Departement departement=departementRepo.findById(departement_id).orElse(null);
        poste.setDepartement(departement);
        return  posteRepo.save(poste);
    }
}
