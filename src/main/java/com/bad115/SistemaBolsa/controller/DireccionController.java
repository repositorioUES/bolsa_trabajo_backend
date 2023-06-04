package com.bad115.SistemaBolsa.controller;

import com.bad115.SistemaBolsa.entity.Direccion;
import com.bad115.SistemaBolsa.service.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/direcciones")
@CrossOrigin("*")
public class DireccionController {
    @Autowired
    private DireccionService direccionService;

    @PostMapping
    public Direccion guardarDireccion(@RequestBody Direccion direccion) {
        return direccionService.guardarDireccion(direccion);
    }

    @GetMapping
    public List<Direccion> obtenerDirecciones() {
        return direccionService.obtenerDirecciones();
    }

    @GetMapping("/{id}")
    public Direccion obtenerDireccion(@PathVariable("id") Long id) {
        return direccionService.obtenerDireccion(id);
    }

    @PutMapping("/{id}")
    public Direccion actualizarDireccion(@PathVariable("id") Long id, @RequestBody Direccion direccion) {
        return direccionService.actualizarDireccion(direccion, id);
    }

    @DeleteMapping("/{id}")
    public void eliminarDireccion(@PathVariable("/{id}") Long id) {
        direccionService.eliminarDireccion(id);
    }
}
