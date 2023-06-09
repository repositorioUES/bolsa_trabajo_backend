package com.bad115.SistemaBolsa.service.impl;

import com.bad115.SistemaBolsa.entity.Aspirante;
import com.bad115.SistemaBolsa.entity.Documento;
import com.bad115.SistemaBolsa.repository.AspiranteRepository;
import com.bad115.SistemaBolsa.repository.DocumentoRepository;
import com.bad115.SistemaBolsa.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentoServiceImpl implements DocumentoService {

    @Autowired
    private DocumentoRepository documentoRepository;
    @Autowired
    private AspiranteRepository aspiranteRepository;

    @Override
    public Documento save(Documento documento, Long id) {
        Documento d = new Documento();
        d.setNombre_documento(documento.getNombre_documento());
        d.setUri(documento.getUri());
        d.setAspirante(aspiranteRepository.getReferenceById(id));
        return documentoRepository.save(d);
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
    public List<Documento> getDocumentoByAspirante(Long id) {
        Aspirante a = aspiranteRepository.getReferenceById(id);
        List<Documento> documentos = documentoRepository.getByAspirante(a);
        return documentos;
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

    @Override
    public boolean existById(Long id) {
        return documentoRepository.existsById(id);
    }
}
