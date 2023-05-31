package com.bad115.SistemaBolsa.service.impl;

import com.bad115.SistemaBolsa.entity.ActividadAdicional;
import com.bad115.SistemaBolsa.repository.ActividadAdicionalRepository;
import com.bad115.SistemaBolsa.service.ActividadAdicionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActividadAdicionalServiceImpl implements ActividadAdicionalService {

    @Autowired
    private ActividadAdicionalRepository actividadAdicionalRepository;
    @Override
    public ActividadAdicional save(ActividadAdicional actividadAdicional) {
        return actividadAdicionalRepository.save(actividadAdicional);
    }

    @Override
    public ActividadAdicional getActividadAdicional(Long id) {
        return actividadAdicionalRepository.getReferenceById(id);
    }

    @Override
    public List<ActividadAdicional> getActividadesAdicionales() {
        return actividadAdicionalRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        actividadAdicionalRepository.deleteById(id);
    }

    @Override
    public ActividadAdicional update(ActividadAdicional actividadAdicional, Long id) {
        ActividadAdicional actividadAdicionalActualizada = actividadAdicionalRepository.getReferenceById(id);
        actividadAdicionalActualizada.setDescripcion_actividad(actividadAdicional.getDescripcion_actividad());
        actividadAdicionalActualizada.setNombre_actividad(actividadAdicional.getNombre_actividad());
        actividadAdicionalActualizada.setFecha_inicio(actividadAdicional.getFecha_inicio());
        actividadAdicionalActualizada.setFecha_final(actividadAdicional.getFecha_final());
        return actividadAdicionalRepository.save(actividadAdicionalActualizada);
    }
}
