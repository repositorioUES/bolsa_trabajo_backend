package com.bad115.SistemaBolsa.controller;

import com.bad115.SistemaBolsa.entity.Genero;
import com.bad115.SistemaBolsa.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/generos")
@CrossOrigin("*")
public class GeneroController {
    @Autowired
    private GeneroService generoService;

    @PostMapping
    public Genero guardarGenero(@RequestBody Genero genero) throws Exception {
        return generoService.guardarGenero(genero);
    }

    @GetMapping
    public List<Genero> obtenerGeneros() {
        return generoService.obtenerGeneros();
    }

    @GetMapping("/{id}")
    public Genero obtenerGenero(@PathVariable("id") Long id) {
        return generoService.obtenerGenero(id);
    }

    @PutMapping("/{id}")
    public Genero actualizarGenero(@PathVariable("id") Long id, @RequestBody Genero genero) {
        return generoService.actualizarGenero(genero, id);
    }

    @DeleteMapping("/{id}")
    public void eiminarGenero(@PathVariable("id") Long id) {
        generoService.eliminarGenero(id);
    }
}
