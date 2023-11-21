package com.grh.formation.service;

import com.grh.formation.model.PiecesJointes;
import com.grh.formation.repo.PiecesJointesRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PiecesJointesService {

    private  final PiecesJointesRepo etudeNatureRepo;
    public List<PiecesJointes> getAll(){
        return  etudeNatureRepo.findAll();
    }
}
