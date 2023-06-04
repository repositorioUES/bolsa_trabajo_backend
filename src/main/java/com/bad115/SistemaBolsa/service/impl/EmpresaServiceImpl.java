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
    public Empresa guardarEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    @Override
    public List<Empresa> obtenerEmpresas() {
        return empresaRepository.findAll();
    }

    @Override
    public Empresa obtenerEmpresa(String nombre) {
        return empresaRepository.findByNombre(nombre);
    }

    @Override
    public Empresa obtenerEmpresa(Long id) {
        return empresaRepository.getReferenceById(id);
    }

    @Override
    public Empresa actualizarEmpresa(Empresa empresa, Long id){
        Empresa empresaLocal = empresaRepository.getReferenceById(id);
        empresaLocal.setNombre(empresa.getNombre());
        empresaLocal.setTelefono(empresa.getTelefono());
        empresaLocal.setEmail(empresa.getEmail());
        empresaLocal.setOfertas(empresa.getOfertas());
        empresaLocal.setUsuario(empresa.getUsuario());
        return empresaRepository.save(empresaLocal);
    }

    @Override
    public void eliminarEmpresa(Long id) {
        empresaRepository.deleteById(id);
    }
}
