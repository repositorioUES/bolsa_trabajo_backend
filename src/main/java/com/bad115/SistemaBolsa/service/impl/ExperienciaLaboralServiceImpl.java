package com.bad115.SistemaBolsa.service.impl;

import com.bad115.SistemaBolsa.entity.Aspirante;
import com.bad115.SistemaBolsa.entity.ExperienciaLaboral;
import com.bad115.SistemaBolsa.repository.AspiranteRepository;
import com.bad115.SistemaBolsa.repository.ExperienciaLaboralRepository;
import com.bad115.SistemaBolsa.service.ExperienciaLaboralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienciaLaboralServiceImpl implements ExperienciaLaboralService {

    @Autowired
    private ExperienciaLaboralRepository experienciaLaboralRepository;
    @Autowired
    private AspiranteRepository aspiranteRepository;

    @Override
    public ExperienciaLaboral save(ExperienciaLaboral experienciaLaboral, Long id) {
        ExperienciaLaboral el = new ExperienciaLaboral();
        el.setCargo(experienciaLaboral.getCargo());
        el.setFecha_inicio(experienciaLaboral.getFecha_inicio());
        el.setFecha_fin(experienciaLaboral.getFecha_fin());
        el.setFuncion(experienciaLaboral.getFuncion());
        el.setNombre_empresa(experienciaLaboral.getNombre_empresa());
        el.setDireccion_empresa(experienciaLaboral.getDireccion_empresa());
        el.setTelefono_empresa(experienciaLaboral.getTelefono_empresa());
        el.setEmail_empresa(experienciaLaboral.getEmail_empresa());
        el.setAspirante(aspiranteRepository.getReferenceById(id));
        return experienciaLaboralRepository.save(el);
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
    public List<ExperienciaLaboral> getExperienciaLaboralByAspirante(Long id) {
        Aspirante a = aspiranteRepository.getReferenceById(id);
        List<ExperienciaLaboral> el = experienciaLaboralRepository.getByAspirante(a);
        return el;
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

    @Override
    public boolean existById(Long id) {
        return experienciaLaboralRepository.existsById(id);
    }
}
