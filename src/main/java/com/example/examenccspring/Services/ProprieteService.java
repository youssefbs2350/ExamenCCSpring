package com.example.examenccspring.Services;

import com.example.examenccspring.Entities.Propriete;
import com.example.examenccspring.Repositories.ProprieteRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProprieteService implements IProprieteService {

    private final ProprieteRepo proprieteRepo;

    public ProprieteService(ProprieteRepo proprieteRepo) {
        this.proprieteRepo = proprieteRepo;
    }

    @Override
    public List<Propriete> getAllProprietes() {
        return proprieteRepo.findAll();
    }

    @Override
    public Optional<Propriete> getProprieteById(Long id) {
        return proprieteRepo.findById(id);
    }
@Override
    public Propriete saveOrUpdatePropriete(Propriete propriete) {
        if (proprieteRepo.existsById(propriete.getId())) {
            return proprieteRepo.save(propriete);
        } else {
            throw new IllegalArgumentException("Propriete with ID " + propriete.getId() + " does not exist.");
        }
    }

    @Override
    public Propriete savePropriete(Propriete propriete) {
        return proprieteRepo.save(propriete);
    }

    @Override
    public void deleteProprieteById(Long id) {
        proprieteRepo.deleteById(id);
    }

    @Override
    public Optional<Propriete> recupererProprieteParMatricule(String matricule) {
        return proprieteRepo.findByMatricule(matricule);
    }

    @Override
    public boolean existsById(Long id) {
        return proprieteRepo.existsById(id);
    }
}

