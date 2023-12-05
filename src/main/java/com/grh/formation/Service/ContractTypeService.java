package com.grh.formation.Service;

import com.grh.formation.model.ContractType;

import java.util.List;

public interface ContractTypeService {
    List<String> getPiecesJointesNamesByContractType(String type);

    List<ContractType> getAll();
}
