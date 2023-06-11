package com.bad115.SistemaBolsa.service.impl;

import com.bad115.SistemaBolsa.entity.Aspirante;
import com.bad115.SistemaBolsa.entity.Certificacion;
import com.bad115.SistemaBolsa.repository.AspiranteRepository;
import com.bad115.SistemaBolsa.repository.CertificacionRepository;
import com.bad115.SistemaBolsa.service.CertificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificacionServiceImpl implements CertificacionService {
    @Autowired
    private CertificacionRepository certificacionRepository;

    @Autowired
    private AspiranteRepository aspiranteRepository;

    @Override
    public Certificacion guardarCertificacion(Certificacion certificacion) {
        Aspirante a = aspiranteRepository.getReferenceById(certificacion.getAspirante().getId());
        Certificacion c = new Certificacion();
        c.setCodigo(certificacion.getCodigo());
        c.setNombre(certificacion.getNombre());
        c.setTipo(certificacion.getTipo());
        c.setInstitucion(certificacion.getInstitucion());
        c.setFecha_inicio(certificacion.getFecha_inicio());
        c.setFecha_fin(certificacion.getFecha_fin());
        c.setAspirante(a);
        return certificacionRepository.save(c);
    }

    @Override
    public Certificacion obtenerCertificacion(Long id) {
        return certificacionRepository.getReferenceById(id);
    }

    @Override
    public List<Certificacion> obtenerCertificaciones() {
        return certificacionRepository.findAll();
    }

    @Override
    public Certificacion actualizarCertificacion(Certificacion certificacion, Long id) {
        Aspirante a = aspiranteRepository.getReferenceById(certificacion.getAspirante().getId());
        Certificacion c = certificacionRepository.getReferenceById(id);
        c.setCodigo(certificacion.getCodigo());
        c.setNombre(certificacion.getNombre());
        c.setTipo(certificacion.getTipo());
        c.setInstitucion(certificacion.getInstitucion());
        c.setFecha_inicio(certificacion.getFecha_inicio());
        c.setFecha_fin(certificacion.getFecha_fin());
        c.setAspirante(a);
        return certificacionRepository.save(c);
    }

    @Override
    public void eliminarCertificacion(Long id) {
        certificacionRepository.deleteById(id);
    }
}
