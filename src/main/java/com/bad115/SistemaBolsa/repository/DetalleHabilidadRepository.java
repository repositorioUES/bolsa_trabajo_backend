package com.bad115.SistemaBolsa.repository;

import com.bad115.SistemaBolsa.entity.DetalleHabilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleHabilidadRepository extends JpaRepository<DetalleHabilidad, Long> {
    public DetalleHabilidad getReferenceById(Long id);
}
