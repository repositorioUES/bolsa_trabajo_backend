package com.bad115.SistemaBolsa.service.impl;

import com.bad115.SistemaBolsa.entity.Certificacion;
import com.bad115.SistemaBolsa.repository.CertificacionRepository;
import com.bad115.SistemaBolsa.service.CertificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificacionServiceImpl implements CertificacionService {
    @Autowired
    private CertificacionRepository certificacionRepository;

    @Override
    public Certificacion guardarCertificacion(Certificacion certificacion) {
        return certificacionRepository.save(certificacion);
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
        Certificacion certificacionLocal = certificacionRepository.getReferenceById(id);
        certificacionLocal.setCodigo(certificacion.getCodigo());
        certificacionLocal.setNombre(certificacion.getNombre());
        certificacionLocal.setTipo(certificacion.getTipo());
        certificacionLocal.setInstitucion(certificacion.getInstitucion());
        certificacionLocal.setFecha_inicio(certificacion.getFecha_inicio());
        certificacionLocal.setFecha_fin(certificacion.getFecha_fin());
        certificacion.setAspirante(certificacionLocal.getAspirante());
        return certificacionRepository.save(certificacionLocal);
    }

    @Override
    public void eliminarCertificacion(Long id) {
        certificacionRepository.deleteById(id);
    }
}
