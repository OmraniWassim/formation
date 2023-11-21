package com.grh.formation.service;

import com.grh.formation.model.Responsable;
import com.grh.formation.repo.ResponsableRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResponsableService {

    private  final ResponsableRepo etudeNatureRepo;
    public List<Responsable> getAll(){
        return  etudeNatureRepo.findAll();
    }
}
