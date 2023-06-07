package com.bad115.SistemaBolsa.service;

import com.bad115.SistemaBolsa.entity.Rol;

public interface RolService {

    public Rol obtenerRol(String nombreRol);

    public Rol findByIdRol(Long idRol);
}
