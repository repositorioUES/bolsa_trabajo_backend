package com.bad115.SistemaBolsa.controller;

import com.bad115.SistemaBolsa.entity.Oferta;
import com.bad115.SistemaBolsa.service.OfertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ofertas")
@CrossOrigin("*")
public class OfertaController {
    @Autowired
    private OfertaService ofertaService;

    @PostMapping
    public Oferta guardarOferta(@RequestBody Oferta oferta) {
        return null;
    }
}
