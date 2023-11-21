package com.grh.formation.controller;

import com.grh.formation.model.Poste;
import com.grh.formation.service.PosteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/poste")
@RequiredArgsConstructor
public class PosteController {
    private final PosteService collaborateurService;


    @GetMapping("/all")
    public List<Poste> getAllPostes() {
        return collaborateurService.getAll();
    }
}