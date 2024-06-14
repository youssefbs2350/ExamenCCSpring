package com.example.examenccspring.Services;
import com.example.examenccspring.Entities.Declaration;
import com.example.examenccspring.Entities.Utilisateur;
import com.example.examenccspring.Entities.Propriete;
import java.util.List;
import java.util.Optional;

public interface IProprieteService {
    public List<Propriete> getAllProprietes() ;
    public Optional<Propriete> getProprieteById(Long id)    ;
    public Propriete saveOrUpdatePropriete(Propriete propriete) ;
    public void deleteProprieteById(Long id) ;
    public Optional<Propriete> recupererProprieteParMatricule(String matricule) ;


    boolean existsById(Long id);

    Propriete savePropriete(Propriete propriete);
}
