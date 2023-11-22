package com.grh.formation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @SequenceGenerator(name="pieces_jointes",sequenceName ="pieces_jointes",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pieces_jointes")
    private Long id;
    @JsonIgnoreProperties("piecesJointes")
    @ManyToMany
    @JoinTable(
            name = "contract_type_pieces_jointes",
            joinColumns = @JoinColumn(name = "pieces_jointes_id"),
            inverseJoinColumns = @JoinColumn(name = "contract_type_id")
    )
    private List<ContractType> contractTypes = new ArrayList<>();

    private String name;



    public PiecesJointes(String name) {
        this.name = name;
    }
}
