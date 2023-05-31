package com.bad115.SistemaBolsa.repository;

import com.bad115.SistemaBolsa.entity.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicacionRepository extends JpaRepository <Publicacion, Long> {
    public Publicacion getReferenceById(Long id);
}
