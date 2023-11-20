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
public class Responsable {
    @Id
    @SequenceGenerator(name="reponsable",sequenceName ="reponsable",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "reponsable")
    private Long id;

    private String ResName;

    @OneToMany(mappedBy = "responsable")
    private List<Collaborateur> collaborateurs;

    public Responsable(String resName) {
        ResName = resName;
    }

}
