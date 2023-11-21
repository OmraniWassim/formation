package com.grh.formation.service;

import com.grh.formation.model.SalaryAdvantage;
import com.grh.formation.repo.SalaryAdvantageRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalaryAdvantageService {

    private  final SalaryAdvantageRepo salaryAdvantageRepo;
    public List<SalaryAdvantage> getAll(){
        return  salaryAdvantageRepo.findAll();
    }
}
