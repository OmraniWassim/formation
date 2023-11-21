package com.grh.formation.service;

import com.grh.formation.model.EtudeLevel;
import com.grh.formation.repo.EtudeLevelRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EtudeLevelService {

    private  final EtudeLevelRepo etudeLevelRepo;
    public List<EtudeLevel> getAll(){
        return  etudeLevelRepo.findAll();
    }
}