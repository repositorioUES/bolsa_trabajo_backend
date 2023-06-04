package com.bad115.SistemaBolsa.service;

import com.bad115.SistemaBolsa.entity.Aspirante;
import com.bad115.SistemaBolsa.entity.Direccion;

import java.util.List;


public interface DireccionService {

    public Direccion guardarDireccion(Direccion direccion);

    public Direccion obtenerDireccion(Long id);

    public List<Direccion> obtenerDirecciones();

    public Direccion actualizarDireccion(Direccion direccion, Long id);

    public Direccion actualizarDireccion(Direccion direccion, Aspirante aspirante);

    public void eliminarDireccion(Long id);

    public void eliminarDireccion(Aspirante aspirante);
}
