package com.bad115.SistemaBolsa.controller;

import com.bad115.SistemaBolsa.entity.Evento;
import com.bad115.SistemaBolsa.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evento")
public class EventoController {


    @Autowired
    private EventoService eventoService;

    @GetMapping
    public List<Evento> getHabilidades(){
        return eventoService.getEventos();
    }

    @GetMapping("/{id}")
    public Evento getEvento(@PathVariable Long id) {
        return eventoService.getEvento(id);
    }

    @PostMapping("/")
    public Evento saveEvento(@RequestBody Evento evento) {
        return eventoService.save(evento);
    }

    @PutMapping("/{id}")
    public Evento updateEvento(@RequestBody Evento evento, @PathVariable("id") Long id) {
        return eventoService.update(evento, id);
    }

    @DeleteMapping("/{id}")
    public void deleteEvento(@PathVariable("id") Long id) {
        eventoService.delete(id);
    }
}
