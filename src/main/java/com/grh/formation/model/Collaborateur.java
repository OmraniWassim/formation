package com.grh.formation.model;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;


import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "COLLABORATEUR")
public class Collaborateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 8, nullable = false)
    private int cin;

    @Column(nullable = false)
    private String nomComplet;

    @Column(length = 13, nullable = false)
    private int numCompte;

    @Column(length = 15, nullable = false)
    private int numSecuriteSociale;

    @Column(nullable = false)
    private int numTelephone;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dateNaissance;

    @Column(nullable = false)
    private String adresse;

    @Column(nullable = false, unique = true)
    private String email;

    private String certifications;

    @Column(nullable = false)
    private int anneeExperience;

    @Column(nullable = false)
    private int salaireBase;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dateDebutContrat;

    @Column(nullable = false)
    private boolean recommandation;

    @Column
    private String collaborateurRecommande;

    @Column
    private String commentaire;


    private String piecesJointe;

    @ManyToOne
    @JsonIgnoreProperties({"collaborateurs"})
    private EtudeNature etudeNature;

    @ManyToOne
    @JsonIgnoreProperties({"collaborateurs"})
    private EtudeLevel etudeLevel;

    @ManyToOne
    @JsonIgnoreProperties({"collaborateurs","piecesJointes"})
    private ContractType contractType;

    @ManyToOne
    @JsonIgnoreProperties({"collaborateurs"})
    private SalaryAdvantage salaryAdvantage;

    @ManyToOne
    @JsonIgnoreProperties({"collaborateurs"})
    private Poste poste;

    @ManyToOne
    @JsonIgnoreProperties({"collaborateurs"})
    private Departement departement;

    @ManyToOne
    @JsonIgnoreProperties({"collaborateurs"})
    private Responsable responsable;



}
