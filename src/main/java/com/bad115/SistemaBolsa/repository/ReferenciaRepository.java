package com.bad115.SistemaBolsa.repository;

import com.bad115.SistemaBolsa.entity.Referencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReferenciaRepository extends JpaRepository<Referencia, Long> {
    public Referencia getReferenceById(Long id);
}
