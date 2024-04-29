package com.example.DesafioTecnico.dto.response;

import com.example.DesafioTecnico.entity.PersonaParentesco;
import com.example.DesafioTecnico.enums.TipoDocumentoEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class PersonaResponse {

    private String tipoDocumento;
    private String numeroDocumento;
    private String pais;
    private String email;
    private long numeroTelefonico;
    private int edad;
    private List<PersonaParentesco> relaciones;
}
