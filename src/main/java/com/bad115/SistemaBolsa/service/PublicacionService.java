package com.bad115.SistemaBolsa.service;

import com.bad115.SistemaBolsa.entity.Publicacion;

import java.util.List;

public interface PublicacionService {

    public Publicacion save(Publicacion publicacion, Long id);

    public Publicacion getPublicacion(Long id);

    public List<Publicacion> getPublicaciones();

    public List<Publicacion> getPublicacionesByAspirante(Long id);

    public void delete(Long id);

    public Publicacion update(Publicacion publicacion, Long id);

    boolean existById(Long idPublicacion);
}
