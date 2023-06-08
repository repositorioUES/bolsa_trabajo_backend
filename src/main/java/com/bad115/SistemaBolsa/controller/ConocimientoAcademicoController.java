package com.bad115.SistemaBolsa.controller;

import com.bad115.SistemaBolsa.entity.ConocimientoAcademico;
import com.bad115.SistemaBolsa.service.ConocimientoAcademicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conocimientos-academicos")
@CrossOrigin("*")
public class ConocimientoAcademicoController {
    @Autowired
    private ConocimientoAcademicoService conocimientoAcademicoService;

    @PostMapping
    public ConocimientoAcademico obtenerConocimientos(@RequestBody ConocimientoAcademico conocimientoAcademico) {
        return conocimientoAcademicoService.guardarConocimiento(conocimientoAcademico);
    }

    @GetMapping
    public List<ConocimientoAcademico> obtenerConocimientos() {
        return conocimientoAcademicoService.obtenerConocimientos();
    }

    @GetMapping("/{id}")
    public ConocimientoAcademico obtenerConocimiento(@PathVariable("id") Long id) {
        return conocimientoAcademicoService.obtenerConocimiento(id);
    }

    @PutMapping("/{id}")
    public ConocimientoAcademico actualizarConocimiento(@PathVariable("id") Long id, @RequestBody ConocimientoAcademico conocimientoAcademico) {
        return conocimientoAcademicoService.actualizarConocmiento(conocimientoAcademico, id);
    }

    @DeleteMapping("/{id}")
    public void eliminarConocimiento(@PathVariable("id") Long id) {
        conocimientoAcademicoService.eliminarConocimiento(id);
    }
}
