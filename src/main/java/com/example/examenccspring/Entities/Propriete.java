package com.example.examenccspring.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Propriete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TypePropriete typePropriete;

    private String couleur;
    private String marque;
    private String matricule;

    @OneToOne(mappedBy = "propriete")
    @JsonIgnore
    private Declaration declaration;

}
