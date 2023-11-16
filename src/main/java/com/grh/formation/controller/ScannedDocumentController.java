package com.grh.formation.controller;

import com.grh.formation.model.DocumentAssignmentRequest;
import com.grh.formation.service.CollaborateurService;
import com.grh.formation.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/pdf")
@RequiredArgsConstructor
public class ScannedDocumentController {
    private final StorageService service;
    private final CollaborateurService collaborateurService;

    @PostMapping("/add")
    public ResponseEntity<?> uploadImage(@RequestParam("pdf") MultipartFile file) throws IOException {
        String uploadImage = service.uploadPdf(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }

    @GetMapping("/get/{fileName}")
    public ResponseEntity<?> downloadImage(@PathVariable String fileName){
        byte[] imageData=service.downloadPdf(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("application/pdf"))
                .body(imageData);

    }
    @PostMapping("/assign-document")
    public ResponseEntity<String> assignDocumentToCollaborateur(@RequestBody DocumentAssignmentRequest request) {
        try {
            collaborateurService.assignDocumentToCollab(request.getDocumentId(), request.getCollaborateurId());
            return new ResponseEntity<>("Document assigned to collaborateur successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to assign document to collaborateur", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
