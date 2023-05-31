package com.bad115.SistemaBolsa.service.impl;

import com.bad115.SistemaBolsa.entity.Referencia;
import com.bad115.SistemaBolsa.repository.ActividadAdicionalRepository;
import com.bad115.SistemaBolsa.repository.ReferenciaRepository;
import com.bad115.SistemaBolsa.service.ReferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReferenciaServiceImpl implements ReferenciaService {

    @Autowired
    private ReferenciaRepository referenciaRepository;
    @Override
    public Referencia save(Referencia referencia) {
        return referenciaRepository.save(referencia);
    }

    @Override
    public Referencia getReferencia(Long id) {
        return referenciaRepository.getReferenceById(id);
    }

    @Override
    public List<Referencia> getReferencias() {
        return referenciaRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        referenciaRepository.deleteById(id);
    }

    @Override
    public Referencia update(Referencia referencia, Long id) {
        Referencia referenciaActualizada = referenciaRepository.getReferenceById(id);
        referenciaActualizada.setTipo_referencia(referencia.getTipo_referencia());
        referenciaActualizada.setNombre_referencia(referencia.getNombre_referencia());
        referenciaActualizada.setTelefono_referencia(referencia.getTelefono_referencia());
        referenciaActualizada.setEmail_referencia(referencia.getEmail_referencia());
        return referenciaRepository.save(referenciaActualizada);
    }
}
