package com.grh.formation.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CONTRACTTYPE")
public class ContractType {
    @Id
    @SequenceGenerator(name="contract_type",sequenceName ="contract_type",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "contract_type")
    private Long id;
    @Column(unique = true)
    private String type;

    @Column(nullable = false)
    private int salaireBase;

    @ManyToMany(mappedBy = "contractTypes")
    private List<PiecesJointes> piecesJointes = new ArrayList<>();

    @OneToMany(mappedBy = "contractType")
    private List<Collaborateur> collaborateurs;


    public ContractType( String type,int salaireBase) {
        this.salaireBase=salaireBase;
        this.type = type;
    }



}
