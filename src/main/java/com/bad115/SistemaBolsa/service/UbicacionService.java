package com.bad115.SistemaBolsa.service;

import com.bad115.SistemaBolsa.entity.Oferta;
import com.bad115.SistemaBolsa.entity.Ubicacion;

import java.util.List;


public interface UbicacionService {
    public Ubicacion guardarUbicacion(Ubicacion ubicacion, Long ofertaId);

    public Ubicacion obtenerUbicacion(Long id);

    public List<Ubicacion> obtenerUbicaciones();

    public Ubicacion actualizarUbicacion(Ubicacion ubicacion, Long id, Long ofertaId);

    public void eliminarUbicacion(Long id);

}
