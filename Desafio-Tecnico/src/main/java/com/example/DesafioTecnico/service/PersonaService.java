package com.example.DesafioTecnico.service;

import com.example.DesafioTecnico.dto.request.PersonaParentescoResponse;
import com.example.DesafioTecnico.dto.request.PersonaRequest;
import com.example.DesafioTecnico.dto.response.PersonaResponse;
import com.example.DesafioTecnico.entity.Parentesco;
import com.example.DesafioTecnico.entity.Persona;
import com.example.DesafioTecnico.entity.PersonaParentesco;
import com.example.DesafioTecnico.exception.exceptions.ParentescoNotFoundException;
import com.example.DesafioTecnico.exception.exceptions.PersonaAlreadyExistsException;
import com.example.DesafioTecnico.exception.exceptions.PersonaNotFoundException;
import com.example.DesafioTecnico.repository.IParentescoRepository;
import com.example.DesafioTecnico.repository.IPersonaParentescoRepository;
import com.example.DesafioTecnico.repository.IPersonaRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonaService {

    private IPersonaRepository personaRepository;
    private IPersonaParentescoRepository personaParentescoRepository;
    private IParentescoRepository parentescoRepository;
    private ModelMapper modelMapper;

    public PersonaResponse create(PersonaRequest request) {
        if (personaRepository.existsByTipoDocumentoAndNumeroDocumentoAndPais(request.getTipoDocumento().ordinal(), request.getNumeroDocumento(), request.getPais()))
            throw new PersonaAlreadyExistsException("La persona ingresada ya existe");

        return modelMapper.map(personaRepository.save(Persona.builder()
                        .tipoDocumento(request.getTipoDocumento())
                        .numeroDocumento(request.getNumeroDocumento())
                        .pais(request.getPais())
                        .email(request.getEmail())
                        .numeroTelefonico(request.getNumeroTelefonico())
                        .edad(request.getEdad())
                        .relaciones(new ArrayList<>())
                        .build()), PersonaResponse.class);
    }

    public PersonaResponse readPersona(Long id) {
        return modelMapper.map(personaRepository.findById(id).orElseThrow(PersonaNotFoundException::new), PersonaResponse.class);
    }

    public PersonaResponse updatePersona(Long id, PersonaRequest request) {
        if (!personaRepository.existsById(id))
            throw new PersonaNotFoundException("La persona a modificar no existe");

        Persona personaToUpdate = personaRepository.getReferenceById(id);
        personaToUpdate.setTipoDocumento(request.getTipoDocumento());
        personaToUpdate.setNumeroDocumento(request.getNumeroDocumento());
        personaToUpdate.setPais(request.getPais());

        return modelMapper.map(personaRepository.save(personaToUpdate), PersonaResponse.class);
    }

    public void deletePersona(Long id) {
        if (!personaRepository.existsById(id))
            throw new PersonaNotFoundException("La persona a eliminar no existe");

        personaRepository.deleteById(id);
    }

    public void relatePersonas(Long id1, Long id2) {
        if (!personaRepository.existsById(id1) || !personaRepository.existsById(id2))
            throw new PersonaNotFoundException("Alguna de las personas a relacionar no existe");

        Persona padre = personaRepository.getReferenceById(id1);
        Persona hijo = personaRepository.getReferenceById(id2);

        padre.getRelaciones().add(PersonaParentesco.builder()
                .persona(padre)
                .personaRelacionada(hijo)
                .parentesco(Parentesco.builder().id(1).descripcion("PADRE").build()).build());
        hijo.getRelaciones().add(PersonaParentesco.builder()
                .persona(hijo)
                .personaRelacionada(padre)
                .parentesco(Parentesco.builder().id(2).descripcion("HIJ@").build()).build());

        personaRepository.save(padre);
        personaRepository.save(hijo);
    }

    public PersonaParentescoResponse readParentescosPersonas(Long id1, Long id2) {
        PersonaParentesco personaParentesco = personaParentescoRepository.findParentescoBetweenPersonas(id1, id2).orElseThrow(ParentescoNotFoundException::new);
        return PersonaParentescoResponse.builder()
                .parentesco(parentescoRepository.findById(personaParentesco.getParentesco().getId()).get().getDescripcion())
                .build();
    }
}
