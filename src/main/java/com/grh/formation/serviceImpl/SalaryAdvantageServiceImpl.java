package com.grh.formation.serviceImpl;

import com.grh.formation.Service.SalaryAdvantageService;
import com.grh.formation.model.ContractType;
import com.grh.formation.model.SalaryAdvantage;
import com.grh.formation.repository.ContractTypeRepo;
import com.grh.formation.repository.SalaryAdvantageRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalaryAdvantageServiceImpl implements SalaryAdvantageService {

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
