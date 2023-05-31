package com.bad115.SistemaBolsa.service;

import com.bad115.SistemaBolsa.entity.Publicacion;

import java.util.List;

public interface PublicacionService {

    public Publicacion save(Publicacion publicacion);

    public Publicacion getPublicacion(Long id);

    public List<Publicacion> getPublicaciones();

    public void delete(Long id);

    public Publicacion update(Publicacion publicacion, Long id);
}
