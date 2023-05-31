package com.bad115.SistemaBolsa.service.impl;

import com.bad115.SistemaBolsa.entity.Publicacion;
import com.bad115.SistemaBolsa.repository.PublicacionRepository;
import com.bad115.SistemaBolsa.service.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicacionServiceImpl implements PublicacionService {

    @Autowired
    private PublicacionRepository publicacionRepository;

    @Override
    public Publicacion save(Publicacion publicacion) {
        return publicacionRepository.save(publicacion);
    }

    @Override
    public Publicacion getPublicacion(Long id) {
        return publicacionRepository.getReferenceById(id);
    }

    @Override
    public List<Publicacion> getPublicaciones() {
        return publicacionRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        publicacionRepository.deleteById(id);
    }

    @Override
    public Publicacion update(Publicacion publicacion, Long id) {
        Publicacion p = publicacionRepository.getReferenceById(id);
        p.setTipo_publicacion(publicacion.getTipo_publicacion());
        p.setLugar_publicacion(publicacion.getLugar_publicacion());
        p.setFecha_publicacion(publicacion.getFecha_publicacion());
        p.setEdicion_libro(publicacion.getEdicion_libro());
        p.setIsbn(publicacion.getIsbn());
        return publicacionRepository.save(p);
    }
}
