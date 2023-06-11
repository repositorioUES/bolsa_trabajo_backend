package com.bad115.SistemaBolsa.service.impl;

import com.bad115.SistemaBolsa.entity.Empresa;
import com.bad115.SistemaBolsa.entity.Oferta;
import com.bad115.SistemaBolsa.entity.Usuario;
import com.bad115.SistemaBolsa.repository.EmpresaRepository;
import com.bad115.SistemaBolsa.repository.UsuarioRepository;
import com.bad115.SistemaBolsa.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Empresa guardarEmpresa(Empresa empresa, Long usuarioId) {
        Usuario usuario = usuarioRepository.getReferenceById(usuarioId);

        //if (usuario != null) {
        Empresa e = new Empresa();
        e.setNombre(empresa.getNombre());
        e.setEmail(empresa.getEmail());
        e.setTelefono(empresa.getTelefono());
        e.setUsuario(usuario);
        return empresaRepository.save(e);
        //}
        //return empresaRepository.save(empresa);
    }

    @Override
    public List<Empresa> obtenerEmpresas() {
        return empresaRepository.findAll();
    }

    @Override
    public Empresa obtenerEmpresa(Long id) {
        return empresaRepository.getReferenceById(id);
    }

    @Override
    public Empresa actualizarEmpresa(Empresa empresa, Long id, Long usuarioId){
        Usuario usuario = usuarioRepository.getReferenceById(usuarioId);

        //if (usuario != null) {
        Empresa e = empresaRepository.getReferenceById(id);
        e.setNombre(empresa.getNombre());
        e.setEmail(empresa.getEmail());
        e.setTelefono(empresa.getTelefono());
        e.setUsuario(usuario);
        return empresaRepository.save(e);
        //}
        //return empresaRepository.save(empresa);
    }

    @Override
    public void eliminarEmpresa(Long id) {
        empresaRepository.deleteById(id);
    }
}
