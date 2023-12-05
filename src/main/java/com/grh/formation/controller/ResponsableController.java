package com.grh.formation.controller;

import com.grh.formation.Service.ResponsableService;
import com.grh.formation.model.Responsable;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/responsable")
@RequiredArgsConstructor
public class ResponsableController {
    private final ResponsableService collaborateurService;


    @GetMapping("/all")
    public List<Responsable> getAllResponsables() {
        return collaborateurService.getAll();
    }
}