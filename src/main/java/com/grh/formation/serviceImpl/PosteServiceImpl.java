package com.grh.formation.serviceImpl;

import com.grh.formation.Service.PosteService;
import com.grh.formation.model.Poste;
import com.grh.formation.repo.DepartementRepo;
import com.grh.formation.repo.PosteRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PosteServiceImpl implements PosteService {

    private final PosteRepo posteRepo;



        @Override
        public List<Poste> getAll(){
            return  posteRepo.findAll();
        }


}
