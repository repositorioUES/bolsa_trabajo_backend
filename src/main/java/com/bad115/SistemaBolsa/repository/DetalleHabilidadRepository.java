package com.bad115.SistemaBolsa.repository;

import com.bad115.SistemaBolsa.entity.DetalleHabilidad;
import com.bad115.SistemaBolsa.entity.Habilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleHabilidadRepository extends JpaRepository<DetalleHabilidad, Long> {
    public DetalleHabilidad getReferenceById(Long id);

    public List<DetalleHabilidad> getByHabilidad(Habilidad habilidad);

}
