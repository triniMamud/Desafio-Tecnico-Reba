package com.example.DesafioTecnico.entity;

import com.example.DesafioTecnico.enums.TipoDocumentoEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import static jakarta.persistence.FetchType.*;

@Data
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Persona {

    @Id
    private long id;
    @EqualsAndHashCode.Include private TipoDocumentoEnum tipoDocumento;
    @EqualsAndHashCode.Include private String numeroDocumento;
    @EqualsAndHashCode.Include private String pais;
    private String email;
    private long numeroTelefonico;
    private int edad;

    @OneToMany(mappedBy = "persona", fetch = LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PersonaParentesco> relaciones;
}
