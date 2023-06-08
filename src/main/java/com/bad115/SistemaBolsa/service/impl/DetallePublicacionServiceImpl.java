package com.bad115.SistemaBolsa.service.impl;

import com.bad115.SistemaBolsa.entity.DetallePublicacion;
import com.bad115.SistemaBolsa.entity.Publicacion;
import com.bad115.SistemaBolsa.repository.DetallePublicacionRepository;
import com.bad115.SistemaBolsa.repository.PublicacionRepository;
import com.bad115.SistemaBolsa.service.DetallePublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallePublicacionServiceImpl implements DetallePublicacionService {

    @Autowired
    private DetallePublicacionRepository detallePublicacionRepository;
    @Autowired
    private PublicacionRepository publicacionRepository;

    @Override
    public DetallePublicacion save(DetallePublicacion detallePublicacion, Long id) {
        DetallePublicacion dp = new DetallePublicacion();
        dp.setNombre_detalle_publicacion(detallePublicacion.getNombre_detalle_publicacion());
        dp.setPublicacion(publicacionRepository.getReferenceById(id));
        return detallePublicacionRepository.save(dp);
    }

    @Override
    public DetallePublicacion getDetallePublicacion(Long id) {
        return detallePublicacionRepository.getReferenceById(id);
    }

    @Override
    public List<DetallePublicacion> getDetallesPublicaciones() {
        return detallePublicacionRepository.findAll();
    }

    @Override
    public List<DetallePublicacion> getDetallePublicacionByPublicacion(Long id) {
        Publicacion p = publicacionRepository.getReferenceById(id);
        List<DetallePublicacion> dp = detallePublicacionRepository.getByPublicacion(p);
        return dp;
    }

    @Override
    public void delete(Long id) {
        detallePublicacionRepository.deleteById(id);
    }

    @Override
    public DetallePublicacion update(DetallePublicacion detallePublicacion, Long id) {
        DetallePublicacion dp = detallePublicacionRepository.getReferenceById(id);
        dp.setNombre_detalle_publicacion(detallePublicacion.getNombre_detalle_publicacion());
        return detallePublicacionRepository.save(dp);
    }

    @Override
    public boolean existById(Long id) {
        return false;
    }
}
