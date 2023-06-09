package com.bad115.SistemaBolsa.controller;

import com.bad115.SistemaBolsa.entity.Habilidad;
import com.bad115.SistemaBolsa.service.HabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habilidad")
public class HabilidadController {
    
    @Autowired
    private HabilidadService habilidadService;
    
    @GetMapping
    public List<Habilidad> getHabilidades(){
        return habilidadService.getHabilidades();
    }

    @GetMapping("/{id}")
    public Habilidad getHabilidad(@PathVariable Long id) {
        return habilidadService.getHabilidad(id);
    }

    @PostMapping("/")
    public Habilidad saveHabilidad(@RequestBody Habilidad habilidad) {
        return habilidadService.save(habilidad);
    }

    @PutMapping("/{id}")
    public Habilidad updateHabilidad(@RequestBody Habilidad habilidad, @PathVariable("id") Long id) {
        return habilidadService.update(habilidad, id);
    }

    @DeleteMapping("/{id}")
    public void deleteHabilidad(@PathVariable("id") Long id) {
        habilidadService.delete(id);
    }

}
