package com.example.examenccspring.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String adresse;
    private String telephone;

    @Enumerated(EnumType.STRING)
    private Role role;

    // Getters and setters
    @Getter
    @OneToMany(mappedBy = "victime")
    @JsonIgnore
    private List<Declaration> declarationsVictime;

    @Getter
    @OneToMany(mappedBy = "policier")
    @JsonIgnore
    private List<Declaration> declarationsPolicier;

    public void setDeclarationsVictime(List<Declaration> declarationsVictime) {
        this.declarationsVictime = declarationsVictime;
    }

    public void setDeclarationsPolicier(List<Declaration> declarationsPolicier) {
        this.declarationsPolicier = declarationsPolicier;
    }
}


