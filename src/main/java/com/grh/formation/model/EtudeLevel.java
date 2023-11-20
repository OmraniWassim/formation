package com.grh.formation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "ETUDELEVEL")
public class EtudeLevel {
    @Id
    @SequenceGenerator(name="etude_level",sequenceName ="etude_level",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "etude_level")
    private Long id;

    private String niveaux;


    @OneToMany(mappedBy = "etudeLevel")
    private List<Collaborateur> collaborateurs;

    public EtudeLevel(String niveaux) {
        this.niveaux = niveaux;
    }
}
