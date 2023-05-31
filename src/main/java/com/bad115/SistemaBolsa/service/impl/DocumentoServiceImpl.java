package com.bad115.SistemaBolsa.service.impl;

import com.bad115.SistemaBolsa.entity.Documento;
import com.bad115.SistemaBolsa.repository.DocumentoRepository;
import com.bad115.SistemaBolsa.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentoServiceImpl implements DocumentoService {

    @Autowired
    private DocumentoRepository documentoRepository;

    @Override
    public Documento save(Documento documento) {
        return documentoRepository.save(documento);
    }

    @Override
    public Documento getDocumento(Long id) {
        return documentoRepository.getReferenceById(id);
    }

    @Override
    public List<Documento> getDocumentos() {
        return documentoRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        documentoRepository.deleteById(id);
    }

    @Override
    public Documento update(Documento documento, Long id) {
        Documento d = documentoRepository.getReferenceById(id);
        d.setNombre_documento(documento.getNombre_documento());
        d.setUri(documento.getUri());
        return documentoRepository.save(d);
    }
}
