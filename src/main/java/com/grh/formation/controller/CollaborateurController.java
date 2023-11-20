package com.grh.formation.controller;

import com.grh.formation.model.Collaborateur;
import com.grh.formation.service.CollaborateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/collaborateurs")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class CollaborateurController {
    private final CollaborateurService collaborateurService;



    @GetMapping("/all")
    public List<Collaborateur> getAllCollaborateurs() {
        return collaborateurService.getAllCollaborateurs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Collaborateur> getCollaborateurById(@PathVariable Long id) {
        Optional<Collaborateur> collaborateur = collaborateurService.getCollaborateurById(id);
        return collaborateur.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Collaborateur> createCollaborateur(@RequestBody Collaborateur collaborateur) {
        Collaborateur savedCollaborateur = collaborateurService.saveCollaborateur(collaborateur);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCollaborateur);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Collaborateur> updateCollaborateur(@PathVariable Long id, @RequestBody Collaborateur updatedCollaborateur) {
        if (collaborateurService.getCollaborateurById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        updatedCollaborateur.setId(id);
        Collaborateur savedCollaborateur = collaborateurService.saveCollaborateur(updatedCollaborateur);

        return ResponseEntity.ok(savedCollaborateur);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCollaborateur(@PathVariable Long id) {
        if (collaborateurService.getCollaborateurById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        collaborateurService.deleteCollaborateur(id);
        return ResponseEntity.noContent().build();
    }
}

