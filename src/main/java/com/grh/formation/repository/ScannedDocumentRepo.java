package com.grh.formation.repository;

import com.grh.formation.model.ScannedDocument;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ScannedDocumentRepo extends JpaRepository<ScannedDocument,Long> {


    Optional<ScannedDocument> findByName(String fileName);
}
