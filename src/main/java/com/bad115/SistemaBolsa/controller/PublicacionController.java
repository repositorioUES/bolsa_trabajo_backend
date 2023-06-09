package com.bad115.SistemaBolsa.controller;

import com.bad115.SistemaBolsa.entity.Publicacion;
import com.bad115.SistemaBolsa.service.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/aspirante/{id}")
    public Publicacion savePublicacion(@RequestBody Publicacion publicacion, @PathVariable("id") Long id) {
        return publicacionService.save(publicacion, id);
    }

    @PutMapping("/{id}")
    public Publicacion updatePublicacion(@RequestBody Publicacion publicacion, @PathVariable("id") Long id) {
        return publicacionService.update(publicacion, id);
    }

    @DeleteMapping("/{id}")
    public void deletePublicacion(@PathVariable("id") Long id) {
        publicacionService.delete(id);
    }

    @GetMapping("/aspirante/{id}") //Obtener todos las PUBLICACIONES de un Aspirante específico
    public ResponseEntity<List<Publicacion>> getPublicacionByAspirante(@PathVariable(value = "id") Long id) {
        List<Publicacion> publicaciones = null;
        publicaciones = publicacionService.getPublicacionesByAspirante(id);

        return new ResponseEntity<>(publicaciones, HttpStatus.OK);
    }
}

