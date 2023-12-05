package com.grh.formation.Service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface StorageService {
    String uploadPdf(MultipartFile file, int cin) throws IOException;

    byte[] downloadPdf(long fileId);
}
