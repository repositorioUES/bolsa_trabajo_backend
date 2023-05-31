package com.bad115.SistemaBolsa.repository;

import com.bad115.SistemaBolsa.entity.ActividadAdicional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActividadAdicionalRepository extends JpaRepository<ActividadAdicional, Long> {
    public ActividadAdicional getReferenceById(Long id);
}
