package com.bad115.SistemaBolsa.repository;

import com.bad115.SistemaBolsa.entity.ExperienciaLaboral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaLaboralRepository extends JpaRepository<ExperienciaLaboral, Long> {
    public ExperienciaLaboral getReferenceById(Long id);
}
