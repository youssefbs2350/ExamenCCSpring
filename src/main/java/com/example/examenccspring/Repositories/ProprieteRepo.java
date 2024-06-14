package com.example.examenccspring.Repositories;

import com.example.examenccspring.Entities.Propriete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProprieteRepo extends JpaRepository<Propriete, Long> {
    Optional<Propriete> findByMatricule(String matricule);
    List<Propriete> findAll();
    Propriete save(Propriete propriete);
    void deleteById(Long id);
}
