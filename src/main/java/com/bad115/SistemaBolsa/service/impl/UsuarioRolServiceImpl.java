package com.bad115.SistemaBolsa.service.impl;

import com.bad115.SistemaBolsa.entity.Rol;
import com.bad115.SistemaBolsa.entity.Usuario;
import com.bad115.SistemaBolsa.entity.UsuarioRol;
import com.bad115.SistemaBolsa.repository.UsuarioRolRepository;
import com.bad115.SistemaBolsa.service.UsuarioRolService;
import com.bad115.SistemaBolsa.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioRolServiceImpl implements UsuarioRolService {

    @Autowired
    private UsuarioRolRepository usuarioRolRepository;

    @Override
    public void agregarRol(Usuario usuario, Rol rol) {
        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUsuario(usuario);
        usuarioRol.setRol(rol);
        usuarioRolRepository.save(usuarioRol);
    }
}
