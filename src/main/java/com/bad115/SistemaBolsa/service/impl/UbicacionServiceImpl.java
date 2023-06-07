package com.bad115.SistemaBolsa.service.impl;

import com.bad115.SistemaBolsa.entity.Ubicacion;
import com.bad115.SistemaBolsa.repository.UbicacionRepository;
import com.bad115.SistemaBolsa.service.UbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UbicacionServiceImpl implements UbicacionService {

    @Autowired
    private UbicacionRepository ubicacionRepository;

    @Override
    public Ubicacion guardarUbicacion(Ubicacion ubicacion) {
        return ubicacionRepository.save(ubicacion);
    }

    @Override
    public Ubicacion obtenerUbicacion(Long id) {
        return ubicacionRepository.getReferenceById(id);
    }

    @Override
    public List<Ubicacion> obtenerUbicaciones() {
        return ubicacionRepository.findAll();
    }

    @Override
    public Ubicacion actualizarUbicacion(Ubicacion ubicacion, Long id) {
        Ubicacion ubicacionLocal = ubicacionRepository.getReferenceById(id);
        ubicacionLocal.setNombre(ubicacion.getNombre());
        ubicacionLocal.setLatitud(ubicacion.getLatitud());
        ubicacionLocal.setLongitud(ubicacion.getLongitud());
        return ubicacionRepository.save(ubicacionLocal);
    }

    @Override
    public void eliminarUbicacion(Long id) {
        ubicacionRepository.deleteById(id);
    }
}
