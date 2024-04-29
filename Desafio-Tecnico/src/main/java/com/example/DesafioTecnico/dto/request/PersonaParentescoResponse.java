package com.example.DesafioTecnico.dto.request;

import com.example.DesafioTecnico.entity.Parentesco;
import com.example.DesafioTecnico.entity.Persona;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonaParentescoResponse {

    private String parentesco;
}
