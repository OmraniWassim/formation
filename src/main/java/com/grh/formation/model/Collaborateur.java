package com.grh.formation.model;



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
    private int id;
    private int cin;
    private String nomComplet;
    private int numCompte;
    private int numSecuriteSociale;
    private int numTelephone;
    private Date dateNaissance;
    private String adresse;
    private String email;
    private String certifications;
    private int anneeExperience;
    private int salaireBase;
    private Date dateDebutContrat;
    private boolean recommandation;
    private String collaborateurRecommande;
    private String commentaire;
    @OneToOne
    @JoinColumn(name = "pieces_jointes_id")
    private PiecesJointes piecesJointes;
    @ManyToOne
    @JoinColumn(name = "etude_nature_id")
    private EtudeNature etudeNature;
    @ManyToOne
    @JoinColumn(name = "etude_level_id")
    private EtudeLevel etudeLevel;
    @ManyToOne
    @JoinColumn(name = "contract_type_id")
    private ContractType contractType;
    @ManyToOne
    @JoinColumn(name = "salary_advantage_id")
    private SalaryAdvantage salaryAdvantage;
    @ManyToOne
    @JoinColumn(name = "poste_id")
    private Poste poste;
    @ManyToOne
    @JoinColumn(name = "departement_id")
    private Departement departement;
    @ManyToOne
    @JoinColumn(name = "responsable_id")
    private Responsable responsable;



}
