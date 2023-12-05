package com.grh.formation.serviceImpl;

import com.grh.formation.model.ContractType;
import com.grh.formation.model.PiecesJointes;
import com.grh.formation.repo.ContractTypeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContractTypeServiceImpl implements com.grh.formation.Service.ContractTypeService {


    private final ContractTypeRepo contractTypeRepo;



    @Override
    public List<String> getPiecesJointesNamesByContractType(String type) {
        ContractType contractType = contractTypeRepo.findByType(type);

        if (contractType == null || contractType.getPiecesJointes() == null) {
            return Collections.emptyList();
        }

        return contractType.getPiecesJointes()
                .stream()
                .map(PiecesJointes::getName)
                .collect(Collectors.toList());
    }
    @Override
    public List<ContractType> getAll() {
        return contractTypeRepo.findAll();
    }



}




