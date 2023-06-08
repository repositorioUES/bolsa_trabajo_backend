package com.bad115.SistemaBolsa.service.impl;

import com.bad115.SistemaBolsa.entity.DetalleHabilidad;
import com.bad115.SistemaBolsa.entity.Habilidad;
import com.bad115.SistemaBolsa.repository.DetalleHabilidadRepository;
import com.bad115.SistemaBolsa.repository.HabilidadRepository;
import com.bad115.SistemaBolsa.service.DetalleHabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleHabilidadServiceImpl implements DetalleHabilidadService {
    @Autowired
    private DetalleHabilidadRepository detalleHabilidadRepository;
    @Autowired
    private HabilidadRepository habilidadRepository;
    
    @Override
    public DetalleHabilidad save(DetalleHabilidad detalleHabilidad, Long id) {
        DetalleHabilidad dh = new DetalleHabilidad();
        dh.setNombre_habilidad(detalleHabilidad.getNombre_habilidad());
        dh.setHabilidad(habilidadRepository.getReferenceById(id));
        return detalleHabilidadRepository.save(dh);
    }

    @Override
    public DetalleHabilidad getDetalleHabilidad(Long id) {
        return detalleHabilidadRepository.getReferenceById(id);
    }

    @Override
    public List<DetalleHabilidad> getDetalleHabilidades() {
        return detalleHabilidadRepository.findAll();
    }

    @Override
    public List<DetalleHabilidad> getDetalleHabilidadByHabilidad(Long id) {
        Habilidad h = habilidadRepository.getReferenceById(id);
        List<DetalleHabilidad> dh = detalleHabilidadRepository.getByHabilidad(h);
        return dh;
    }

    @Override
    public void delete(Long id) {
        detalleHabilidadRepository.deleteById(id);
    }

    @Override
    public DetalleHabilidad update(DetalleHabilidad detalleHabilidad, Long id) {
        DetalleHabilidad dh = detalleHabilidadRepository.getReferenceById(id);
        dh.setNombre_habilidad(detalleHabilidad.getNombre_habilidad());
        return detalleHabilidadRepository.save(dh);
    }

    @Override
    public boolean existById(Long id) {
        return detalleHabilidadRepository.existsById(id);
    }
}
