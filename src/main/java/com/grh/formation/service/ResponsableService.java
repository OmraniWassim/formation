package com.grh.formation.service;

import com.grh.formation.model.Collaborateur;
import com.grh.formation.model.Responsable;
import com.grh.formation.repo.ResponsableRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResponsableService {

    private  final ResponsableRepo responsableRepo;
    public List<Responsable> getAll(){
        return  responsableRepo.findAll();
    }
    public Responsable ajouterResponsable(String name, Collaborateur collaborateur){
        Responsable responsable=new Responsable(name);
        return responsableRepo.save(responsable);

    }
}
