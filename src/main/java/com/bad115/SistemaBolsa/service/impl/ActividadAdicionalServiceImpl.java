package com.bad115.SistemaBolsa.service.impl;

import com.bad115.SistemaBolsa.entity.ActividadAdicional;
import com.bad115.SistemaBolsa.entity.Aspirante;
import com.bad115.SistemaBolsa.repository.ActividadAdicionalRepository;
import com.bad115.SistemaBolsa.repository.AspiranteRepository;
import com.bad115.SistemaBolsa.service.ActividadAdicionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActividadAdicionalServiceImpl implements ActividadAdicionalService {

    @Autowired
    private ActividadAdicionalRepository actividadAdicionalRepository;
    @Autowired
    private AspiranteRepository aspiranteRepository;

    @Override
    public ActividadAdicional save(ActividadAdicional actividadAdicional, Long id) {
        ActividadAdicional aa = new ActividadAdicional();
        aa.setNombre_actividad(actividadAdicional.getNombre_actividad());
        aa.setDescripcion_actividad(actividadAdicional.getDescripcion_actividad());
        aa.setFecha_inicio(actividadAdicional.getFecha_inicio());
        aa.setFecha_final(actividadAdicional.getFecha_final());
        aa.setAspirante(aspiranteRepository.getReferenceById(id));
        return actividadAdicionalRepository.save(aa);
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
    public List<ActividadAdicional> getActividadAdicionalByAspirante(Long id) {
        Aspirante a = aspiranteRepository.getReferenceById(id);
        List<ActividadAdicional> aa = actividadAdicionalRepository.getByAspirante(a);
        return aa;
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

    @Override
    public boolean existById(Long id) {
        return actividadAdicionalRepository.existsById(id);
    }
}
