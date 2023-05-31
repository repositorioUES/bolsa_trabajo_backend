package com.bad115.SistemaBolsa.controller;

import com.bad115.SistemaBolsa.entity.DetallePublicacion;
import com.bad115.SistemaBolsa.service.DetallePublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalle_publicacion")
public class DetallePublicacionController {


    @Autowired
    private DetallePublicacionService detallePublicacionService;

    @GetMapping
    public List<DetallePublicacion> getDetallePublicaciones(){
        return detallePublicacionService.getDetallesPublicaciones();
    }

    @GetMapping("/{id}")
    public DetallePublicacion getDetallePublicacion(@PathVariable Long id) {
        return detallePublicacionService.getDetallePublicacion(id);
    }

    @PostMapping("/")
    public DetallePublicacion saveDetallePublicacion(@RequestBody DetallePublicacion detallePublicacion) {
        return detallePublicacionService.save(detallePublicacion);
    }

    @PutMapping("/{id}")
    public DetallePublicacion updateDetallePublicacion(@RequestBody DetallePublicacion detallePublicacion, @PathVariable("id") Long id) {
        return detallePublicacionService.update(detallePublicacion, id);
    }

    @DeleteMapping("/{id}")
    public void deleteDetallePublicacion(@PathVariable("id") Long id) {
        detallePublicacionService.delete(id);
    }
}
