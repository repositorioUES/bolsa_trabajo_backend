package com.bad115.SistemaBolsa.service;

import com.bad115.SistemaBolsa.entity.Usuario;
import com.bad115.SistemaBolsa.entity.UsuarioRol;

import java.util.List;
import java.util.Set;

public interface UsuarioService {

    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;

    public Usuario obtenerUsuario(String username);

    public void eliminarUsuario(Long idUsuario);

    public List<Usuario> obtenerUsuarios();

    public Usuario actualizarUsuario(Usuario usuario, Long id);

}
