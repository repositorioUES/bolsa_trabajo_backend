package com.bad115.SistemaBolsa.service.impl;

import com.bad115.SistemaBolsa.entity.Aspirante;
import com.bad115.SistemaBolsa.entity.AspiranteHabilidad;
import com.bad115.SistemaBolsa.entity.Habilidad;
import com.bad115.SistemaBolsa.repository.AspiranteHabilidadRepository;
import com.bad115.SistemaBolsa.repository.AspiranteRepository;
import com.bad115.SistemaBolsa.repository.HabilidadRepository;
import com.bad115.SistemaBolsa.service.AspiranteHabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AspiranteHabilidadServiceImpl implements AspiranteHabilidadService {

    @Autowired
    private AspiranteHabilidadRepository aspiranteHabilidadRepository;
    @Autowired
    private AspiranteRepository aspiranteRepository;
    @Autowired
    private HabilidadRepository habilidadRepository;

    @Override
    public AspiranteHabilidad save(Long idA, Long idH) {
        AspiranteHabilidad ah = new AspiranteHabilidad();
        ah.setAspirante(aspiranteRepository.getReferenceById(idA));
        ah.setHabilidad(habilidadRepository.getReferenceById(idH));
        return aspiranteHabilidadRepository.save(ah);
    }

    @Override
    public List<AspiranteHabilidad> getAspiranteHabilidadByAspirante(Long id) {
        Aspirante a = aspiranteRepository.getReferenceById(id);
        List<AspiranteHabilidad> ah = aspiranteHabilidadRepository.getByAspirante(a);
         return ah;
    }

    @Override
    public List<AspiranteHabilidad> getAspiranteHabilidadByHabilidad(Long id) {
        Habilidad h = habilidadRepository.getReferenceById(id);
        List<AspiranteHabilidad> ah = aspiranteHabilidadRepository.getByHabilidad(h);
        return ah;
    }

    @Override
    public void delete(Long idA, Long idH) {
        AspiranteHabilidad ah = aspiranteHabilidadRepository.findByAspiranteAndHabilidad(
                aspiranteRepository.getReferenceById(idA), habilidadRepository.getReferenceById(idH)
        );
            aspiranteHabilidadRepository.delete(ah);
    }
}
