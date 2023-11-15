package com.grh.formation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "PIECESJOINTES")
public class PiecesJointes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "contract_type_pieces_jointes",
            joinColumns = @JoinColumn(name = "pieces_jointes_id"),
            inverseJoinColumns = @JoinColumn(name = "contract_type_id")
    )
    private List<ContractType> contractTypes = new ArrayList<>();

    private String name;
    private boolean obligatoire;
    private boolean statut;



    public PiecesJointes(String name) {
        this.name = name;
    }
}
