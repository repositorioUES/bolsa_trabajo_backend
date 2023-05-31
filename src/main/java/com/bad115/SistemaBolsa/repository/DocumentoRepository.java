package com.bad115.SistemaBolsa.repository;

import com.bad115.SistemaBolsa.entity.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long> {
    public Documento getReferenceById(Long id);
}
