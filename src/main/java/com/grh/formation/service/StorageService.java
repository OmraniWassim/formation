package com.grh.formation.service;



import com.grh.formation.model.ScannedDocument;
import com.grh.formation.repo.ScannedDocumentRepo;
import com.grh.formation.util.PdfUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StorageService {


    private final ScannedDocumentRepo repository;

    public String uploadPdf(MultipartFile file) throws IOException {

        ScannedDocument pdfDAta = repository.save(ScannedDocument.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .pdfData(PdfUtils.compressPdf(file.getBytes())).build());
        if (pdfDAta != null) {
            return "file uploaded successfully : " + file.getOriginalFilename();
        }
        return null;
    }

    public byte[] downloadPdf(String fileName){
        Optional<ScannedDocument> dbScannedDocument = repository.findByName(fileName);
        byte[] pdf=PdfUtils.decompressPdf(dbScannedDocument.get().getPdfData());
        return pdf;
    }
}