package com.example.examenccspring.Repositories;

import com.example.examenccspring.Entities.Propriete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProprieteRepo extends JpaRepository<Propriete, Long> {
}