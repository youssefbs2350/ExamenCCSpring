package com.example.examenccspring.Repositories;

import com.example.examenccspring.Entities.Declaration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Date;

@Repository
public interface DeclarationRepo extends JpaRepository<Declaration, Long> {
    List<Declaration> findByDateDeclarationBeforeAndEstTraiteeFalse(Date date);


    List<Declaration> findByEstTraitee(boolean b);

    List<Declaration> findByEstTraiteeFalse();

    List<Declaration> findByEstTraiteeTrue();
}