package com.bad115.SistemaBolsa.service.impl;

import com.bad115.SistemaBolsa.entity.DetalleHabilidad;
import com.bad115.SistemaBolsa.entity.Habilidad;
import com.bad115.SistemaBolsa.repository.HabilidadRepository;
import com.bad115.SistemaBolsa.service.HabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabilidadServiceImpl implements HabilidadService {

    @Autowired
    private HabilidadRepository habilidadRepository;

    @Override
    public Habilidad save(Habilidad habilidad) {
        return habilidadRepository.save(habilidad);
    }

    @Override
    public Habilidad getHabilidad(Long id) {
        return habilidadRepository.getReferenceById(id);
    }

    @Override
    public List<Habilidad> getHabilidades() {
        return habilidadRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        habilidadRepository.deleteById(id);
    }

    @Override
    public Habilidad update(Habilidad habilidad, Long id) {
        Habilidad habiliadActualizada = habilidadRepository.getReferenceById(id);
        habiliadActualizada.setCategoria(habilidad.getCategoria());
        return habilidadRepository.save(habiliadActualizada);
    }

    @Override
    public boolean existById(Long id) {
        return habilidadRepository.existsById(id);
    }

    @Override
    public List<DetalleHabilidad> getDetalleHabilidades(Long id) {
        return null;
    }
}
