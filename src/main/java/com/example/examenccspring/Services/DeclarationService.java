package com.example.examenccspring.Services;

import com.example.examenccspring.Entities.Declaration;
import com.example.examenccspring.Repositories.DeclarationRepo;
import com.example.examenccspring.Repositories.ProprieteRepo;
import com.example.examenccspring.Repositories.UtilisateurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class DeclarationService implements IDeclarationService {

    private final DeclarationRepo declarationRepo;
    private final ProprieteRepo proprieteRepo;
    private final UtilisateurRepo utilisateurRepo;

    @Autowired
    public DeclarationService(DeclarationRepo declarationRepo, ProprieteRepo proprieteRepo, UtilisateurRepo utilisateurRepo) {
        this.declarationRepo = declarationRepo;
        this.proprieteRepo = proprieteRepo;
        this.utilisateurRepo = utilisateurRepo;
    }

    @Override
    public void traiterDeclarationAutomatiquement() {
        Date oneMonthAgo = new Date(System.currentTimeMillis() - (30L * 24 * 60 * 60 * 1000));
        List<Declaration> declarations = declarationRepo.findByDateDeclarationBeforeAndEstTraiteeFalse(oneMonthAgo);

        if (declarations.isEmpty()) {
            System.out.println("Aucune déclaration à traiter automatiquement.");
            return;
        }

        for (Declaration declaration : declarations) {
            declaration.setEstTraitee(true);
            declaration.setDateTraitement(LocalDate.now());
            declarationRepo.save(declaration);
        }
    }


    @Override
    public void traiterDeclarationManuellement(long idDeclaration) {
        Declaration declaration = declarationRepo.findById(idDeclaration).orElse(null);
        if (declaration != null) {
            declaration.setEstTraitee(true);
            declaration.setDateTraitement(LocalDate.now());
            declarationRepo.save(declaration);
        } else {
            throw new IllegalArgumentException("Déclaration non trouvée pour l'ID : " + idDeclaration);
        }
    }

    @Override
    public List<Declaration> getDeclarationsNonTraitees() {
        return declarationRepo.findByEstTraiteeFalse();
    }

    @Override
    public List<Declaration> getDeclarationsTraitees() {
        return declarationRepo.findByEstTraiteeTrue();
    }

    @Override
    public List<Declaration> getDeclarations() {
        return declarationRepo.findAll();
    }

    @Override
    public Declaration getDeclaration(long idDeclaration) {
        return declarationRepo.findById(idDeclaration).orElse(null);
    }

    @Override
    public Declaration ajouterDeclaration(Declaration declaration) {

        return declarationRepo.save(declaration);
    }

    @Override
    public List<Declaration> afficherDeclarationsTraitees() {
        return declarationRepo.findByEstTraitee(true);
    }
}


