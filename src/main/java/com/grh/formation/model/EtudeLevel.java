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
@Table(name = "ETUDELEVEL")
public class EtudeLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String niveaux;


    @OneToMany(mappedBy = "etudeLevel")
    private List<Collaborateur> collaborateurs;


}
