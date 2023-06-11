package com.bad115.SistemaBolsa.service;

import com.bad115.SistemaBolsa.entity.Empresa;
import com.bad115.SistemaBolsa.entity.Oferta;

import java.util.List;


public interface OfertaService {

    public Oferta guardarOferta(Oferta oferta, Long categoriaId, Long empresaId);

    public List<Oferta> obtenerOfertas();

    public Oferta obtenerOferta(Long id);

    public Oferta agregarModalidad(Long ofertaId, Long modalidadId);

    public Oferta actualizarOferta(Oferta oferta, Long id, Long categoriaId, Long empresaId);

    public void eliminarOferta(Long id);
}
