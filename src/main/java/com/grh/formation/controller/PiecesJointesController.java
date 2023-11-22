package com.grh.formation.controller;

import com.grh.formation.model.PiecesJointes;
import com.grh.formation.service.PiecesJointesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/piecesJointes")
@RequiredArgsConstructor
public class PiecesJointesController {
    private final PiecesJointesService piecesJointesService;


    @GetMapping("/all")
    public List<PiecesJointes> PiecesJointess() {
        return piecesJointesService.getAll();
    }
}