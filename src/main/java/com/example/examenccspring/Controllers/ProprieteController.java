package com.example.examenccspring.Controllers;

import com.example.examenccspring.Entities.Propriete;
import com.example.examenccspring.Services.ProprieteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/proprietes")
public class ProprieteController {

    private final ProprieteService proprieteService;

    public ProprieteController(ProprieteService proprieteService) {
        this.proprieteService = proprieteService;
    }

    @GetMapping
    public ResponseEntity<List<Propriete>> getAllProprietes() {
        List<Propriete> proprietes = proprieteService.getAllProprietes();
        return ResponseEntity.ok(proprietes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Propriete> getProprieteById(@PathVariable Long id) {
        Optional<Propriete> propriete = proprieteService.getProprieteById(id);
        return propriete.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Propriete> saveOrUpdatePropriete(@RequestBody Propriete propriete) {
        Propriete savedPropriete = proprieteService.savePropriete(propriete);
        return ResponseEntity.ok(savedPropriete);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProprieteById(@PathVariable Long id) {
        proprieteService.deleteProprieteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/par-matricule/{matricule}")
    public ResponseEntity<Propriete> recupererProprieteParMatricule(@PathVariable String matricule) {
        Optional<Propriete> propriete = proprieteService.recupererProprieteParMatricule(matricule);
        return propriete.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

