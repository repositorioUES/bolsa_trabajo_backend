package com.bad115.SistemaBolsa.service.impl;

import com.bad115.SistemaBolsa.entity.*;
import com.bad115.SistemaBolsa.repository.*;
import com.bad115.SistemaBolsa.service.CategoriaOfertaService;
import com.bad115.SistemaBolsa.service.EmpresaService;
import com.bad115.SistemaBolsa.service.OfertaService;
import com.bad115.SistemaBolsa.service.UbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class OfertaServiceImpl implements OfertaService {

    @Autowired
    private OfertaRepository ofertaRepository;

    @Autowired
    private UbicacionRepository ubicacionRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private CategoriaOfertaRepository categoriaOfertaRepository;

    @Autowired
    private ModalidadRepository modalidadRepository;

    @Override
    public Oferta guardarOferta(Oferta oferta) {
        CategoriaOferta c = categoriaOfertaRepository.getReferenceById(oferta.getCategoria_oferta().getId());
        Empresa e = empresaRepository.getReferenceById(oferta.getEmpresa().getId());

        Oferta o = new Oferta();
        o.setNombre(oferta.getNombre());
        o.setExperiencia(oferta.getExperiencia());
        o.setRango_salarial(oferta.getRango_salarial());
        o.setCategoria_oferta(c);
        o.setEmpresa(e);
        return ofertaRepository.save(o);
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
    public Oferta agregarModalidad(Long ofertaId, Long modalidadId){
        Set<Modalidad> modalidadSet = null;
        Oferta oferta = ofertaRepository.getReferenceById(ofertaId);
        Modalidad modalidad = modalidadRepository.getReferenceById(modalidadId);
        modalidadSet = oferta.getModalidades();
        modalidadSet.add(modalidad);
        oferta.setModalidades(modalidadSet);
        return ofertaRepository.save(oferta);
    }


    @Override
    public Oferta actualizarOferta(Oferta oferta, Long id) {
        CategoriaOferta c = categoriaOfertaRepository.getReferenceById(oferta.getCategoria_oferta().getId());
        Empresa e = empresaRepository.getReferenceById(oferta.getEmpresa().getId());

        Oferta o = ofertaRepository.getReferenceById(id);
        o.setNombre(oferta.getNombre());
        o.setExperiencia(oferta.getExperiencia());
        o.setRango_salarial(oferta.getRango_salarial());
        o.setCategoria_oferta(c);
        o.setEmpresa(e);
        return ofertaRepository.save(o);
    }

    @Override
    public void eliminarOferta(Long id) {
        ofertaRepository.deleteById(id);
    }
}
