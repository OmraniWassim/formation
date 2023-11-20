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
    @SequenceGenerator(name="etude_nature",sequenceName ="etude_nature",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "etude_nature")
    private Long id;

    private String nature;

    @OneToMany(mappedBy = "etudeNature")
    private List<Collaborateur> collaborateurs;

    public EtudeNature(String nature) {
        this.nature = nature;
    }
}
