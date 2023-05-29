package com.bad115.SistemaBolsa.repository;

import com.bad115.SistemaBolsa.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    public Empresa getReferenceById(Long id);
}
