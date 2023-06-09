package com.bad115.SistemaBolsa.repository;

import com.bad115.SistemaBolsa.entity.DetalleReferencia;
import com.bad115.SistemaBolsa.entity.Referencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleReferenciaRepository extends JpaRepository<DetalleReferencia, Long> {
    public DetalleReferencia getReferenceById(Long id);

    public List<DetalleReferencia> getByReferencia(Referencia referencia);
}
