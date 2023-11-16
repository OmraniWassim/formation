package com.grh.formation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String DepName;

    @OneToMany(mappedBy = "departement")
    private List<Collaborateur> collaborateurs;


    public Departement(String depName) {
        DepName = depName;
    }
}

