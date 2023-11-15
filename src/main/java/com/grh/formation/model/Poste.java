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
public class Poste {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String posteName;

    @OneToMany(mappedBy = "poste")
    private List<Collaborateur> collaborateurs;


}
