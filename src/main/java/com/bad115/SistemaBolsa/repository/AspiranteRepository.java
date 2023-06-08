package com.bad115.SistemaBolsa.repository;

import com.bad115.SistemaBolsa.entity.Aspirante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AspiranteRepository extends JpaRepository<Aspirante, Long> {
















    public Aspirante getReferenceById(Long id);
}
