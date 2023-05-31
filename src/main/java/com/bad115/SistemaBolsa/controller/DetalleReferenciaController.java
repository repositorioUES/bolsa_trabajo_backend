package com.bad115.SistemaBolsa.controller;

import com.bad115.SistemaBolsa.entity.DetalleReferencia;
import com.bad115.SistemaBolsa.service.DetalleReferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalle_referencia")
public class DetalleReferenciaController {


    @Autowired
    private DetalleReferenciaService detalleReferenciaService;

    @GetMapping
    public List<DetalleReferencia> getHDetallesReferencias(){
        return detalleReferenciaService.getDetallesReferencias();
    }

    @GetMapping("/{id}")
    public DetalleReferencia getDetalleReferencia(@PathVariable Long id) {
        return detalleReferenciaService.getDetalleReferencia(id);
    }

    @PostMapping("/")
    public DetalleReferencia saveDetalleReferencia(@RequestBody DetalleReferencia detalleReferencia) {
        return detalleReferenciaService.save(detalleReferencia);
    }

    @PutMapping("/{id}")
    public DetalleReferencia updateDetalleReferencia(@RequestBody DetalleReferencia detalleReferencia, @PathVariable("id") Long id) {
        return detalleReferenciaService.update(detalleReferencia, id);
    }

    @DeleteMapping("/{id}")
    public void deleteDetalleReferencia(@PathVariable("id") Long id) {
        detalleReferenciaService.delete(id);
    }
}
