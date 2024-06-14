package com.example.examenccspring.Services;

import com.example.examenccspring.Entities.Declaration;
import com.example.examenccspring.Entities.Role;
import com.example.examenccspring.Entities.Utilisateur;
import com.example.examenccspring.Repositories.DeclarationRepo;
import com.example.examenccspring.Repositories.UtilisateurRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UtilisateurService implements IUtilisateursServices {

    private UtilisateurRepo utilisateurRepository;
    private DeclarationRepo declarationRepository;

    @Override
    public Utilisateur ajouterVictime(Utilisateur victime) {
        if (victime.getRole() != Role.VICTIME) {
            return null; 
        }
        return utilisateurRepository.save(victime);
    }

    @Override
    public Utilisateur ajouterPolicier(Utilisateur policier) {
        if (policier.getRole() != Role.POLICIER) {
            return null; 
        }
        return utilisateurRepository.save(policier);
    }

    @Override
    public String ajouterPoliciers(List<Utilisateur> policiers) {
        long count = policiers.stream().filter(p -> p.getRole() == Role.POLICIER).count();
        utilisateurRepository.saveAll(policiers);
        return count + " policiers sont ajoutés avec succès !";
    }

    @Override
        public Utilisateur getUtilisateur(String telephone) {
            return utilisateurRepository.findByTelephone(telephone);
        }

    @Override
    public String ajouterDeclarationEtAffecterAVictime(Declaration declaration, String telephone) {
        Utilisateur victime = utilisateurRepository.findByTelephone(telephone);
        if (victime != null && victime.getRole() == Role.VICTIME) {
            declaration.setVictime(victime);
            declarationRepository.save(declaration);
            return "Déclaration ajoutée et affectée à la victime " + victime.getNom() + " " + victime.getPrenom();
        }
        return "Victime non trouvée";
    }

    @Override
    public void affecterPolicierADeclaration(long idUtilisateur, long idDeclaration) {
        Utilisateur policier = utilisateurRepository.findById(idUtilisateur).orElse(null);
        Declaration declaration = declarationRepository.findById(idDeclaration).orElse(null);

        if (policier != null && policier.getRole() == Role.POLICIER && declaration != null) {
            declaration.setPolicier(policier);
            declarationRepository.save(declaration);
        }
    }

    @Override
    public void affecterDeclarationAVictime(long idDeclaration, String telephone) {
        Utilisateur victime = utilisateurRepository.findByTelephoneAndRole(telephone, Role.VICTIME);
        Declaration declaration = declarationRepository.findById(idDeclaration).orElse(null);

        if (victime != null && declaration != null) {
            declaration.setVictime(victime);
            declarationRepository.save(declaration);
        } else {
            System.out.println("Déclaration ou victime non trouvée.");

        }
    }

    @Override
    public void affecterDeclarationAPolicier(long idDeclaration, long idUtilisateur) {
        Utilisateur policier = utilisateurRepository.findByIdAndRole(idUtilisateur, Role.POLICIER);
        Declaration declaration = declarationRepository.findById(idDeclaration).orElse(null);

        if (policier != null && declaration != null) {
            declaration.setPolicier(policier);
            declarationRepository.save(declaration);
        } else {
            System.out.println("declaration ou policier non trouvée.");
        }
    }

}
