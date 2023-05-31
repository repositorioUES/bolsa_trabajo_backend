package com.bad115.SistemaBolsa.service.impl;

import com.bad115.SistemaBolsa.entity.Institucion;
import com.bad115.SistemaBolsa.repository.InstitucionRepository;
import com.bad115.SistemaBolsa.service.InstitucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstitucionServiceImpl implements InstitucionService {
    @Autowired
    private InstitucionRepository institucionRepository;

    @Override
    public Institucion guardarInstitucion(Institucion institucion) {
        return institucionRepository.save(institucion);
    }

    @Override
    public Institucion obtenerInstitucion(Long id) {
        return institucionRepository.getReferenceById(id);
    }

    @Override
    public List<Institucion> obtenerInstituciones() {
        return institucionRepository.findAll();
    }

    @Override
    public Institucion actualizarInstitucion(Institucion institucion, Long id) {
        Institucion institucionLocal = institucionRepository.getReferenceById(id);
        institucionLocal.setNombre(institucion.getNombre());
        institucionLocal.setConocimientos_academicos(institucion.getConocimientos_academicos());
        return institucionRepository.save(institucionLocal);
    }

    @Override
    public void eliminarInstitucion(Long id) {
        institucionRepository.deleteById(id);
    }
}
