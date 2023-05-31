package com.bad115.SistemaBolsa.repository;

import com.bad115.SistemaBolsa.entity.Aspirante;
import com.bad115.SistemaBolsa.entity.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Long> {
    public Direccion findByAspirante(Aspirante aspirante);

    public void deleteByAspirante(Aspirante aspirante);
}
