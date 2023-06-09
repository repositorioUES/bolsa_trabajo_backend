package com.bad115.SistemaBolsa.service;

import com.bad115.SistemaBolsa.entity.DetalleHabilidad;
import com.bad115.SistemaBolsa.entity.Habilidad;

import java.util.List;

public interface HabilidadService {

    public Habilidad save(Habilidad habilidad);

    public Habilidad getHabilidad(Long id);

    public List<Habilidad> getHabilidades();

    public void delete(Long id);

    public Habilidad update(Habilidad habilidad, Long id);

    public boolean existById(Long id);

    public List<DetalleHabilidad> getDetalleHabilidades(Long id);
}
