package com.example.examenccspring.Controllers;

import com.example.examenccspring.Entities.Declaration;
import com.example.examenccspring.Services.IDeclarationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/declarations")
public class DeclarationController {

    private final IDeclarationService declarationService;

    @PostMapping("/ajouter")
    public ResponseEntity<Declaration> ajouterDeclaration(@RequestBody Declaration declaration) {
        Declaration newDeclaration = declarationService.ajouterDeclaration(declaration);
        return ResponseEntity.ok(newDeclaration);
    }

    @GetMapping("/traitees")
    public ResponseEntity<List<Declaration>> getDeclarationsTraitees() {
        List<Declaration> declarations = declarationService.getDeclarationsTraitees();
        return ResponseEntity.ok(declarations);
    }

    @GetMapping("/non-traitees")
    public ResponseEntity<List<Declaration>> getDeclarationsNonTraitees() {
        List<Declaration> declarations = declarationService.getDeclarationsNonTraitees();
        return ResponseEntity.ok(declarations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Declaration> getDeclaration(@PathVariable long id) {
        Declaration declaration = declarationService.getDeclaration(id);
        if (declaration == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(declaration);
    }

    @PutMapping("/traiter-manuellement/{id}")
    public ResponseEntity<Void> traiterDeclarationManuellement(@PathVariable long id) {
        declarationService.traiterDeclarationManuellement(id);
        return ResponseEntity.ok().build();
    }

    // Endpoint pour traiter automatiquement les déclarations
    @PutMapping("/traiter-automatiquement")
    public ResponseEntity<Void> traiterDeclarationAutomatiquement() {
        declarationService.traiterDeclarationAutomatiquement();
        return ResponseEntity.ok().build();
    }

    // Endpoint pour afficher les déclarations traitées
    @GetMapping("/afficher-traites")
    public ResponseEntity<List<Declaration>> afficherDeclarationsTraitees() {
        List<Declaration> declarations = declarationService.afficherDeclarationsTraitees();
        return ResponseEntity.ok(declarations);
    }
}
