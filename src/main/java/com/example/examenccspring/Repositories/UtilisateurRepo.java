package com.example.examenccspring.Repositories;

import com.example.examenccspring.Entities.Role;
import com.example.examenccspring.Entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepo extends JpaRepository<Utilisateur, Long> {


    Utilisateur findByTelephone(String telephone);


    Utilisateur findByTelephoneAndRole(String telephone, Role role);

    Utilisateur findByIdAndRole(long idUtilisateur, Role role);
}
