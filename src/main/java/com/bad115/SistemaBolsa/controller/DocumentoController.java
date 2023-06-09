package com.bad115.SistemaBolsa.controller;

import com.bad115.SistemaBolsa.entity.Documento;
import com.bad115.SistemaBolsa.service.AspiranteService;
import com.bad115.SistemaBolsa.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/documento")
public class DocumentoController {


    @Autowired
    private DocumentoService documentoService;
    @Autowired
    private AspiranteService aspiranteService;

    @GetMapping // Todos los Documentos
    public List<Documento> getDocumentos(){
        return documentoService.getDocumentos();
    }

    @GetMapping("/{id}") // Obtener un Documantor por su ID
    public Documento getDocumento(@PathVariable Long id) {
        return documentoService.getDocumento(id);
    }

    @PostMapping("/aspirante/{id}") // Guardar un Documento con su respectivo aspirante
    public Documento saveDocumento(@RequestBody Documento documento, @PathVariable("id") Long id) {
        return documentoService.save(documento, id);
    }

    @PutMapping("/{id}")
    public Documento updateDocumento(@RequestBody Documento documento, @PathVariable("id") Long id) {
        return documentoService.update(documento, id);
    }

    @DeleteMapping("/{id}")
    public void deleteDocumento(@PathVariable("id") Long id) {
        documentoService.delete(id);
    }

    @GetMapping("/aspirante/{id}") //Obtener todos las DOCUMENTOS de un Aspirante específico
    public ResponseEntity<List<Documento>> getDocumentoByAspirante(@PathVariable(value = "id") Long id) {
        List<Documento> documentos = null;
        documentos = documentoService.getDocumentoByAspirante(id);

        return new ResponseEntity<>(documentos, HttpStatus.OK);
    }
}
