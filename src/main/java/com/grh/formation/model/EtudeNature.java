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
@Table(name = "ETUDENATURE")
public class EtudeNature {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nature;

    @OneToMany(mappedBy = "etudeNature")
    private List<Collaborateur> collaborateurs;

    public EtudeNature(String nature) {
        this.nature = nature;
    }
}
