package com.bad115.SistemaBolsa.service;

import com.bad115.SistemaBolsa.entity.DetalleReferencia;

import java.util.List;

public interface DetalleReferenciaService {

    public DetalleReferencia save(DetalleReferencia detalleReferencia, Long id);

    public DetalleReferencia getDetalleReferencia(Long id);

    public List<DetalleReferencia> getDetallesReferencias();

    public List<DetalleReferencia> getDetalleReferenciaByReferencia(Long id);

    public void delete(Long id);

    public DetalleReferencia update(DetalleReferencia detalleReferencia, Long id);

    public boolean existById(Long id);
}
