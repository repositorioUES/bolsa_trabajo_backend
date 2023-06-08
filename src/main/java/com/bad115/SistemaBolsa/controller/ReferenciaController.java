package com.bad115.SistemaBolsa.controller;

import com.bad115.SistemaBolsa.entity.Referencia;
import com.bad115.SistemaBolsa.service.ReferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/referencia")
public class ReferenciaController {

    @Autowired
    private ReferenciaService referenciaService;
    @GetMapping
    public List<Referencia> getReferencias(){
        return referenciaService.getReferencias();
    }

    @GetMapping("/{id}")
    public Referencia getReferencia(@PathVariable Long id) {
        return referenciaService.getReferencia(id);
    }

    @PostMapping("/aspirante/{id}")
    public Referencia saveReferencia(@RequestBody Referencia referencia, @PathVariable("id") Long id) {
        return referenciaService.save(referencia, id);
    }

    @PutMapping("/{id}")
    public Referencia updateReferencia(@RequestBody Referencia referencia, @PathVariable("id") Long id) {
        return referenciaService.update(referencia, id);
    }

    @DeleteMapping("/{id}")
    public void deleteReferencia(@PathVariable("id") Long id) {
        referenciaService.delete(id);
    }

    @GetMapping("/aspirante/{id}") //Obtener todos las REFERENCIAS de un Aspirante específico
    public ResponseEntity<List<Referencia>> getPublicacionByAspirante(@PathVariable(value = "id") Long id) {
        List<Referencia> referencias = null;
        referencias = referenciaService.getReferenciasByAspirante(id);

        return new ResponseEntity<>(referencias, HttpStatus.OK);
    }
}
