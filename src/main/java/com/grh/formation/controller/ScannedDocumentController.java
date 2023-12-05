package com.grh.formation.controller;

import com.grh.formation.Service.StorageService;
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

    @PostMapping("/add")
    public ResponseEntity<?> uploadImage(@RequestParam("pdf") MultipartFile file,@RequestParam("cin") int cin) throws IOException {
        String uploadImage = service.uploadPdf(file,cin);
        return ResponseEntity.ok(uploadImage);
    }

    @GetMapping("/get/{fileId}")
    public ResponseEntity<?> downloadImage(@PathVariable long fileId){
        byte[] imageData=service.downloadPdf(fileId);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("application/pdf"))
                .body(imageData);

    }


}
