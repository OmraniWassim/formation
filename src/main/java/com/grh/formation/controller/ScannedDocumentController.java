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
    public ResponseEntity<?> uploadImage(@RequestParam("pdf") MultipartFile file,@RequestParam("cin") int cin) throws IOException {
        String uploadImage = service.uploadPdf(file,cin);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }

    @GetMapping("/get/{fileId}")
    public ResponseEntity<?> downloadImage(@PathVariable long fileId){
        byte[] imageData=service.downloadPdf(fileId);
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
