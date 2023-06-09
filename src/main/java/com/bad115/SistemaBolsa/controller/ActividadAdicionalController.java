package com.bad115.SistemaBolsa.controller;

import com.bad115.SistemaBolsa.entity.ActividadAdicional;
import com.bad115.SistemaBolsa.entity.DetalleHabilidad;
import com.bad115.SistemaBolsa.service.ActividadAdicionalService;
import com.bad115.SistemaBolsa.service.AspiranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actividad_adicional")
public class ActividadAdicionalController {

    @Autowired
    private ActividadAdicionalService actividadAdicionalService;
    @Autowired
    private AspiranteService aspiranteService;

    @GetMapping     // Obtener todas las Actividades de la base
    public List<ActividadAdicional> getActividadesAdicionales(){
        return actividadAdicionalService.getActividadesAdicionales();
    }

    @GetMapping("/{id}")  // Obtener una Actividad por su ID
    public ActividadAdicional getActividadAdicional(@PathVariable Long id) {
        return actividadAdicionalService.getActividadAdicional(id);
    }

    @PostMapping("/aspirante/{id}")   // Guardar una actividad con su respectivo aspirante
    public ActividadAdicional saveActividadAdicional(@RequestBody ActividadAdicional actividadAdicional, @PathVariable("id") Long id) {
        return actividadAdicionalService.save(actividadAdicional, id);
    }

    @PutMapping("/{id}")
    public ActividadAdicional updateActividadAdicional(@RequestBody ActividadAdicional actividadAdicional, @PathVariable("id") Long id) {
        return actividadAdicionalService.update(actividadAdicional, id);
    }

    @DeleteMapping("/{id}")
    public void deleteActividadAdicional(@PathVariable("id") Long id) {
        actividadAdicionalService.delete(id);
    }

    @GetMapping("/aspirante/{id}") //Obtener todos las ACTIVIDADES de un Aspirante específico
    public ResponseEntity<List<ActividadAdicional>> getActividadByAspirante(@PathVariable(value = "id") Long id) {
        List<ActividadAdicional> actividades = null;
        actividades = actividadAdicionalService.getActividadAdicionalByAspirante(id);

        return new ResponseEntity<>(actividades, HttpStatus.OK);
    }
}
