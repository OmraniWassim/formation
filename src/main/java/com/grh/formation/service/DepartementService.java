package com.grh.formation.service;

import com.grh.formation.model.Departement;
import com.grh.formation.repo.DepartementRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartementService {

    private  final DepartementRepo etudeNatureRepo;
    public List<Departement> getAll(){
        return  etudeNatureRepo.findAll();
    }
}