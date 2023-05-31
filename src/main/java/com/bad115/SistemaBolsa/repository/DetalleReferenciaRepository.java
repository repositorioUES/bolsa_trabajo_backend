package com.bad115.SistemaBolsa.repository;


import com.bad115.SistemaBolsa.entity.DetalleReferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleReferenciaRepository extends JpaRepository<DetalleReferencia, Long> {
    public DetalleReferencia getReferenceById(Long id);
}
