package com.example.DesafioTecnico.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonasByPaisPercentageStatsResponse {

    private String country;
    private double percentage;
}
