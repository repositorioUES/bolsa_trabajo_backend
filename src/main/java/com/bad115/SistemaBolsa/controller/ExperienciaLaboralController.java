package com.bad115.SistemaBolsa.controller;

import com.bad115.SistemaBolsa.entity.ExperienciaLaboral;
import com.bad115.SistemaBolsa.service.ExperienciaLaboralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experiencia_laboral")
public class ExperienciaLaboralController {

    @Autowired
    private ExperienciaLaboralService experienciaLaboralService;


    @GetMapping
    public List<ExperienciaLaboral> getPublicaciones(){
        return experienciaLaboralService.getExperienciasLaborales();
    }

    @GetMapping("/{id}")
    public ExperienciaLaboral getExperienciaLaboral(@PathVariable Long id) {
        return experienciaLaboralService.getExperienciaLaboral(id);
    }

    @PostMapping("/aspirante/{id}")
    public ExperienciaLaboral saveExperienciaLaboral(@RequestBody ExperienciaLaboral experienciaLaboral, @PathVariable("id") Long id) {
        return experienciaLaboralService.save(experienciaLaboral, id);
    }

    @PutMapping("/{id}")
    public ExperienciaLaboral updateExperienciaLaboral(@RequestBody ExperienciaLaboral experienciaLaboral, @PathVariable("id") Long id) {
        return experienciaLaboralService.update(experienciaLaboral, id);
    }

    @DeleteMapping("/{id}")
    public void deletePublicacion(@PathVariable("id") Long id) {
        experienciaLaboralService.delete(id);
    }

    @GetMapping("/aspirante/{id}") //Obtener todos las EXPERIENCIA de un Aspirante específico
    public ResponseEntity<List<ExperienciaLaboral>> getPublicacionByAspirante(@PathVariable(value = "id") Long id) {
        List<ExperienciaLaboral> experiencias = null;
        experiencias = experienciaLaboralService.getExperienciaLaboralByAspirante(id);

        return new ResponseEntity<>(experiencias, HttpStatus.OK);
    }
}
