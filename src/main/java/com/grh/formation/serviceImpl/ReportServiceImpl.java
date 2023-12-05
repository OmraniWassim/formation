package com.grh.formation.serviceImpl;

import com.grh.formation.Service.ReportService;
import com.grh.formation.model.Collaborateur;
import com.grh.formation.repository.CollaborateurRepo;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {


    private final CollaborateurRepo repository;


    @Override
    public ResponseEntity<byte[]> exportReport() throws FileNotFoundException, JRException {
        List<Collaborateur> collaborateurs = repository.findAll();

        File file = ResourceUtils.getFile("classpath:collaborateurs.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(collaborateurs);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Wassim");

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        byte[] pdfBytes = exportReportToBytes(jasperPrint);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "collaborateurs.pdf");
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }

}