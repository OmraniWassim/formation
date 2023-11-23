package com.grh.formation.controller;

import com.grh.formation.model.SalaryAdvantage;
import com.grh.formation.service.SalaryAdvantageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/avantage")
@RequiredArgsConstructor
public class SalaryAdvantageController {
    private final SalaryAdvantageService collaborateurService;

    @GetMapping("/all")
    public List<SalaryAdvantage> getAllSalaryAdvantages() {
        return collaborateurService.getAll();
    }
}