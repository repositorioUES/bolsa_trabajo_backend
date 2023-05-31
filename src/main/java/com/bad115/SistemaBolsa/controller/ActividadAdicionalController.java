package com.bad115.SistemaBolsa.controller;

import com.bad115.SistemaBolsa.entity.ActividadAdicional;
import com.bad115.SistemaBolsa.service.ActividadAdicionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actividadAdicional")
public class ActividadAdicionalController {

    @Autowired
    private ActividadAdicionalService actividadAdicionalService;

    @GetMapping
    public List<ActividadAdicional> getActividadesAdicionales(){
        return actividadAdicionalService.getActividadesAdicionales();
    }

    @GetMapping("/{id}")
    public ActividadAdicional getActividadAdicional(@PathVariable Long id) {
        return actividadAdicionalService.getActividadAdicional(id);
    }

    @PostMapping("/")
    public ActividadAdicional saveActividadAdicional(@RequestBody ActividadAdicional actividadAdicional) {
        return actividadAdicionalService.save(actividadAdicional);
    }

    @PutMapping("/{id}")
    public ActividadAdicional updateActividadAdicional(@RequestBody ActividadAdicional actividadAdicional, @PathVariable("id") Long id) {
        return actividadAdicionalService.update(actividadAdicional, id);
    }

    @DeleteMapping("/{id}")
    public void deleteActividadAdicional(@PathVariable("id") Long id) {
        actividadAdicionalService.delete(id);
    }
}
