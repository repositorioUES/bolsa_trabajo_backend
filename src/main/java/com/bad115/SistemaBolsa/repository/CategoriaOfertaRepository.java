package com.bad115.SistemaBolsa.repository;

import com.bad115.SistemaBolsa.entity.CategoriaOferta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaOfertaRepository extends JpaRepository<CategoriaOferta, Long> {
    public CategoriaOferta findByNombre(String nombreCategoria);

    public void deleteByNombre(String nombreCategoria);
}
