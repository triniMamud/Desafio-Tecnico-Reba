package com.example.DesafioTecnico.repository;

import com.example.DesafioTecnico.dto.PersonasByPaisPercentageStatsDTO;
import com.example.DesafioTecnico.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Long> {

    boolean existsByTipoDocumentoAndNumeroDocumentoAndPais(int tipoDocumento, String numDocumento, String pais);
    @Query("SELECT new com.example.DesafioTecnico.dto.CountryPercentageDTO(p.pais, COUNT(p)) FROM Persona p GROUP BY p.pais")
    List<PersonasByPaisPercentageStatsDTO> countTotalPersonasByCountry();

}
