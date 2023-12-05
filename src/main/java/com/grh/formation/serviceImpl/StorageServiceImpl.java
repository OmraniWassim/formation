package com.grh.formation.serviceImpl;



import com.grh.formation.model.Collaborateur;
import com.grh.formation.model.ScannedDocument;
import com.grh.formation.repo.CollaborateurRepo;
import com.grh.formation.repo.ScannedDocumentRepo;
import com.grh.formation.util.PdfUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StorageServiceImpl implements com.grh.formation.Service.StorageService {


    private final ScannedDocumentRepo repository;
    private final CollaborateurRepo collaborateurRepo;

    @Override
    public String uploadPdf(MultipartFile file, int cin) throws IOException {

        ScannedDocument pdfDAta = repository.save(ScannedDocument.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .pdfData(PdfUtils.compressPdf(file.getBytes())).build());

        if (pdfDAta != null) {
            Collaborateur collaborateur=collaborateurRepo.findByCin(cin);
            collaborateur.setPiecesJointe(pdfDAta);
            collaborateurRepo.save(collaborateur);
            return "file uploaded successfully : " + file.getOriginalFilename();

        }
        return null;
    }

    @Override
    public byte[] downloadPdf(long fileId){
        Optional<ScannedDocument> dbScannedDocument = repository.findById(fileId);
        byte[] pdf=PdfUtils.decompressPdf(dbScannedDocument.get().getPdfData());
        return pdf;
    }
}