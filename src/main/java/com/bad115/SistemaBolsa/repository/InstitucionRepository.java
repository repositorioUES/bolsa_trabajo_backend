package com.bad115.SistemaBolsa.repository;

import com.bad115.SistemaBolsa.entity.Institucion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitucionRepository extends JpaRepository<Institucion, Long> {
}
