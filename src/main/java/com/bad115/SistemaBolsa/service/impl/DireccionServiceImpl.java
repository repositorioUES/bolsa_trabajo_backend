package com.bad115.SistemaBolsa.service.impl;

import com.bad115.SistemaBolsa.entity.Aspirante;
import com.bad115.SistemaBolsa.entity.Direccion;
import com.bad115.SistemaBolsa.repository.DireccionRepository;
import com.bad115.SistemaBolsa.service.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DireccionServiceImpl implements DireccionService {

    @Autowired
    private DireccionRepository direccionRepository;

    @Override
    public Direccion guardarDireccion(Direccion direccion) {
        return direccionRepository.save(direccion);
    }

    @Override
    public Direccion obtenerDireccion(Long id) {
        return direccionRepository.getReferenceById(id);
    }

    @Override
    public List<Direccion> obtenerDirecciones() {
        return direccionRepository.findAll();
    }

    @Override
    public Direccion actualizarDireccion(Direccion direccion, Long id) {
        Direccion direccionLocal = direccionRepository.getReferenceById(id);
        direccionLocal.setCalle(direccion.getCalle());
        direccionLocal.setColonia(direccion.getColonia());
        direccionLocal.setNumero_casa(direccion.getNumero_casa());
        direccionLocal.setPasaje(direccion.getPasaje());
        direccionLocal.setAspirante(direccion.getAspirante());
        return direccionRepository.save(direccionLocal);
    }

    @Override
    public Direccion actualizarDireccion(Direccion direccion, Aspirante aspirante) {
        Direccion direccionLocal = direccionRepository.findByAspirante(aspirante);
        direccionLocal.setCalle(direccion.getCalle());
        direccionLocal.setColonia(direccion.getColonia());
        direccionLocal.setNumero_casa(direccion.getNumero_casa());
        direccionLocal.setPasaje(direccion.getPasaje());
        direccionLocal.setAspirante(direccion.getAspirante());
        return direccionRepository.save(direccionLocal);
    }

    @Override
    public void eliminarDireccion(Long id) {
        direccionRepository.deleteById(id);
    }

    @Override
    public void eliminarDireccion(Aspirante aspirante) {
        direccionRepository.deleteByAspirante(aspirante);
    }
}
