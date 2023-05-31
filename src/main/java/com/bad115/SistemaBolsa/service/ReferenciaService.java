package com.bad115.SistemaBolsa.service;

import com.bad115.SistemaBolsa.entity.Referencia;

import java.util.List;

public interface ReferenciaService {

    public Referencia save(Referencia referencia);

    public Referencia getReferencia(Long id);

    public List<Referencia> getReferencias();

    public void delete(Long id);

    public Referencia update(Referencia referencia, Long id);
}
