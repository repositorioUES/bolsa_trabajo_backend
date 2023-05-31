package com.bad115.SistemaBolsa.repository;

import com.bad115.SistemaBolsa.entity.Modalidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModalidadRepository extends JpaRepository<Modalidad, Long> {

}
