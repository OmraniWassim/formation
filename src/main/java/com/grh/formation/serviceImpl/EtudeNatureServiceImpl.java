package com.grh.formation.serviceImpl;

import com.grh.formation.model.EtudeNature;
import com.grh.formation.repo.EtudeNatureRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EtudeNatureServiceImpl implements com.grh.formation.Service.EtudeNatureService {

    private  final EtudeNatureRepo etudeNatureRepo;
    public List<EtudeNature> getAll(){
        return  etudeNatureRepo.findAll();
    }
}
