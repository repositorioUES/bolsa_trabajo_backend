package com.bad115.SistemaBolsa.repository;

import com.bad115.SistemaBolsa.entity.Habilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabilidadRepository extends JpaRepository<Habilidad, Long> {
    public Habilidad getReferenceById(Long id);

}

