package com.bad115.SistemaBolsa.repository;

import com.bad115.SistemaBolsa.entity.Aspirante;
import com.bad115.SistemaBolsa.entity.AspiranteHabilidad;
import com.bad115.SistemaBolsa.entity.Habilidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AspiranteHabilidadRepository extends JpaRepository<AspiranteHabilidad, Long> {

    public List<AspiranteHabilidad> getByAspirante(Aspirante aspirante);

    public List<AspiranteHabilidad> getByHabilidad(Habilidad habilidad);

    public AspiranteHabilidad findByAspiranteAndHabilidad(Aspirante aspirante,Habilidad habilidad);
}
