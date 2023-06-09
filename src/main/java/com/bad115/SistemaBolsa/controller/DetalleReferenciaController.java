package com.bad115.SistemaBolsa.controller;

import com.bad115.SistemaBolsa.entity.DetalleReferencia;
import com.bad115.SistemaBolsa.service.DetalleReferenciaService;
import com.bad115.SistemaBolsa.service.ReferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalle_referencia")
public class DetalleReferenciaController {


    @Autowired
    private DetalleReferenciaService detalleReferenciaService;
    @Autowired
    private ReferenciaService referenciaService;

    @GetMapping
    public List<DetalleReferencia> getHDetallesReferencias(){
        return detalleReferenciaService.getDetallesReferencias();
    }

    @GetMapping("/{id}")
    public DetalleReferencia getDetalleReferencia(@PathVariable Long id) {
        return detalleReferenciaService.getDetalleReferencia(id);
    }

    @PostMapping("/referencia/{id}")
    public DetalleReferencia saveDetalleReferencia(@RequestBody DetalleReferencia detalleReferencia, @PathVariable("id") Long id) {
        return detalleReferenciaService.save(detalleReferencia, id);
    }

    @PutMapping("/{id}")
    public DetalleReferencia updateDetalleReferencia(@RequestBody DetalleReferencia detalleReferencia, @PathVariable("id") Long id) {
        return detalleReferenciaService.update(detalleReferencia, id);
    }

    @DeleteMapping("/{id}")
    public void deleteDetalleReferencia(@PathVariable("id") Long id) {
        detalleReferenciaService.delete(id);
    }


    @GetMapping("/referencia/{id}") //Obtener todos los DetalleReferencia de una Referencia específica
    public ResponseEntity<List<DetalleReferencia>> getDetallePublicacionByPublicacion(@PathVariable(value = "id") Long id_referencia) {
        List<DetalleReferencia> referencias = null;
        if (referenciaService.existById(id_referencia)) {
            referencias = detalleReferenciaService.getDetalleReferenciaByReferencia(id_referencia);
        }

        return new ResponseEntity<>(referencias, HttpStatus.OK);
    }
}
