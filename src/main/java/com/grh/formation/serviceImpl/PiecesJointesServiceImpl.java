package com.grh.formation.serviceImpl;

import com.grh.formation.Service.PiecesJointesService;
import com.grh.formation.model.PiecesJointes;
import com.grh.formation.repository.PiecesJointesRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PiecesJointesServiceImpl implements PiecesJointesService {

    private  final PiecesJointesRepo etudeNatureRepo;
    @Override
    public List<PiecesJointes> getAll(){
        return  etudeNatureRepo.findAll();
    }
}
