package com.bad115.SistemaBolsa.controller;

import com.bad115.SistemaBolsa.entity.Aspirante;
import com.bad115.SistemaBolsa.service.AspiranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aspirantes")
@CrossOrigin("*")
public class AspiranteController {
    @Autowired
    private AspiranteService aspiranteService;

    @PostMapping("/genero/{generoId}/usuario/{usuarioId}")
    public Aspirante guardarAspirante(
            @RequestBody Aspirante aspirante,
            @PathVariable Long generoId,
            @PathVariable Long usuarioId
    ) {
        return aspiranteService.guardarAspirante(aspirante, generoId, usuarioId);
    }

    @GetMapping
    public List<Aspirante> obtenerAspirantes() {
        return aspiranteService.obtenerAspirantes();
    }

    @GetMapping("/{id}")
    public Aspirante obtenerAspirante(@PathVariable("id") Long id) {
        return aspiranteService.obtenerAspirante(id);
    }

    @PutMapping("/{aspiranteId}/oferta/{ofertaId}")
    public Aspirante aplicarOferta(
            @PathVariable Long aspiranteId,
            @PathVariable Long ofertaId
    ) {
        return aspiranteService.aplicarOferta(aspiranteId, ofertaId);
    }

    @PutMapping("/{id}")
    public Aspirante actualizarAspirante(@PathVariable("id") Long id, @RequestBody Aspirante aspirante) {
        return aspiranteService.actualizarAspirante(aspirante, id);
    }

    @DeleteMapping("/{id}")
    public void eliminarAspirante(@PathVariable("id") Long id) {
        aspiranteService.eliminarAspirante(id);
    }
}
