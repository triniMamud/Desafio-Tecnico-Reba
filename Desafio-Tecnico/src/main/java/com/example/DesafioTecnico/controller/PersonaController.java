package com.example.DesafioTecnico.controller;

import com.example.DesafioTecnico.dto.request.PersonaParentescoResponse;
import com.example.DesafioTecnico.dto.request.PersonaRequest;
import com.example.DesafioTecnico.dto.response.PersonaResponse;
import com.example.DesafioTecnico.service.PersonaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;


@RestController
@RequestMapping("/personas")
@RequiredArgsConstructor
public class PersonaController {

    private final PersonaService personaService;

    @PostMapping
    public ResponseEntity<PersonaResponse> create(@RequestBody @Valid PersonaRequest request) {
        return new ResponseEntity<>(personaService.create(request), CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonaResponse> readPersona(@PathVariable(name = "id") Long id) {
        return ok(personaService.readPersona(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonaResponse> updatePersona(@PathVariable(name = "id") Long id, @RequestBody @Valid PersonaRequest request) {
        return ok(personaService.updatePersona(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersona(@PathVariable(name = "id") Long id) {
        personaService.deletePersona(id);
        return noContent().build();
    }

    @PostMapping("/{id1}/padre/{id2}")
    public ResponseEntity<Void> relatePersonas(@PathVariable(name = "id1") Long id1, @PathVariable(name = "id2") Long id2) {
        personaService.relatePersonas(id1, id2);
        return noContent().build();
    }

    @GetMapping("/relaciones/{id1}/{id2}")
    public ResponseEntity<PersonaParentescoResponse> readParentescosPersonas(@PathVariable(name = "id1") Long id1, @PathVariable(name = "id2") Long id2) {
        personaService.readParentescosPersonas(id1, id2);
        return noContent().build();
    }
}
