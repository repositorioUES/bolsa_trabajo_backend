package com.bad115.SistemaBolsa.service.impl;

import com.bad115.SistemaBolsa.entity.ExperienciaLaboral;
import com.bad115.SistemaBolsa.repository.ExperienciaLaboralRepository;
import com.bad115.SistemaBolsa.service.ExperienciaLaboralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienciaLaboralServiceImpl implements ExperienciaLaboralService {

    @Autowired
    private ExperienciaLaboralRepository experienciaLaboralRepository;

    @Override
    public ExperienciaLaboral save(ExperienciaLaboral experienciaLaboral) {
        return experienciaLaboralRepository.save(experienciaLaboral);
    }

    @Override
    public ExperienciaLaboral getExperienciaLaboral(Long id) {
        return experienciaLaboralRepository.getReferenceById(id);
    }

    @Override
    public List<ExperienciaLaboral> getExperienciasLaborales() {
        return experienciaLaboralRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        experienciaLaboralRepository.deleteById(id);
    }

    @Override
    public ExperienciaLaboral update(ExperienciaLaboral experienciaLaboral, Long id) {
        ExperienciaLaboral el = experienciaLaboralRepository.getReferenceById(id);
        el.setCargo(experienciaLaboral.getCargo());
        el.setFecha_inicio(experienciaLaboral.getFecha_inicio());
        el.setFecha_fin(experienciaLaboral.getFecha_fin());
        el.setFuncion(experienciaLaboral.getFuncion());
        el.setNombre_empresa(experienciaLaboral.getNombre_empresa());
        el.setDireccion_empresa(experienciaLaboral.getDireccion_empresa());
        el.setTelefono_empresa(experienciaLaboral.getTelefono_empresa());
        el.setEmail_empresa(experienciaLaboral.getEmail_empresa());
        return experienciaLaboralRepository.save(el);
    }
}
