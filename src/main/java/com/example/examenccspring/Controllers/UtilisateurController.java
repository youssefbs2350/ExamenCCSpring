package com.example.examenccspring.Controllers;

import com.example.examenccspring.Entities.Declaration;
import com.example.examenccspring.Entities.Utilisateur;
import com.example.examenccspring.Services.IUtilisateursServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    private final IUtilisateursServices utilisateurService;

    @PostMapping("/ajouter-victime")
    public ResponseEntity<Utilisateur> ajouterVictime(@RequestBody Utilisateur victime) {
        Utilisateur newVictime = utilisateurService.ajouterVictime(victime);
        if (newVictime == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(newVictime);
    }
    @PostMapping("/ajouter-policier")
    public ResponseEntity<Utilisateur> ajouterPolicier(@RequestBody Utilisateur policier) {
        Utilisateur newPolicier = utilisateurService.ajouterPolicier(policier);
        if (newPolicier == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(newPolicier);
    }

    @PostMapping("/ajouter-policiers")
    public ResponseEntity<String> ajouterPoliciers(@RequestBody List<Utilisateur> policiers) {
        String message = utilisateurService.ajouterPoliciers(policiers);
        return ResponseEntity.ok(message);
    }

    @PostMapping("/ajouter-declaration-et-affecter-a-victime/{telephone}")
    public ResponseEntity<String> ajouterDeclarationEtAffecterAVictime(
            @RequestBody Declaration declaration, @PathVariable String telephone) {
        String message = utilisateurService.ajouterDeclarationEtAffecterAVictime(declaration, telephone);
        return ResponseEntity.ok(message);
    }

    @PostMapping("/affecter-policier-a-declaration/{idUtilisateur}/{idDeclaration}")
    public ResponseEntity<Void> affecterPolicierADeclaration(
            @PathVariable long idUtilisateur, @PathVariable long idDeclaration) {
        utilisateurService.affecterPolicierADeclaration(idUtilisateur, idDeclaration);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/affecter-declaration-a-victime/{idDeclaration}/{telephone}")
    public ResponseEntity<Void> affecterDeclarationAVictime(
            @PathVariable long idDeclaration, @PathVariable String telephone) {
        utilisateurService.affecterDeclarationAVictime(idDeclaration, telephone);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/affecter-declaration-a-policier/{idDeclaration}/{idUtilisateur}")
    public ResponseEntity<Void> affecterDeclarationAPolicier(
            @PathVariable long idDeclaration, @PathVariable long idUtilisateur) {
        utilisateurService.affecterDeclarationAPolicier(idDeclaration, idUtilisateur);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-utilisateur/{telephone}")
    public ResponseEntity<Utilisateur> getUtilisateur(@PathVariable String telephone) {
        Utilisateur utilisateur = utilisateurService.getUtilisateur(telephone);
        if (utilisateur == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(utilisateur);
    }

    @GetMapping("/get-declarations-victime/{telephone}")
    public ResponseEntity<List<Declaration>> getDeclarationsVictime(@PathVariable String telephone) {
        Utilisateur utilisateur = utilisateurService.getUtilisateur(telephone);
        if (utilisateur == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(utilisateur.getDeclarationsVictime());
    }
}
