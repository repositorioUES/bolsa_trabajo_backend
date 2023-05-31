package com.bad115.SistemaBolsa.controller;

import com.bad115.SistemaBolsa.entity.Referencia;
import com.bad115.SistemaBolsa.service.ReferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/")
    public Referencia saveReferencia(@RequestBody Referencia referencia) {
        return referenciaService.save(referencia);
    }

    @PutMapping("/{id}")
    public Referencia updateReferencia(@RequestBody Referencia referencia, @PathVariable("id") Long id) {
        return referenciaService.update(referencia, id);
    }

    @DeleteMapping("/{id}")
    public void deleteReferencia(@PathVariable("id") Long id) {
        referenciaService.delete(id);
    }
}
