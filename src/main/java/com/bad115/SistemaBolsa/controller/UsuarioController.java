package com.bad115.SistemaBolsa.controller;

import com.bad115.SistemaBolsa.entity.Rol;
import com.bad115.SistemaBolsa.entity.Usuario;
import com.bad115.SistemaBolsa.entity.UsuarioRol;
import com.bad115.SistemaBolsa.repository.RolRepository;
import com.bad115.SistemaBolsa.service.RolService;
import com.bad115.SistemaBolsa.service.UsuarioRolService;
import com.bad115.SistemaBolsa.service.UsuarioService;
import com.bad115.SistemaBolsa.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RolService rolService;

    @Autowired
    private  UsuarioRolService usuarioRolService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;


    /* Funcion que se encarga de registrar un usuario mediante username, password y email*/
    @PostMapping("/registrar")
    public Usuario guardarUsuario(@RequestBody Usuario usuario) throws Exception{

        usuario.setPassword((this.bCryptPasswordEncoder.encode(usuario.getPassword())));

        Set<UsuarioRol> usuarioRoles = new HashSet<>();


        /* CUANDO SE REGISTRA EL USUARIO SE HACE DE MANERA AUTOMATICAMENTE COMO INVITADO*/
        Rol rol = new Rol();
        rol.setIdRol(1L);
        rol.setNombreRol("INVITADO");

        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUsuario(usuario);
        usuarioRol.setRol(rol);

        usuarioRoles.add(usuarioRol);
        System.out.println(usuario);
        return usuarioService.guardarUsuario(usuario,usuarioRoles);

    }

    /* Funcion que se encarga de listar un usuario enviando como parametro su username*/
    @GetMapping("/listar/{username}")
    public Usuario obtenerUsuario(@PathVariable("username") String username){
        return usuarioService.obtenerUsuario(username);
    }

    /* Funcion que se encarga de eliminar un usuario enviando como parametro su id*/
    @DeleteMapping("/eliminar/{idUsuario}")
    public void eliminarUsuario(@PathVariable("idUsuario") Long idUsuario){
        usuarioService.eliminarUsuario(idUsuario);
    }

    /* Funcion que se encarga de listar todos los usuarios*/
    @GetMapping("/listar-todos")
    public List<Usuario> obtenerUsuarios() {
        return usuarioService.obtenerUsuarios();
    }

    /* Funcion que se encarga de editar el email de un usuario enviando como parametro su id */
    @PutMapping("/editar-email/{idUsuario}")
    public Usuario actualizarUsuario(@PathVariable("idUsuario") Long idUsuario, @RequestBody Usuario usuario) {
        return usuarioService.actualizarUsuario(usuario, idUsuario);
    }

    /* Funcion que se encarga de asignar un rol al usuario actual*/
    @PostMapping("/asignar-rol")
    public ResponseEntity<String> agregarRolUsuario(Principal principal, @RequestBody Map<String, Long> requestBody) {
        Long rolId = requestBody.get("rolId");
        if (rolId == null) {
            throw new IllegalArgumentException("El cuerpo de la solicitud debe contener el atributo 'rolId'");
        }
        Usuario usuario = (Usuario) this.userDetailsService.loadUserByUsername(principal.getName());

        Rol rol= rolService.findByIdRol(rolId);
        usuarioRolService.agregarRol(usuario,rol);
        System.out.println(rol);

        return ResponseEntity.ok("Rol agregado exitosamente");
    }

}
