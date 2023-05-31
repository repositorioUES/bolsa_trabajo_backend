package com.bad115.SistemaBolsa.service.impl;

import com.bad115.SistemaBolsa.entity.Aspirante;
import com.bad115.SistemaBolsa.repository.AspiranteeRepository;
import com.bad115.SistemaBolsa.service.AspiranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AspiranteServiceImpl implements AspiranteService {

    @Autowired
    private AspiranteeRepository aspiranteeRepository;


    @Override
    public Aspirante guardarAspirante(Aspirante aspirante) {
        return aspiranteeRepository.save(aspirante);
    }

    @Override
    public Aspirante obtenerAspirante(Long id) {
        return aspiranteeRepository.getReferenceById(id);
    }

    @Override
    public List<Aspirante> obtenerAspirantes() {
        return aspiranteeRepository.findAll();
    }

    @Override
    public Aspirante actualizarAspirante(Aspirante aspirante, Long id) {
        Aspirante aspiranteLocal = aspiranteeRepository.getReferenceById(id);
        aspiranteLocal.setTipo_documento(aspirante.getTipo_documento());
        aspiranteLocal.setNumero_documento_identidad(aspirante.getNumero_documento_identidad());
        aspiranteLocal.setPrimer_nombre(aspirante.getPrimer_nombre());
        aspiranteLocal.setSegundo_nombre(aspirante.getSegundo_nombre());
        aspiranteLocal.setPrimer_apellido(aspirante.getPrimer_apellido());
        aspiranteLocal.setSegundo_apellido(aspirante.getSegundo_apellido());
        aspiranteLocal.setFecha_nacimiento(aspirante.getFecha_nacimiento());
        aspiranteLocal.setNit(aspirante.getNit());
        aspiranteLocal.setNup(aspirante.getNup());
        aspiranteLocal.setTelefono_casa(aspirante.getTelefono_casa());
        aspiranteLocal.setTelefono_personal(aspirante.getTelefono_personal());
        aspiranteLocal.setEmail(aspirante.getEmail());
        aspiranteLocal.setRedes_sociales(aspirante.getRedes_sociales());
        aspiranteLocal.setOfertas(aspirante.getOfertas());
        aspiranteLocal.setGenero(aspirante.getGenero());
        aspiranteLocal.setConocimientos_academicos(aspirante.getConocimientos_academicos());
        aspiranteLocal.setCertificaciones(aspirante.getCertificaciones());
        return aspiranteeRepository.save(aspiranteLocal);
    }

    @Override
    public void eliminarAspirante(Long id) {
        aspiranteeRepository.deleteById(id);
    }
}