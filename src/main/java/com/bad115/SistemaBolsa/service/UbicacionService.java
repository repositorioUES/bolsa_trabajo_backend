package com.bad115.SistemaBolsa.service;

import com.bad115.SistemaBolsa.entity.Oferta;
import com.bad115.SistemaBolsa.entity.Ubicacion;

import java.util.List;


public interface UbicacionService {
    public Ubicacion guardarUbicacion(Ubicacion ubicacion);

    public Ubicacion obtenerUbicacion(Long id);

    public Ubicacion obtenerUbicacion(Oferta oferta);

    public List<Ubicacion> obtenerUbicaciones();

    public Ubicacion actualizarUbicacion(Ubicacion ubicacion, Long id);

    public void eliminarUbicacion(Long id);

}
