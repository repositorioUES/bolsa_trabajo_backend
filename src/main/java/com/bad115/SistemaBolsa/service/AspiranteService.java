package com.bad115.SistemaBolsa.service;

import com.bad115.SistemaBolsa.entity.Aspirante;
import com.bad115.SistemaBolsa.entity.Oferta;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AspiranteService {

    public Aspirante guardarAspirante(Aspirante aspirante, Long generoId, Long usuarioId);

    public Aspirante obtenerAspirante(Long id);

    public List<Aspirante> obtenerAspirantes();

    public Aspirante aplicarOferta(Long aspiranteId, Long ofertaId);

    public Aspirante actualizarAspirante(Aspirante aspirante, Long id);

    public void eliminarAspirante(Long id);
}
