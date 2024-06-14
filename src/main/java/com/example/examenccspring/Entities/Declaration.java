package com.example.examenccspring.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Declaration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dateDeclaration;
    private String description;
    private boolean estTraitee;
    private LocalDate dateTraitement;

    @ManyToOne
    @JsonIgnore
    private Utilisateur victime;

    @ManyToOne
    @JsonIgnore
    private Utilisateur policier;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Propriete propriete;

}