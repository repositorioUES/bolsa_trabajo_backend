package com.bad115.SistemaBolsa.controller;

import com.bad115.SistemaBolsa.entity.Modalidad;
import com.bad115.SistemaBolsa.service.ModalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modalidades")
@CrossOrigin("*")
public class ModalidadController {
    @Autowired
    private ModalidadService modalidadService;

    @PostMapping
    public Modalidad guardarModalidad(@RequestBody Modalidad modalidad) {
        return modalidadService.guardarModalidad(modalidad);
    }

    @GetMapping
    public List<Modalidad> obtenerModalidades() {
        return modalidadService.obtenerModalidades();
    }

    @GetMapping("/{id}")
    public Modalidad obtenerModalidad(@PathVariable("id") Long id) {
        return modalidadService.obtenerModalidad(id);
    }

    @PutMapping("/{id}")
    public Modalidad actualizarModalidad(@PathVariable("id") Long id, @RequestBody Modalidad modalidad) {
        return modalidadService.actualizarModalidad(modalidad, id);
    }

    @DeleteMapping("/{id}")
    public void eliminarModalidad(@PathVariable("id") Long id) {
        modalidadService.eliminarModalidad(id);
    }
}
