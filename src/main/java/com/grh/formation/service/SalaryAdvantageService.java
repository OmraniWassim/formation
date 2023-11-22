package com.grh.formation.service;

import com.grh.formation.model.ContractType;
import com.grh.formation.model.Departement;
import com.grh.formation.model.SalaryAdvantage;
import com.grh.formation.model.SalaryAdvantage;
import com.grh.formation.repo.ContractTypeRepo;
import com.grh.formation.repo.SalaryAdvantageRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalaryAdvantageService {

    private  final SalaryAdvantageRepo salaryAdvantageRepo;
    private  final ContractTypeRepo contractTypeRepo;
    public List<SalaryAdvantage> getAll(){
        return  salaryAdvantageRepo.findAll();
    }

    public SalaryAdvantage addSalaryAdvantage(SalaryAdvantage salaryAdvantage, long contractType_id){
        ContractType contarctType=contractTypeRepo.findById(contractType_id).orElse(null);
        salaryAdvantage.setContractType(contarctType);
        return salaryAdvantageRepo.save(salaryAdvantage);
    }
}
