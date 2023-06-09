package com.bad115.SistemaBolsa.repository;

import com.bad115.SistemaBolsa.entity.DetallePublicacion;
import com.bad115.SistemaBolsa.entity.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetallePublicacionRepository extends JpaRepository<DetallePublicacion, Long> {
    public DetallePublicacion getReferenceById(Long id);

    public List<DetallePublicacion> getByPublicacion(Publicacion publicacion);
}
