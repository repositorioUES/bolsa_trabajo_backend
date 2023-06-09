package com.bad115.SistemaBolsa.repository;


import com.bad115.SistemaBolsa.entity.Aspirante;
import com.bad115.SistemaBolsa.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
    public Evento getReferenceById(Long id);

    public List<Evento> getByAspirante(Aspirante aspirante);
}
