package com.example.DesafioTecnico.dto.request;

import com.example.DesafioTecnico.customValidators.ValidContactInfo;
import com.example.DesafioTecnico.enums.TipoDocumentoEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@ValidContactInfo
public class PersonaRequest {

    @NotNull
    private TipoDocumentoEnum tipoDocumento;

    @NotBlank
    private String numeroDocumento;

    @NotBlank
    private String pais;

    @Email
    private String email;

    private long numeroTelefonico;

    @Min(value = 18, message = "La persona debe tener al menos 18 años")
    private int edad;
}
