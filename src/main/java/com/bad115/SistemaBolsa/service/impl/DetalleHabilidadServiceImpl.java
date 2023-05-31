package com.bad115.SistemaBolsa.service.impl;

import com.bad115.SistemaBolsa.entity.DetalleHabilidad;
import com.bad115.SistemaBolsa.repository.DetalleHabilidadRepository;
import com.bad115.SistemaBolsa.service.DetalleHabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleHabilidadServiceImpl implements DetalleHabilidadService {
    @Autowired
    private DetalleHabilidadRepository detalleHabilidadRepository;
    
    @Override
    public DetalleHabilidad save(DetalleHabilidad detalleHabilidad) {
        return detalleHabilidadRepository.save(detalleHabilidad);
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
    public void delete(Long id) {
        detalleHabilidadRepository.deleteById(id);
    }

    @Override
    public DetalleHabilidad update(DetalleHabilidad detalleHabilidad, Long id) {
        DetalleHabilidad detalleHabiliadActualizada = detalleHabilidadRepository.getReferenceById(id);
        detalleHabiliadActualizada.setNombre_habilidad(detalleHabilidad.getNombre_habilidad());
        return detalleHabilidadRepository.save(detalleHabiliadActualizada);
    }
}
