package com.example.DesafioTecnico.service;

import com.example.DesafioTecnico.dto.PersonasByPaisPercentageStatsDTO;
import com.example.DesafioTecnico.dto.response.PersonasByPaisPercentageStatsResponse;
import com.example.DesafioTecnico.repository.IPersonaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class StatsService {

    private final IPersonaRepository personaRepository;

    public List<PersonasByPaisPercentageStatsResponse> getPersonasByPais() {
        List<PersonasByPaisPercentageStatsDTO> countByCountries = personaRepository.countTotalPersonasByCountry();
        long total = personaRepository.count();
        List<PersonasByPaisPercentageStatsResponse> response = new ArrayList<>();

        countByCountries.forEach(result ->
                response.add(PersonasByPaisPercentageStatsResponse.builder()
                                .country(result.getCountry())
                                .percentage(result.getCount() / total * 100)
                                .build()
                ));
        return response;
    }
}
