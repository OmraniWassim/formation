package com.grh.formation.serviceImpl;

import com.grh.formation.Service.DepartementService;
import com.grh.formation.model.Departement;
import com.grh.formation.repository.DepartementRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartementServiceImpl implements DepartementService {

    private  final DepartementRepo etudeNatureRepo;
    @Override
    public List<Departement> getAll(){
        return  etudeNatureRepo.findAll();
    }
}