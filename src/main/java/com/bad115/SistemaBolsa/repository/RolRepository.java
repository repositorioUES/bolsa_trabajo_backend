package com.bad115.SistemaBolsa.repository;

import com.bad115.SistemaBolsa.entity.Rol;
import com.bad115.SistemaBolsa.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol,Long> {

    public Rol findByNombreRol(String nombreRol);

    public Rol findByIdRol(Long idRol);
}
