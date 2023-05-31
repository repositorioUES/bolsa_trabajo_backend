package com.bad115.SistemaBolsa.repository;

import com.bad115.SistemaBolsa.entity.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long> {
    public Genero findByNombre(String nombre);
}
