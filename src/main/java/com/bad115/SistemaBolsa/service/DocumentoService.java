package com.bad115.SistemaBolsa.service;

import com.bad115.SistemaBolsa.entity.Documento;

import java.util.List;

public interface DocumentoService {

    public Documento save(Documento documento);

    public Documento getDocumento(Long id);

    public List<Documento> getDocumentos();

    public void delete(Long id);

    public Documento update(Documento documento, Long id);
}
