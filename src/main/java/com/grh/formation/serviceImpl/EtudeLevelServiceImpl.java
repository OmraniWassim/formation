package com.grh.formation.serviceImpl;

import com.grh.formation.Service.EtudeLevelService;
import com.grh.formation.model.EtudeLevel;
import com.grh.formation.repo.EtudeLevelRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EtudeLevelServiceImpl implements EtudeLevelService {

    private  final EtudeLevelRepo etudeLevelRepo;
    @Override
    public List<EtudeLevel> getAll(){
        return  etudeLevelRepo.findAll();
    }
}