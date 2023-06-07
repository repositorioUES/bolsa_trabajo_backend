package com.bad115.SistemaBolsa.service.impl;

import com.bad115.SistemaBolsa.entity.CategoriaOferta;
import com.bad115.SistemaBolsa.entity.Empresa;
import com.bad115.SistemaBolsa.entity.Oferta;
import com.bad115.SistemaBolsa.entity.Ubicacion;
import com.bad115.SistemaBolsa.repository.CategoriaOfertaRepository;
import com.bad115.SistemaBolsa.repository.EmpresaRepository;
import com.bad115.SistemaBolsa.repository.OfertaRepository;
import com.bad115.SistemaBolsa.repository.UbicacionRepository;
import com.bad115.SistemaBolsa.service.CategoriaOfertaService;
import com.bad115.SistemaBolsa.service.EmpresaService;
import com.bad115.SistemaBolsa.service.OfertaService;
import com.bad115.SistemaBolsa.service.UbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public Oferta guardarOferta(Oferta oferta) {
        CategoriaOferta c = categoriaOfertaRepository.getReferenceById(oferta.getCategoria_oferta().getId());
        Empresa e = empresaRepository.getReferenceById(oferta.getEmpresa().getId());
        Ubicacion u = ubicacionRepository.getReferenceById(oferta.getUbicacion().getId());

        Oferta o = new Oferta();
        o.setNombre(oferta.getNombre());
        o.setExperiencia(oferta.getExperiencia());
        o.setRango_salarial(oferta.getRango_salarial());
        o.setUbicacion(u);
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
    public Oferta actualizarOferta(Oferta oferta, Long id) {
        CategoriaOferta c = categoriaOfertaRepository.getReferenceById(oferta.getCategoria_oferta().getId());
        Empresa e = empresaRepository.getReferenceById(oferta.getEmpresa().getId());
        Ubicacion u = ubicacionRepository.getReferenceById(oferta.getUbicacion().getId());

        Oferta o = ofertaRepository.getReferenceById(id);
        o.setNombre(oferta.getNombre());
        o.setExperiencia(oferta.getExperiencia());
        o.setRango_salarial(oferta.getRango_salarial());
        o.setUbicacion(u);
        o.setCategoria_oferta(c);
        o.setEmpresa(e);
        return ofertaRepository.save(o);
    }

    @Override
    public void eliminarOferta(Long id) {
        ofertaRepository.deleteById(id);
    }
}
