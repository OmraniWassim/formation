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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String type;
    @Lob
    @Column(name = "scannedData",length = 1000)
    private byte[] pdfData;
    @OneToOne
    private Collaborateur collaborateur;
}