package com.bad115.SistemaBolsa.service.impl;

import com.bad115.SistemaBolsa.entity.DetalleReferencia;
import com.bad115.SistemaBolsa.entity.Referencia;
import com.bad115.SistemaBolsa.repository.DetalleReferenciaRepository;
import com.bad115.SistemaBolsa.repository.ReferenciaRepository;
import com.bad115.SistemaBolsa.service.DetalleReferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleReferenciaServiceImpl implements DetalleReferenciaService {

    @Autowired
    private DetalleReferenciaRepository detalleReferenciaRepository;
    @Autowired
    private ReferenciaRepository referenciaRepository;

    @Override
    public DetalleReferencia save(DetalleReferencia detalleReferencia, Long id) {
        DetalleReferencia dr = new DetalleReferencia();
        dr.setNombre_detalle_referencia(detalleReferencia.getNombre_detalle_referencia());
        dr.setReferencia(referenciaRepository.getReferenceById(id));
        return detalleReferenciaRepository.save(dr);
    }

    @Override
    public DetalleReferencia getDetalleReferencia(Long id) {
        return detalleReferenciaRepository.getReferenceById(id);
    }

    @Override
    public List<DetalleReferencia> getDetallesReferencias() {
        return detalleReferenciaRepository.findAll();
    }

    @Override
    public List<DetalleReferencia> getDetalleReferenciaByReferencia(Long id) {
        Referencia r = referenciaRepository.getReferenceById(id);
        List<DetalleReferencia> dr = detalleReferenciaRepository.getByReferencia(r);
        return dr;
    }

    @Override
    public void delete(Long id) {
        detalleReferenciaRepository.deleteById(id);
    }

    @Override
    public DetalleReferencia update(DetalleReferencia detalleReferencia, Long id) {
        DetalleReferencia dr = detalleReferenciaRepository.getReferenceById(id);
        dr.setNombre_detalle_referencia(detalleReferencia.getNombre_detalle_referencia());
        return detalleReferenciaRepository.save(dr);
    }

    @Override
    public boolean existById(Long id) {
        return false;
    }
}
