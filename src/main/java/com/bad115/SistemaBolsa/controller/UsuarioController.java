package com.bad115.SistemaBolsa.controller;

import com.bad115.SistemaBolsa.entity.Rol;
import com.bad115.SistemaBolsa.entity.Usuario;
import com.bad115.SistemaBolsa.entity.UsuarioRol;
import com.bad115.SistemaBolsa.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/")
    public Usuario guardarUsuario(@RequestBody Usuario usuario) throws Exception{
        Set<UsuarioRol> usuarioRoles = new HashSet<>();

        Rol rol = new Rol();
        rol.setIdRol(2L);
        rol.setNombreRol("NORMAL");

        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUsuario(usuario);
        usuarioRol.setRol(rol);

        usuarioRoles.add(usuarioRol);

        return usuarioService.guardarUsuario(usuario,usuarioRoles);
    }

    @GetMapping("/{nombreUsuario}")
    public Usuario obtenerUsuario(@PathVariable("nombreUsuario") String nombreUsuario){
        return usuarioService.obtenerUsuario(nombreUsuario);
    }

    @DeleteMapping("/{idUsuario}")
    public void eliminarUsuario(@PathVariable("idUsuario") Long idUsuario){
        usuarioService.eliminarUsuario(idUsuario);
    }


}
