package com.bad115.SistemaBolsa.controller;

import com.bad115.SistemaBolsa.entity.Institucion;
import com.bad115.SistemaBolsa.service.InstitucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instituciones")
@CrossOrigin("*")
public class InstitucionController {
    @Autowired
    private InstitucionService institucionService;

    @PostMapping
    public Institucion guardarInstitucion(@RequestBody Institucion institucion) {
        return institucionService.guardarInstitucion(institucion);
    }

    @GetMapping
    public List<Institucion> obtenerInstituciones() {
        return institucionService.obtenerInstituciones();
    }

    @GetMapping("/{id}")
    public Institucion obtenerInstitucion(@PathVariable("id") Long id) {
        return institucionService.obtenerInstitucion(id);
    }

    @PutMapping("/{id}")
    public Institucion actualizarInstitucion(@PathVariable("id") Long id, @RequestBody Institucion institucion) {
        return institucionService.actualizarInstitucion(institucion, id);
    }

    @DeleteMapping("/{id}")
    public void eliminarInstitucion(@PathVariable("/id") Long id) {
        institucionService.eliminarInstitucion(id);
    }
}
