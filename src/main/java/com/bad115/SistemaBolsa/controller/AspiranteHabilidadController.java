package com.bad115.SistemaBolsa.controller;

import com.bad115.SistemaBolsa.entity.AspiranteHabilidad;
import com.bad115.SistemaBolsa.service.ActividadAdicionalService;
import com.bad115.SistemaBolsa.service.AspiranteHabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aspirante_habilidad")
public class AspiranteHabilidadController {

    @Autowired
    private AspiranteHabilidadService aspiranteHabilidadService;


    @GetMapping("/aspirante/{id}")  // Obtener una Actividad por su ID de ASPIRANTE
    public List<AspiranteHabilidad> getAspiranteHabilidad(@PathVariable Long id) {
        return aspiranteHabilidadService.getAspiranteHabilidadByAspirante(id);
    }

    @PostMapping("/aspirante/{idA}/habilidad/{idH}")   // Guardar una habilidad con su respectivo aspirante en la tabla aspirante_abilidad
    public AspiranteHabilidad saveAspiranteHabilidad(@PathVariable("idA") Long idA, @PathVariable("idH") Long idH) {
        return aspiranteHabilidadService.save(idA, idH);
    }

    @DeleteMapping("/aspirante/{idA}/habilidad/{idH}")
    public void deleteAspiranteHabilidad(@PathVariable("idA") Long idA, @PathVariable("idH") Long idH) {
        aspiranteHabilidadService.delete(idA, idH);
    }

}
