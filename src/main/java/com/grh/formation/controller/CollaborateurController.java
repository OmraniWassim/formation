package com.grh.formation.controller;

import com.grh.formation.Service.CollaborateurService;
import com.grh.formation.Service.ReportService;
import com.grh.formation.model.Collaborateur;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/collaborateurs")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class CollaborateurController {
    private final CollaborateurService collaborateurService;
    private final ReportService service;


    @GetMapping("/report")
    public ResponseEntity<byte[]> generateReport() throws FileNotFoundException, JRException {
        return service.exportReport();
    }
    @GetMapping("/all")
    public List<Collaborateur> getAllCollaborateurs() {
        return collaborateurService.getAllCollaborateurs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Collaborateur> getCollaborateurById(@PathVariable Long id) {
        Optional<Collaborateur> collaborateur = collaborateurService.getCollaborateurById(id);
        return collaborateur.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add/{etudeNatureId}/{etudeLevelId}/{contractTypeId}/{salaryAdvantageId}/{posteId}/{responsableId}")
    public ResponseEntity<Collaborateur> createCollaborateur(
            @RequestBody Collaborateur collaborateur,
            @PathVariable Long etudeNatureId,
            @PathVariable Long etudeLevelId,
            @PathVariable Long contractTypeId,
            @PathVariable Long salaryAdvantageId,
            @PathVariable Long posteId,
            @PathVariable Long responsableId) {

        Collaborateur savedCollaborateur = collaborateurService.saveCollaborateur(
                collaborateur,
                etudeNatureId,
                etudeLevelId,
                contractTypeId,
                salaryAdvantageId,
                posteId,
                responsableId
        );

        return new ResponseEntity<>(savedCollaborateur, HttpStatus.CREATED);
    }


    @PutMapping("/update/{etudeNatureId}/{etudeLevelId}/{contractTypeId}/{salaryAdvantageId}/{posteId}/{responsableId}/{withDocument}")
    public ResponseEntity<Collaborateur> updateCollaborateur(
            @PathVariable Long etudeNatureId,
            @PathVariable Long etudeLevelId,
            @PathVariable Long contractTypeId,
            @PathVariable Long salaryAdvantageId,
            @PathVariable Long posteId,
            @PathVariable Long responsableId,
            @PathVariable boolean withDocument,
            @RequestBody Collaborateur updatedCollaborateur) {

        Collaborateur savedCollaborateur = collaborateurService.updateCollaborateur(
                etudeNatureId,
                etudeLevelId,
                contractTypeId,
                salaryAdvantageId,
                posteId,
                responsableId,
                withDocument,
                updatedCollaborateur
        );

        return new ResponseEntity<>(savedCollaborateur, HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCollaborateur(@PathVariable Long id) {
        if (collaborateurService.getCollaborateurById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        collaborateurService.deleteCollaborateur(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/calculateMassSalariale")
    public double calculateMassSalariale() {
        return collaborateurService.calculateMassSalariale();
    }

    @GetMapping("/calculateAgePyramid")
    public Map<Integer, Long> calculateAgePyramid() {
        return collaborateurService.calculateAgePyramid();
    }

    @GetMapping("/calculateAverageSalary")
    public double calculateAverageSalary() {
        return collaborateurService.calculateAverageSalary();
    }
}

