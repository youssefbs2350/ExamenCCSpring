package com.example.examenccspring.Services;
import com.example.examenccspring.Entities.Declaration;
import java.util.List;
public interface IDeclarationService {
    public void traiterDeclarationAutomatiquement();
    public void traiterDeclarationManuellement(long idDeclaration);
    public List<Declaration> getDeclarationsNonTraitees();
    public List<Declaration> getDeclarationsTraitees();
    public List<Declaration> getDeclarations();
    public Declaration getDeclaration(long idDeclaration);
    public Declaration ajouterDeclaration(Declaration declaration);
    public List<Declaration> afficherDeclarationsTraitees()     ;


}
