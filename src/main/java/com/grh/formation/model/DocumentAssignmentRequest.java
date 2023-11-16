package com.grh.formation.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class DocumentAssignmentRequest {

    private Long documentId;
    private Long collaborateurId;


}

