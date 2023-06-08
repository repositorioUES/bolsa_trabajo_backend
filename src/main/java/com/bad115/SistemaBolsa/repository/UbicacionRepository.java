package com.bad115.SistemaBolsa.repository;

import com.bad115.SistemaBolsa.entity.Oferta;
import com.bad115.SistemaBolsa.entity.Ubicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UbicacionRepository extends JpaRepository<Ubicacion, Long> {

}
