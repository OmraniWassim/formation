package com.grh.formation.controller;


import com.grh.formation.model.ContractType;
import com.grh.formation.model.Poste;
import com.grh.formation.service.ContractTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/contract-type")
@RequiredArgsConstructor
public class ContractTypeController {


    private final  ContractTypeService contractTypeService;

    @GetMapping("/{contractTypeName}/pieces-jointes")
    public ResponseEntity<List<String>> getPiecesJointesByContractType(@PathVariable String contractTypeName) {
        List<String > piecesJointesList = contractTypeService.getPiecesJointesNamesByContractType(contractTypeName);
        return ResponseEntity.ok(piecesJointesList);
    }
    @GetMapping("/all")
    public List<ContractType> getAllPostes() {
        return contractTypeService.getAll();
    }
}
