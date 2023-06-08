package com.bad115.SistemaBolsa.repository;

import com.bad115.SistemaBolsa.entity.ActividadAdicional;
import com.bad115.SistemaBolsa.entity.Aspirante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActividadAdicionalRepository extends JpaRepository<ActividadAdicional, Long> {
    public ActividadAdicional getReferenceById(Long id);

    public List<ActividadAdicional> getByAspirante(Aspirante aspirante);
}
