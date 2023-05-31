package com.bad115.SistemaBolsa.repository;

import com.bad115.SistemaBolsa.entity.ConocimientoAcademico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConocimientoAcademicoRepository extends JpaRepository<ConocimientoAcademico, Long> {
}
