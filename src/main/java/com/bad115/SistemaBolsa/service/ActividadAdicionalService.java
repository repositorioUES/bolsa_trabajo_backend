package com.bad115.SistemaBolsa.service;

import com.bad115.SistemaBolsa.entity.ActividadAdicional;

import java.util.List;

public interface ActividadAdicionalService {

    public ActividadAdicional save(ActividadAdicional actividadAdicional, Long id);

    public ActividadAdicional getActividadAdicional(Long id);

    public List<ActividadAdicional> getActividadesAdicionales();

    public List<ActividadAdicional> getActividadAdicionalByAspirante(Long id);

    public void delete(Long id);

    public ActividadAdicional update(ActividadAdicional actividadAdicional, Long id);

    public boolean existById(Long id);
}
