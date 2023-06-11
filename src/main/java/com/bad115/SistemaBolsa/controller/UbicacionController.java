package com.bad115.SistemaBolsa.controller;

import com.bad115.SistemaBolsa.entity.Ubicacion;
import com.bad115.SistemaBolsa.service.UbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ubicaciones")
@CrossOrigin("*")
public class UbicacionController {
    @Autowired
    public UbicacionService ubicacionService;

    @PostMapping("/oferta/{ofertaId}")
    public Ubicacion guardarUbicacion(
            @RequestBody Ubicacion ubicacion,
            @PathVariable Long ofertaId
    ) {
        return ubicacionService.guardarUbicacion(ubicacion, ofertaId);
    }

    @GetMapping
    public List<Ubicacion> obtenerUbicaciones() {
        return ubicacionService.obtenerUbicaciones();
    }

    @GetMapping("/{id}")
    public Ubicacion obtenerUbicacion(@PathVariable("id") Long id) {
        return ubicacionService.obtenerUbicacion(id);
    }

    @PutMapping("/{id}/oferta/{ofertaId}")
    public Ubicacion actualizarUbicacion(
            @PathVariable("id") Long id,
            @RequestBody Ubicacion ubicacion,
            @PathVariable Long ofertaId
    ) {
        return ubicacionService.actualizarUbicacion(ubicacion, id, ofertaId);
    }

    @DeleteMapping("/{id}")
    public void eliminarUbicacion(@PathVariable("id") Long id) {
        ubicacionService.eliminarUbicacion(id);
    }
}
