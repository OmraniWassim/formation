package com.grh.formation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @SequenceGenerator(name="poste_sequence",sequenceName ="poste_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "poste_sequence")
    private Long id;

    private String posteName;

    @OneToMany(mappedBy = "poste")
    private List<Collaborateur> collaborateurs;

    @ManyToOne
    @JsonIgnoreProperties({"postes"})
    private Departement departement;

    public Poste(String posteName) {
        this.posteName = posteName;
    }
}
