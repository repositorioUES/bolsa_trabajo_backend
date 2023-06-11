package com.bad115.SistemaBolsa.service;

import com.bad115.SistemaBolsa.entity.ConocimientoAcademico;

import java.util.List;


public interface ConocimientoAcademicoService {
    public ConocimientoAcademico guardarConocimiento(ConocimientoAcademico conocimientoAcademico, Long aspiranteId);

    public ConocimientoAcademico obtenerConocimiento(Long id);

    public List<ConocimientoAcademico> obtenerConocimientos();

    public ConocimientoAcademico agregarInstitucion(Long conocimientoId, Long institucionId);

    public ConocimientoAcademico actualizarConocmiento(ConocimientoAcademico conocimientoAcademico, Long id, Long aspiranteId);

    public void eliminarConocimiento(Long id);
}
