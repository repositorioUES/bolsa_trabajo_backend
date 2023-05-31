package com.bad115.SistemaBolsa.service;

import com.bad115.SistemaBolsa.entity.ExperienciaLaboral;

import java.util.List;

public interface ExperienciaLaboralService {

    public ExperienciaLaboral save(ExperienciaLaboral experienciaLaboral);

    public ExperienciaLaboral getExperienciaLaboral(Long id);

    public List<ExperienciaLaboral> getExperienciasLaborales();

    public void delete(Long id);

    public ExperienciaLaboral update(ExperienciaLaboral experienciaLaboral, Long id);
}
