package com.bad115.SistemaBolsa.service;

import com.bad115.SistemaBolsa.entity.DetalleHabilidad;

import java.util.List;

public interface DetalleHabilidadService {

    public DetalleHabilidad save(DetalleHabilidad detalleHabilidad, Long id);

    public DetalleHabilidad getDetalleHabilidad(Long id);

    public List<DetalleHabilidad> getDetalleHabilidades();

    public List<DetalleHabilidad> getDetalleHabilidadByHabilidad(Long id);

    public void delete(Long id);

    public DetalleHabilidad update(DetalleHabilidad detalleHabilidad, Long id);

    public boolean existById(Long id);
}
