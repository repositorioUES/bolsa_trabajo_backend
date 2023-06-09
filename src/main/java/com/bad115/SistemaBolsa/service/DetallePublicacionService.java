package com.bad115.SistemaBolsa.service;

import com.bad115.SistemaBolsa.entity.DetallePublicacion;

import java.util.List;

public interface DetallePublicacionService {

    public DetallePublicacion save(DetallePublicacion detallePublicacion, Long id);

    public DetallePublicacion getDetallePublicacion(Long id);

    public List<DetallePublicacion> getDetallesPublicaciones();

    public List<DetallePublicacion> getDetallePublicacionByPublicacion(Long id);

    public void delete(Long id);

    public DetallePublicacion update(DetallePublicacion detallePublicacion, Long id);

    public boolean existById(Long id);
}
