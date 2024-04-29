package com.example.DesafioTecnico.repository;

import com.example.DesafioTecnico.entity.Parentesco;
import com.example.DesafioTecnico.entity.PersonaParentesco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPersonaParentescoRepository extends JpaRepository<PersonaParentesco, Long> {

    @Query("SELECT pp.parentesco FROM PersonaParentesco pp WHERE (pp.persona.id = :id1 AND pp.personaRelacionada.id = :id2)")
    Optional<PersonaParentesco> findParentescoBetweenPersonas(Long id1, Long id2);
}
