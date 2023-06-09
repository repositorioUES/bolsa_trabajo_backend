package com.bad115.SistemaBolsa.service.impl;

import com.bad115.SistemaBolsa.entity.Aspirante;
import com.bad115.SistemaBolsa.entity.Publicacion;
import com.bad115.SistemaBolsa.repository.AspiranteRepository;
import com.bad115.SistemaBolsa.repository.PublicacionRepository;
import com.bad115.SistemaBolsa.service.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicacionServiceImpl implements PublicacionService {

    @Autowired
    private PublicacionRepository publicacionRepository;
    @Autowired
    private AspiranteRepository aspiranteRepository;

    @Override
    public Publicacion save(Publicacion publicacion, Long id) {
        Publicacion p =new Publicacion();
        p.setTipo_publicacion(publicacion.getTipo_publicacion());
        p.setLugar_publicacion(publicacion.getLugar_publicacion());
        p.setFecha_publicacion(publicacion.getFecha_publicacion());
        p.setEdicion_libro(publicacion.getEdicion_libro());
        p.setIsbn(publicacion.getIsbn());
        p.setAspirante(aspiranteRepository.getReferenceById(id));
        return publicacionRepository.save(p);
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
    public List<Publicacion> getPublicacionesByAspirante(Long id) {
        Aspirante a = aspiranteRepository.getReferenceById(id);
        List<Publicacion> publicaciones = publicacionRepository.getByAspirante(a);
        return publicaciones;
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

    @Override
    public boolean existById(Long id) {
        return publicacionRepository.existsById(id);
    }
}
