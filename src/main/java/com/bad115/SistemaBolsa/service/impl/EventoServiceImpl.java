package com.bad115.SistemaBolsa.service.impl;

import com.bad115.SistemaBolsa.entity.Aspirante;
import com.bad115.SistemaBolsa.entity.Evento;
import com.bad115.SistemaBolsa.repository.AspiranteRepository;
import com.bad115.SistemaBolsa.repository.EventoRepository;
import com.bad115.SistemaBolsa.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    private EventoRepository eventoRepository;
    @Autowired
    private AspiranteRepository aspiranteRepository;

    @Override
    public Evento save(Evento evento, Long id) {
        Evento e = new Evento();
        e.setNombre_evento(evento.getNombre_evento());
        e.setLugar_evento(evento.getLugar_evento());
        e.setPais_evento(evento.getPais_evento());
        e.setFecha_inicio(evento.getFecha_inicio());
        e.setFecha_fin(evento.getFecha_fin());
        e.setAnfitrion_evento(evento.getAnfitrion_evento());
        e.setAspirante(aspiranteRepository.getReferenceById(id));
        return eventoRepository.save(e);
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
    public List<Evento> getEventosByAspirante(Long id) {
        Aspirante a = aspiranteRepository.getReferenceById(id);
        List<Evento> e = eventoRepository.getByAspirante(a);
        return e;
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

    @Override
    public boolean existById(Long id) {
        return eventoRepository.existsById(id);
    }
}
