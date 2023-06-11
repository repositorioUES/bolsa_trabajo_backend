package com.bad115.SistemaBolsa.controller;

import com.bad115.SistemaBolsa.entity.Certificacion;
import com.bad115.SistemaBolsa.service.CertificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/certificaciones")
@CrossOrigin("*")
public class CertificacionController {
    @Autowired
    private CertificacionService certificacionService;

    @PostMapping("/aspirante/{aspiranteId}")
    public Certificacion guardarCertificacion(
            @RequestBody Certificacion certificacion,
            @PathVariable Long aspiranteId
    ) {
        return certificacionService.guardarCertificacion(certificacion, aspiranteId);
    }

    @GetMapping
    public List<Certificacion> obtenerCertificaciones() {
        return certificacionService.obtenerCertificaciones();
    }

    @GetMapping("/{id}")
    public Certificacion obtenerCertificacion(@PathVariable("id") Long id) {
        return certificacionService.obtenerCertificacion(id);
    }

    @PutMapping("/{id}/aspirante/{aspiranteId}")
    public Certificacion actualizarCertificacion(
            @PathVariable("id") Long id,
            @RequestBody Certificacion certificacion,
            @PathVariable Long aspiranteId
    ) {
        return certificacionService.actualizarCertificacion(certificacion, id, aspiranteId);
    }

    @DeleteMapping("/{id}")
    public void eliminarCertificacion(@PathVariable("id") Long id) {
        certificacionService.eliminarCertificacion(id);
    }
}
