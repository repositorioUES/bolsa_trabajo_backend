package com.bad115.SistemaBolsa.service.impl;

import com.bad115.SistemaBolsa.entity.Oferta;
import com.bad115.SistemaBolsa.entity.Ubicacion;
import com.bad115.SistemaBolsa.repository.OfertaRepository;
import com.bad115.SistemaBolsa.repository.UbicacionRepository;
import com.bad115.SistemaBolsa.service.UbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UbicacionServiceImpl implements UbicacionService {

    @Autowired
    private UbicacionRepository ubicacionRepository;

    @Autowired
    public OfertaRepository ofertaRepository;

    @Override
    public Ubicacion guardarUbicacion(Ubicacion ubicacion, Long ofertaId) {
        Oferta o = ofertaRepository.getReferenceById(ofertaId);
        Ubicacion u = new Ubicacion();
        u.setLongitud(ubicacion.getLongitud());
        u.setLatitud(ubicacion.getLatitud());
        u.setNombre(ubicacion.getNombre());
        u.setOferta(o);
        return ubicacionRepository.save(u);
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
    public Ubicacion actualizarUbicacion(Ubicacion ubicacion, Long id, Long ofertaId) {
        Oferta o = ofertaRepository.getReferenceById(ofertaId);
        Ubicacion u = ubicacionRepository.getReferenceById(id);
        u.setLongitud(ubicacion.getLongitud());
        u.setLatitud(ubicacion.getLatitud());
        u.setNombre(ubicacion.getNombre());
        u.setOferta(o);
        return ubicacionRepository.save(u);
    }

    @Override
    public void eliminarUbicacion(Long id) {
        ubicacionRepository.deleteById(id);
    }
}
