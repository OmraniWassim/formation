package com.grh.formation.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "SCANNEDDOCUMENT")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScannedDocument {
    @Id
    @SequenceGenerator(name="scannedDocument",sequenceName ="scannedDocument",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "poste_sequence")
    private Long id;
    private String name;
    private String type;
    @Lob
    @Column(name = "scannedData",length = 1000)
    private byte[] pdfData;
    @OneToOne
    private Collaborateur collaborateur;
}