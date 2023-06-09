package com.bad115.SistemaBolsa.service.impl;

import com.bad115.SistemaBolsa.entity.Aspirante;
import com.bad115.SistemaBolsa.entity.Referencia;
import com.bad115.SistemaBolsa.repository.AspiranteRepository;
import com.bad115.SistemaBolsa.repository.ReferenciaRepository;
import com.bad115.SistemaBolsa.service.ReferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReferenciaServiceImpl implements ReferenciaService {

    @Autowired
    private ReferenciaRepository referenciaRepository;
    @Autowired
    private AspiranteRepository aspiranteRepository;

    @Override
    public Referencia save(Referencia referencia, Long id) {
        Referencia r = new Referencia();
        r.setNombre_referencia(referencia.getNombre_referencia());
        r.setTipo_referencia(referencia.getTipo_referencia());
        r.setTelefono_referencia(referencia.getTelefono_referencia());
        r.setEmail_referencia(referencia.getEmail_referencia());
        r.setAspirante(aspiranteRepository.getReferenceById(id));
        return referenciaRepository.save(r);
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
    public List<Referencia> getReferenciasByAspirante(Long id) {
        Aspirante a = aspiranteRepository.getReferenceById(id);
        List<Referencia> referencias = referenciaRepository.getByAspirante(a);
        return referencias;
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

    @Override
    public boolean existById(Long id) {
        return referenciaRepository.existsById(id);
    }
}
