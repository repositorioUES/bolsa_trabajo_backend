package com.bad115.SistemaBolsa.controller;

import com.bad115.SistemaBolsa.entity.Oferta;
import com.bad115.SistemaBolsa.service.OfertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ofertas")
@CrossOrigin("*")
public class OfertaController {
    @Autowired
    private OfertaService ofertaService;

    @PostMapping
    public Oferta guardarOferta(@RequestBody Oferta oferta) {

        return ofertaService.guardarOferta(oferta);
    }

    @GetMapping
    public List<Oferta> obtenerOfertas() {
        return ofertaService.obtenerOfertas();
    }

    @GetMapping("/{id}")
    public Oferta obtenerOferta(@PathVariable("id") Long id) {
        return ofertaService.obtenerOferta(id);
    }

    @PutMapping("/{id}")
    public Oferta actualizarOferta(@PathVariable("id") Long id, @RequestBody Oferta oferta) {
        return ofertaService.actualizarOferta(oferta, id);
    }

    @PutMapping("/{ofertaId}/modalidad/{modalidadId}")
    public Oferta guardarModalidad(
            @PathVariable Long ofertaId,
            @PathVariable Long modalidadId
    ) {
        return ofertaService.agregarModalidad(ofertaId, modalidadId);
    }

    @DeleteMapping("/{id}")
    public void eliminarOferta(@PathVariable("id") Long id) {
        ofertaService.eliminarOferta(id);
    }
}
