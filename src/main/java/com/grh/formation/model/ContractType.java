package com.grh.formation.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CONTRACTTYPE")
public class ContractType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String type;

    @ManyToMany(mappedBy = "contractTypes")
    private List<PiecesJointes> piecesJointes = new ArrayList<>();

    @OneToMany(mappedBy = "contractType")
    private List<Collaborateur> collaborateurs;


    public ContractType( String type) {
        this.type = type;
    }



}
