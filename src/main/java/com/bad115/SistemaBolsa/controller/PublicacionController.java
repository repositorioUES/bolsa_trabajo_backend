package com.bad115.SistemaBolsa.controller;

import com.bad115.SistemaBolsa.entity.Publicacion;
import com.bad115.SistemaBolsa.service.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publicacion")
public class PublicacionController {


    @Autowired
    private PublicacionService publicacionService;

    @GetMapping
    public List<Publicacion> getPublicaciones(){
        return publicacionService.getPublicaciones();
    }

    @GetMapping("/{id}")
    public Publicacion getPublicacion(@PathVariable Long id) {
        return publicacionService.getPublicacion(id);
    }

    @PostMapping("/")
    public Publicacion savePublicacion(@RequestBody Publicacion publicacion) {
        return publicacionService.save(publicacion);
    }

    @PutMapping("/{id}")
    public Publicacion updatePublicacion(@RequestBody Publicacion publicacion, @PathVariable("id") Long id) {
        return publicacionService.update(publicacion, id);
    }

    @DeleteMapping("/{id}")
    public void deletePublicacion(@PathVariable("id") Long id) {
        publicacionService.delete(id);
    }
}
