package com.example.DesafioTecnico.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonaParentesco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_persona_relacionada")
    private Persona personaRelacionada;

    @ManyToOne
    @JoinColumn(name = "id_parentesco")
    private Parentesco parentesco;
}
