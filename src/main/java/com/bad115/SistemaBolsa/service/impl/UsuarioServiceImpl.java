package com.bad115.SistemaBolsa.service.impl;

import com.bad115.SistemaBolsa.entity.Usuario;
import com.bad115.SistemaBolsa.entity.UsuarioRol;
import com.bad115.SistemaBolsa.repository.RolRepository;
import com.bad115.SistemaBolsa.repository.UsuarioRepository;
import com.bad115.SistemaBolsa.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Override
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
        Usuario usuarioLocal = usuarioRepository.findByNombreUsuario(usuario.getNombreUsuario());
        if (usuarioLocal != null){
            System.out.println("El usuario ya existe");
            throw new Exception("El usuario ya esta presente");
        }
        else{
            for(UsuarioRol usuarioRol:usuarioRoles){
                rolRepository.save(usuarioRol.getRol());
            }
            usuario.getUsuarioRoles().addAll(usuarioRoles);
            usuarioLocal= usuarioRepository.save(usuario);
        }
        return usuarioLocal;
    }

    @Override
    public Usuario obtenerUsuario(String nombreUsuario) {
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    @Override
    public void eliminarUsuario(Long idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }
}
