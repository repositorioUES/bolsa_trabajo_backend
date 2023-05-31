package com.bad115.SistemaBolsa.service;

import com.bad115.SistemaBolsa.entity.Modalidad;

import java.util.List;


public interface ModalidadService {

    public Modalidad guardarModalidad(Modalidad modalidad);

    public Modalidad obtenerModalidad(Long id);

    public List<Modalidad> obtenerModalidades();

    public Modalidad actualizarModalidad(Modalidad modalidad, Long id);

    public void eliminarModalidad(Long id);
}
