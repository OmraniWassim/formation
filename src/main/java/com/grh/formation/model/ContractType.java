package com.grh.formation.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

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

    private String type;
    @OneToMany(mappedBy = "contractType")
    private List<Collaborateur> collaborateurs;


}
