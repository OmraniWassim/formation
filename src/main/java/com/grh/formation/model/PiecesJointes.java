package com.grh.formation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "PIECESJOINTES")
public class PiecesJointes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String piecesJointes;
    private String obligatoire;
    private boolean statut;

    @OneToOne
    @JoinColumn(name = "collaborateur_id")
    private Collaborateur collaborateur;


}
