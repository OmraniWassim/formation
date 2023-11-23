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
    @SequenceGenerator(name="collab_sequence",sequenceName ="collab_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "collab_sequence")
    private Long id;

    @Column(length = 8, nullable = false,unique = true)
    private int cin;

    @Column(nullable = false)
    private String nomComplet;

    @Column(length = 13, nullable = false)
    private long numCompte;

    @Column(length = 15, nullable = false)
    private long numSecuriteSociale;

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

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dateDebutContrat;
    @Temporal(TemporalType.DATE)

    private Date dateFinContrat;

    @Column(nullable = false)
    private boolean recommandation;

    @Column
    private String collaborateurRecommande;

    @Column
    private String commentaire;


    @OneToOne
    @JsonIgnoreProperties({"collaborateur"})
    private ScannedDocument piecesJointe;

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
    private Responsable responsable;

    public Collaborateur(int cin, String nomComplet, long numCompte, long numSecuriteSociale, int numTelephone, Date dateNaissance, String adresse, String email, String certifications, int anneeExperience, Date dateDebutContrat, boolean recommandation, String collaborateurRecommande, String commentaire) {
        this.cin = cin;
        this.nomComplet = nomComplet;
        this.numCompte = numCompte;
        this.numSecuriteSociale = numSecuriteSociale;
        this.numTelephone = numTelephone;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.email = email;
        this.certifications = certifications;
        this.anneeExperience = anneeExperience;
        this.dateDebutContrat = dateDebutContrat;
        this.recommandation = recommandation;
        this.collaborateurRecommande = collaborateurRecommande;
        this.commentaire = commentaire;
    }
}
