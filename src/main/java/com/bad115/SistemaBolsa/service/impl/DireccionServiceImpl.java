package com.bad115.SistemaBolsa.service.impl;

import com.bad115.SistemaBolsa.entity.Aspirante;
import com.bad115.SistemaBolsa.entity.Direccion;
import com.bad115.SistemaBolsa.repository.AspiranteRepository;
import com.bad115.SistemaBolsa.repository.DireccionRepository;
import com.bad115.SistemaBolsa.service.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DireccionServiceImpl implements DireccionService {

    @Autowired
    private DireccionRepository direccionRepository;

    @Autowired
    private AspiranteRepository aspiranteRepository;

    @Override
    public Direccion guardarDireccion(Direccion direccion, Long aspiranteId) {
        Aspirante a = aspiranteRepository.getReferenceById(aspiranteId);
        Direccion d = new Direccion();
        d.setPasaje(direccion.getPasaje());
        d.setColonia(direccion.getColonia());
        d.setCalle(direccion.getCalle());
        d.setNumero_casa(direccion.getNumero_casa());
        d.setAspirante(a);
        return direccionRepository.save(d);
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
    public Direccion actualizarDireccion(Direccion direccion, Long id, Long aspiranteId) {
        Aspirante a = aspiranteRepository.getReferenceById(aspiranteId);
        Direccion d = direccionRepository.getReferenceById(id);
        d.setPasaje(direccion.getPasaje());
        d.setColonia(direccion.getColonia());
        d.setCalle(direccion.getCalle());
        d.setNumero_casa(direccion.getNumero_casa());
        d.setAspirante(a);
        return direccionRepository.save(d);
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
