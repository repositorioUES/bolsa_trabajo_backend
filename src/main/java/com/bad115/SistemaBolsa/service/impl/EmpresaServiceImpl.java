package com.bad115.SistemaBolsa.service.impl;

import com.bad115.SistemaBolsa.entity.Empresa;
import com.bad115.SistemaBolsa.repository.EmpresaRepository;
import com.bad115.SistemaBolsa.repository.UsuarioRepository;
import com.bad115.SistemaBolsa.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaServiceImpl implements EmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository;

    /*@Autowired
    private UsuarioRepository usuarioRepository;*/

    @Override
    public Empresa save(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    @Override
    public Empresa getEmpresa(Long id) {
        return empresaRepository.getReferenceById(id);
    }

    @Override
    public List<Empresa> getEmpresas() {
        return empresaRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        empresaRepository.deleteById(id);
    }

    @Override
    public Empresa update(Empresa empresa, Long id) {
        Empresa empresaActualizada = empresaRepository.getReferenceById(id);
       // empresaActualizada.setDireccion(empresa.getDireccion());
        empresaActualizada.setEmail(empresa.getEmail());
        empresaActualizada.setTelefono(empresa.getTelefono());
        empresaActualizada.setNombre(empresa.getNombre());
        //empresaActualizada.setUsuario(empresa.getUsuario());
        return empresaRepository.save(empresaActualizada);
    }


}
