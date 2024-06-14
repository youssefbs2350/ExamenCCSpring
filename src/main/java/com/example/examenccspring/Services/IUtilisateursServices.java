package com.example.examenccspring.Services;
import com.example.examenccspring.Entities.Declaration;
import com.example.examenccspring.Entities.Utilisateur;

import java.util.List;

public interface IUtilisateursServices {
    Utilisateur ajouterVictime(Utilisateur victime);
     Utilisateur ajouterPolicier(Utilisateur policier);
     String ajouterPoliciers(List<Utilisateur> policiers);
    Utilisateur getUtilisateur(String telephone);
    void affecterPolicierADeclaration(long idUtilisateur, long idDeclaration);
    void affecterDeclarationAVictime(long idDeclaration, String telephone);
    void affecterDeclarationAPolicier(long idDeclaration, long idUtilisateur);
    String ajouterDeclarationEtAffecterAVictime(Declaration declaration, String telephone);


    }
