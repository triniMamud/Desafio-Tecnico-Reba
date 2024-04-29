package com.example.DesafioTecnico.repository;

import com.example.DesafioTecnico.entity.Parentesco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IParentescoRepository extends JpaRepository<Parentesco, Long> {
}
