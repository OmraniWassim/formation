package com.grh.formation.Service;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;

public interface ReportService {
    ResponseEntity<byte[]> exportReport() throws FileNotFoundException, JRException;

    default byte[] exportReportToBytes(JasperPrint jasperPrint) throws JRException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        JRPdfExporter exporter = new JRPdfExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(byteArrayOutputStream));
        exporter.exportReport();

        return byteArrayOutputStream.toByteArray();
    }
}
