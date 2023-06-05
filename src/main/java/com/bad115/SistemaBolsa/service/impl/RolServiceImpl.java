package com.bad115.SistemaBolsa.service.impl;

import com.bad115.SistemaBolsa.entity.Rol;
import com.bad115.SistemaBolsa.repository.RolRepository;
import com.bad115.SistemaBolsa.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolRepository rolRepository;

    @Override
    public Rol obtenerRol(String nombreRol) {
        return rolRepository.findByNombreRol(nombreRol);
    }

    @Override
    public Rol findByIdRol(Long idRol) {
        return rolRepository.findByIdRol(idRol);
    }
}
