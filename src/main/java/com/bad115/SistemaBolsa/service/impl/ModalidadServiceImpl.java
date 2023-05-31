package com.bad115.SistemaBolsa.service.impl;

import com.bad115.SistemaBolsa.entity.Modalidad;
import com.bad115.SistemaBolsa.repository.ModalidadRepository;
import com.bad115.SistemaBolsa.service.ModalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModalidadServiceImpl implements ModalidadService {

    @Autowired
    private ModalidadRepository modalidadRepository;

    @Override
    public Modalidad guardarModalidad(Modalidad modalidad) {
        return modalidadRepository.save(modalidad);
    }

    @Override
    public Modalidad obtenerModalidad(Long id) {
        return modalidadRepository.getReferenceById(id);
    }

    @Override
    public List<Modalidad> obtenerModalidades() {
        return modalidadRepository.findAll();
    }

    @Override
    public Modalidad actualizarModalidad(Modalidad modalidad, Long id) {
        Modalidad modalidadLocal = modalidadRepository.getReferenceById(id);
        modalidadLocal.setNombre(modalidad.getNombre());
        modalidadLocal.setOfertas(modalidad.getOfertas());
        return modalidadRepository.save(modalidadLocal);
    }

    @Override
    public void eliminarModalidad(Long id) {
        modalidadRepository.deleteById(id);
    }
}
