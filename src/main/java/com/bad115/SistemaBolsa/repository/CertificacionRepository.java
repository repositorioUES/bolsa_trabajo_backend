package com.bad115.SistemaBolsa.repository;

import com.bad115.SistemaBolsa.entity.Certificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificacionRepository extends JpaRepository<Certificacion, Long> {
}
