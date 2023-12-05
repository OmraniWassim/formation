package com.grh.formation.controller;

import com.grh.formation.model.Departement;
import com.grh.formation.Service.DepartementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/departement")
@RequiredArgsConstructor
public class DepartementController {
    private final DepartementService collaborateurService;


    @GetMapping("/all")
    public List<Departement> getAllDepartements() {
        return collaborateurService.getAll();
    }
}