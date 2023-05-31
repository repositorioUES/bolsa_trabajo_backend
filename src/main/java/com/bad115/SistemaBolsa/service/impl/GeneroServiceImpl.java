package com.bad115.SistemaBolsa.service.impl;

import com.bad115.SistemaBolsa.entity.Genero;
import com.bad115.SistemaBolsa.repository.GeneroRepository;
import com.bad115.SistemaBolsa.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroServiceImpl implements GeneroService {
    @Autowired
    private GeneroRepository generoRepository;


    @Override
    public Genero guardarGenero(Genero genero) throws Exception {
        Genero generoLocal = generoRepository.findByNombre(genero.getNombre());
        if (generoLocal != null) {
            throw new Exception("El género ya existe");
        } else {
            generoLocal = generoRepository.save(genero);
        }
        return generoLocal;
    }

    @Override
    public Genero obtenerGenero(Long id) {

        return generoRepository.getReferenceById(id);
    }

    @Override
    public List<Genero> obtenerGeneros() {

        return generoRepository.findAll();
    }

    @Override
    public Genero actualizarGenero(Genero genero, Long id) {
        Genero generoLocal = generoRepository.getReferenceById(id);
        generoLocal.setNombre(genero.getNombre());
        generoLocal.setAspirantes(genero.getAspirantes());
        return generoRepository.save(generoLocal);
    }

    @Override
    public void eliminarGenero(Long id) {
        generoRepository.deleteById(id);
    }
}
