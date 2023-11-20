package com.grh.formation.service;

import com.grh.formation.model.EtudeNature;
import com.grh.formation.repo.EtudeNatureRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EtudeNatureService {

    private final EtudeNatureRepo etudeNatureRepo;

    public List<EtudeNature> getAll(){
        return etudeNatureRepo.findAll();
    }
}
