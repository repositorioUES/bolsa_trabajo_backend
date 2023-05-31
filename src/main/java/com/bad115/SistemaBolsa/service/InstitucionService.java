package com.bad115.SistemaBolsa.service;

import com.bad115.SistemaBolsa.entity.Institucion;

import java.util.List;


public interface InstitucionService {
    public Institucion guardarInstitucion(Institucion institucion);

    public Institucion obtenerInstitucion(Long id);

    public List<Institucion> obtenerInstituciones();

    public Institucion actualizarInstitucion(Institucion institucion, Long id);

    public void eliminarInstitucion(Long id);
}
