package com.bad115.SistemaBolsa.service.impl;

import com.bad115.SistemaBolsa.entity.Empresa;
import com.bad115.SistemaBolsa.entity.Oferta;
import com.bad115.SistemaBolsa.repository.OfertaRepository;
import com.bad115.SistemaBolsa.service.OfertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfertaServiceImpl implements OfertaService {

    @Autowired
    private OfertaRepository ofertaRepository;

    @Override
    public Oferta guardarOferta(Oferta oferta) {
        return ofertaRepository.save(oferta);
    }

    @Override
    public List<Oferta> obtenerOfertas() {
        return ofertaRepository.findAll();
    }

    @Override
    public Oferta obtenerOferta(Long id) {
        return ofertaRepository.getReferenceById(id);
    }

    @Override
    public Oferta actualizarOferta(Oferta oferta, Long id) {
        Oferta ofertaLocal = ofertaRepository.getReferenceById(id);
        ofertaLocal.setNombre(oferta.getNombre());
        ofertaLocal.setExperiencia(oferta.getExperiencia());
        ofertaLocal.setRango_salarial(oferta.getRango_salarial());
        ofertaLocal.setModalidades(oferta.getModalidades());
        ofertaLocal.setCategoria_oferta(oferta.getCategoria_oferta());
        ofertaLocal.setEmpresa(oferta.getEmpresa());
        ofertaLocal.setAspirantes(oferta.getAspirantes());
        return ofertaRepository.save(ofertaLocal);
    }

    @Override
    public void eliminarOferta(Long id) {
        ofertaRepository.deleteById(id);
    }
}
