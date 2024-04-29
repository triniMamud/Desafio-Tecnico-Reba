package com.example.DesafioTecnico.controller;

import com.example.DesafioTecnico.dto.PersonasByPaisPercentageStatsDTO;
import com.example.DesafioTecnico.dto.response.PersonasByPaisPercentageStatsResponse;
import com.example.DesafioTecnico.service.StatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/stats")
@RequiredArgsConstructor
public class StatsController {

    private final StatsService statsService;

    @GetMapping
    public ResponseEntity<List<PersonasByPaisPercentageStatsResponse>> getPersonasByPais() {
        return ok(statsService.getPersonasByPais());
    }
}
