package com.bad115.SistemaBolsa.service;

import com.bad115.SistemaBolsa.entity.Referencia;

import java.util.List;

public interface ReferenciaService {

    public Referencia save(Referencia referencia, Long id);

    public Referencia getReferencia(Long id);

    public List<Referencia> getReferencias();

    public List<Referencia> getReferenciasByAspirante(Long id);

    public void delete(Long id);

    public Referencia update(Referencia referencia, Long id);

    boolean existById(Long idReferencia);
}
