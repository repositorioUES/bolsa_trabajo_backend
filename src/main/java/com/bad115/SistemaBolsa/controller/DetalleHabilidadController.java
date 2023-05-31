package com.bad115.SistemaBolsa.controller;

import com.bad115.SistemaBolsa.entity.DetalleHabilidad;
import com.bad115.SistemaBolsa.service.DetalleHabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalleHabilidad")
public class DetalleHabilidadController {

    @Autowired
    private DetalleHabilidadService detalleHabilidadService;

    @GetMapping
    public List<DetalleHabilidad> getDetalleHabilidades(){
        return detalleHabilidadService.getDetalleHabilidades();
    }

    @GetMapping("/{id}")
    public DetalleHabilidad getDetalleHabilidad(@PathVariable Long id) {
        return detalleHabilidadService.getDetalleHabilidad(id);
    }

    @PostMapping("/")
    public DetalleHabilidad saveDetalleHabilidad(@RequestBody DetalleHabilidad detalleHabilidad) {
        return detalleHabilidadService.save(detalleHabilidad);
    }

    @PutMapping("/{id}")
    public DetalleHabilidad updateDetalleHabilidad(@RequestBody DetalleHabilidad detalleHabilidad, @PathVariable("id") Long id) {
        return detalleHabilidadService.update(detalleHabilidad, id);
    }

    @DeleteMapping("/{id}")
    public void deleteDetalleHabilidad(@PathVariable("id") Long id) {
        detalleHabilidadService.delete(id);
    }
}
