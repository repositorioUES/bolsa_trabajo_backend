package com.bad115.SistemaBolsa.controller;

import com.bad115.SistemaBolsa.entity.Rol;
import com.bad115.SistemaBolsa.entity.Usuario;
import com.bad115.SistemaBolsa.entity.UsuarioRol;
import com.bad115.SistemaBolsa.repository.RolRepository;
import com.bad115.SistemaBolsa.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @PostMapping("/")
    public Usuario guardarUsuario(@RequestBody Usuario usuario) throws Exception{

        usuario.setPassword((this.bCryptPasswordEncoder.encode(usuario.getPassword())));
        Set<UsuarioRol> usuarioRoles = new HashSet<>();

        Rol rol = new Rol();
        rol.setIdRol(1L);
        rol.setNombreRol("INVITADO");

        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUsuario(usuario);
        usuarioRol.setRol(rol);

        usuarioRoles.add(usuarioRol);

        return usuarioService.guardarUsuario(usuario,usuarioRoles);
    }

    @GetMapping("/{username}")
    public Usuario obtenerUsuario(@PathVariable("username") String username){
        return usuarioService.obtenerUsuario(username);
    }

    @DeleteMapping("/{idUsuario}")
    public void eliminarUsuario(@PathVariable("idUsuario") Long idUsuario){
        usuarioService.eliminarUsuario(idUsuario);
    }

    @GetMapping("/all")
    public List<Usuario> obtenerUsuarios() {
        return usuarioService.obtenerUsuarios();
    }


}
