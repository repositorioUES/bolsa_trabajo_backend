package com.bad115.SistemaBolsa.repository;

import com.bad115.SistemaBolsa.entity.DetallePublicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePublicacionRepository extends JpaRepository<DetallePublicacion, Long> {
    public DetallePublicacion getReferenceById(Long id);
}
