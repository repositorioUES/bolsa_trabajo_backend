package com.bad115.SistemaBolsa.controller;

import com.bad115.SistemaBolsa.entity.DetalleHabilidad;
import com.bad115.SistemaBolsa.entity.Habilidad;
import com.bad115.SistemaBolsa.service.DetalleHabilidadService;
import com.bad115.SistemaBolsa.service.HabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/detalle_habilidad")
public class DetalleHabilidadController {

    @Autowired
    private DetalleHabilidadService detalleHabilidadService;
    @Autowired
    private HabilidadService habilidadService;

    @GetMapping // Obtener TODOS los DetalleHabilidad sin importar de que Habilidad sean
    public List<DetalleHabilidad> getDetalleHabilidades(){
        return detalleHabilidadService.getDetalleHabilidades();
    }

    @GetMapping("/{id}") // Obtener un DetalleHabilidad
    public DetalleHabilidad getDetalleHabilidad(@PathVariable Long id) {
        return detalleHabilidadService.getDetalleHabilidad(id);
    }

    @PostMapping("/habilidad/{id}")
    public DetalleHabilidad saveDetalleHabilidad(@RequestBody DetalleHabilidad detalleHabilidad, @PathVariable("id") Long id) {
        return detalleHabilidadService.save(detalleHabilidad, id);
    }

    @PutMapping("/{id}")
    public DetalleHabilidad updateDetalleHabilidad(@RequestBody DetalleHabilidad detalleHabilidad, @PathVariable("id") Long id) {
        return detalleHabilidadService.update(detalleHabilidad, id);
    }

    @DeleteMapping("/{id}")
    public void deleteDetalleHabilidad(@PathVariable("id") Long id) {
        detalleHabilidadService.delete(id);
    }

    @GetMapping("/habilidad/{id}") //Obtener todos los DetalleHabilidad de una Habilidad específica
    public ResponseEntity<List<DetalleHabilidad>> getDetalleHabilidadByHabilidad(@PathVariable(value = "id") Long id_habilidad) {
        List<DetalleHabilidad> habilidades = null;
        if (habilidadService.existById(id_habilidad)) {
            habilidades = detalleHabilidadService.getDetalleHabilidadByHabilidad(id_habilidad);
        }

        return new ResponseEntity<>(habilidades, HttpStatus.OK);
    }
 }
