package com.bad115.SistemaBolsa.controller;

import com.bad115.SistemaBolsa.entity.Documento;
import com.bad115.SistemaBolsa.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/documento")
public class DocumentoController {


    @Autowired
    private DocumentoService documentoService;

    @GetMapping
    public List<Documento> getDeocumentos(){
        return documentoService.getDocumentos();
    }

    @GetMapping("/{id}")
    public Documento getDocumento(@PathVariable Long id) {
        return documentoService.getDocumento(id);
    }

    @PostMapping("/")
    public Documento saveDocumento(@RequestBody Documento documento) {
        return documentoService.save(documento);
    }

    @PutMapping("/{id}")
    public Documento updateDocumento(@RequestBody Documento documento, @PathVariable("id") Long id) {
        return documentoService.update(documento, id);
    }

    @DeleteMapping("/{id}")
    public void deleteDocumento(@PathVariable("id") Long id) {
        documentoService.delete(id);
    }
}
