package com.bad115.SistemaBolsa.service;

import com.bad115.SistemaBolsa.entity.AspiranteHabilidad;

import java.util.List;

public interface AspiranteHabilidadService {

    public AspiranteHabilidad save(Long idA, Long idH);

    public List<AspiranteHabilidad> getAspiranteHabilidadByAspirante(Long id);

    List<AspiranteHabilidad> getAspiranteHabilidadByHabilidad(Long id);

    public void delete(Long idA, Long idH);

}
