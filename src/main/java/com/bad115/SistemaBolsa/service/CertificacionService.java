package com.bad115.SistemaBolsa.service;

import com.bad115.SistemaBolsa.entity.Certificacion;

import java.util.List;


public interface CertificacionService {
    public Certificacion guardarCertificacion(Certificacion certificacion, Long aspiranteId);

    public Certificacion obtenerCertificacion(Long id);

    public List<Certificacion> obtenerCertificaciones();

    public Certificacion actualizarCertificacion(Certificacion certificacion, Long id, Long aspiranteId);

    public void eliminarCertificacion(Long id);
}
