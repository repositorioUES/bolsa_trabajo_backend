package com.bad115.SistemaBolsa.service;

import com.bad115.SistemaBolsa.entity.Rol;
import com.bad115.SistemaBolsa.entity.Usuario;

public interface UsuarioRolService {

    void agregarRol(Usuario usuario, Rol rol);
}
