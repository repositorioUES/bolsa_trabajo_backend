package com.bad115.SistemaBolsa.service.impl;

import com.bad115.SistemaBolsa.entity.Evento;
import com.bad115.SistemaBolsa.repository.EventoRepository;
import com.bad115.SistemaBolsa.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Override
    public Evento save(Evento evento) {
        return eventoRepository.save(evento);
    }

    @Override
    public Evento getEvento(Long id) {
        return eventoRepository.getReferenceById(id);
    }

    @Override
    public List<Evento> getEventos() {
        return eventoRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        eventoRepository.deleteById(id);
    }

    @Override
    public Evento update(Evento evento, Long id) {
        Evento e = eventoRepository.getReferenceById(id);
        e.setNombre_evento(evento.getNombre_evento());
        e.setLugar_evento(evento.getLugar_evento());
        e.setPais_evento(evento.getPais_evento());
        e.setFecha_inicio(evento.getFecha_inicio());
        e.setFecha_fin(evento.getFecha_fin());
        e.setAnfitrion_evento(evento.getAnfitrion_evento());
        return eventoRepository.save(e);
    }
}
