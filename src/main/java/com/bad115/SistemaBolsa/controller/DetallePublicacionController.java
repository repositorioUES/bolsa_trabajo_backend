package com.bad115.SistemaBolsa.controller;

import com.bad115.SistemaBolsa.entity.DetalleHabilidad;
import com.bad115.SistemaBolsa.entity.DetallePublicacion;
import com.bad115.SistemaBolsa.service.DetallePublicacionService;
import com.bad115.SistemaBolsa.service.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalle_publicacion")
public class DetallePublicacionController {


    @Autowired
    private DetallePublicacionService detallePublicacionService;
    @Autowired
    private PublicacionService publicacionService;

    @GetMapping// Obtener TODOS los DetallePublicacion sin importar de que Publicacion sean
    public List<DetallePublicacion> getDetallePublicaciones(){
        return detallePublicacionService.getDetallesPublicaciones();
    }

    @GetMapping("/{id}")
    public DetallePublicacion getDetallePublicacion(@PathVariable Long id) {
        return detallePublicacionService.getDetallePublicacion(id);
    }

    @PostMapping("/publicacion/{id}")
    public DetallePublicacion saveDetallePublicacion(@RequestBody DetallePublicacion detallePublicacion, @PathVariable("id") Long id) {
        return detallePublicacionService.save(detallePublicacion, id);
    }

    @PutMapping("/{id}")
    public DetallePublicacion updateDetallePublicacion(@RequestBody DetallePublicacion detallePublicacion, @PathVariable("id") Long id) {
        return detallePublicacionService.update(detallePublicacion, id);
    }

    @DeleteMapping("/{id}")
    public void deleteDetallePublicacion(@PathVariable("id") Long id) {
        detallePublicacionService.delete(id);
    }

    @GetMapping("/publicacion/{id}") //Obtener todos los DetallePublicacion de una Publicacion específica
    public ResponseEntity<List<DetallePublicacion>> getDetallePublicacionByPublicacion(@PathVariable(value = "id") Long id_publicacion) {
        List<DetallePublicacion> publicaciones = null;
        if (publicacionService.existById(id_publicacion)) {
            publicaciones = detallePublicacionService.getDetallePublicacionByPublicacion(id_publicacion);
        }

        return new ResponseEntity<>(publicaciones, HttpStatus.OK);
    }
}
