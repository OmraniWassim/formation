package com.grh.formation.serviceImpl;

import com.grh.formation.model.ContractType;
import com.grh.formation.model.SalaryAdvantage;
import com.grh.formation.repo.ContractTypeRepo;
import com.grh.formation.repo.SalaryAdvantageRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalaryAdvantageServiceImpl implements com.grh.formation.Service.SalaryAdvantageService {

    private  final SalaryAdvantageRepo salaryAdvantageRepo;
    private  final ContractTypeRepo contractTypeRepo;
    @Override
    public List<SalaryAdvantage> getAll(){
        return  salaryAdvantageRepo.findAll();
    }

    @Override
    public SalaryAdvantage addSalaryAdvantage(SalaryAdvantage salaryAdvantage, long contractType_id){
        ContractType contarctType=contractTypeRepo.findById(contractType_id).orElse(null);
        salaryAdvantage.setContractType(contarctType);
        return salaryAdvantageRepo.save(salaryAdvantage);
    }
}
