package com.bad115.SistemaBolsa.service;

import com.bad115.SistemaBolsa.entity.Genero;

import java.util.List;


public interface GeneroService {
    public Genero guardarGenero(Genero genero) throws Exception;

    public Genero obtenerGenero(Long id);

    public List<Genero> obtenerGeneros();

    public Genero actualizarGenero(Genero genero, Long id);

    public void eliminarGenero(Long id);
}
