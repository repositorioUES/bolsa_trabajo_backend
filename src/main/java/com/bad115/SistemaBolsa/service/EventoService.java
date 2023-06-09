package com.bad115.SistemaBolsa.service;

import com.bad115.SistemaBolsa.entity.Evento;

import java.util.List;

public interface EventoService {
    public Evento save(Evento evento, Long id);

    public Evento getEvento(Long id);

    public List<Evento> getEventos();

    public List<Evento> getEventosByAspirante(Long id);

    public void delete(Long id);

    public Evento update(Evento evento, Long id);

    public boolean existById(Long id);
}
