package com.grh.formation.controller;

import com.grh.formation.Service.EtudeLevelService;
import com.grh.formation.model.EtudeLevel;
import com.grh.formation.model.EtudeNature;
import com.grh.formation.serviceImpl.EtudeNatureServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/etude")
@RequiredArgsConstructor
public class EtudeController {

    private final EtudeLevelService etudeLevelServiceImpl;
    private final EtudeNatureServiceImpl etudeNatureServiceImpl;


    @GetMapping("/getLevels")
    public ResponseEntity<List<EtudeLevel>> getAllEtudeLevels() {
        return ResponseEntity.ok(etudeLevelServiceImpl.getAll());

    }
    @GetMapping("/getNatures")
    public ResponseEntity<List<EtudeNature>> getAllEtudeNatures() {
        return ResponseEntity.ok(etudeNatureServiceImpl.getAll());

    }
}
