package com.grh.formation.serviceImpl;

import com.grh.formation.Service.EtudeNatureService;
import com.grh.formation.model.EtudeNature;
import com.grh.formation.repository.EtudeNatureRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EtudeNatureServiceImpl implements EtudeNatureService {

    private  final EtudeNatureRepo etudeNatureRepo;
    public List<EtudeNature> getAll(){
        return  etudeNatureRepo.findAll();
    }
}
