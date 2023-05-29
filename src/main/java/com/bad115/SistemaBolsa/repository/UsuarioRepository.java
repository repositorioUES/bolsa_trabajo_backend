package com.bad115.SistemaBolsa.repository;

import com.bad115.SistemaBolsa.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    public Usuario findByNombreUsuario(String nombreUsuario);
}
