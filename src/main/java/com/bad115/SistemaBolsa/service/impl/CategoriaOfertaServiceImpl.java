package com.bad115.SistemaBolsa.service.impl;

import com.bad115.SistemaBolsa.entity.CategoriaOferta;
import com.bad115.SistemaBolsa.repository.CategoriaOfertaRepository;
import com.bad115.SistemaBolsa.service.CategoriaOfertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaOfertaServiceImpl implements CategoriaOfertaService {
    @Autowired
    private CategoriaOfertaRepository categoriaOfertaRepository;

    @Override
    public CategoriaOferta guardarCategoria(CategoriaOferta categoriaOferta) throws Exception{
        CategoriaOferta categoriaLocal = categoriaOfertaRepository.findByNombre(categoriaOferta.getNombre());
        if (categoriaLocal != null) {
            throw new Exception("La categoria ya existe");
        } else {
            categoriaLocal = categoriaOfertaRepository.save(categoriaOferta);
        }
        return categoriaLocal;
    }

    @Override
    public CategoriaOferta obtenerCategoria(Long id) {
        return categoriaOfertaRepository.getReferenceById(id);
    }

    @Override
    public CategoriaOferta obtenerCategoria(String nombreCategoria) {
        return categoriaOfertaRepository.findByNombre(nombreCategoria);
    }

    @Override
    public List<CategoriaOferta> obtenerCategorias() {
        return categoriaOfertaRepository.findAll();
    }

    @Override
    public CategoriaOferta actualizarCategoria(CategoriaOferta categoriaOferta, Long id) {
        CategoriaOferta categoriaLocal = categoriaOfertaRepository.getReferenceById(id);
        categoriaLocal.setNombre(categoriaOferta.getNombre());
        categoriaLocal.setDescripcion(categoriaOferta.getDescripcion());
        categoriaLocal.setOfertas(categoriaOferta.getOfertas());
        return categoriaOfertaRepository.save(categoriaLocal);
    }

    @Override
    public CategoriaOferta actualizarCategoria(CategoriaOferta categoriaOferta, String nombreCategoria) {
        CategoriaOferta categoriaLocal = categoriaOfertaRepository.findByNombre(nombreCategoria);
        categoriaLocal.setNombre(categoriaOferta.getNombre());
        categoriaLocal.setDescripcion(categoriaOferta.getDescripcion());
        categoriaLocal.setOfertas(categoriaOferta.getOfertas());
        return categoriaOfertaRepository.save(categoriaLocal);
    }

    @Override
    public void eliminarCategoria(Long id) {
        categoriaOfertaRepository.deleteById(id);
    }

    @Override
    public void eliminarCategoria(String nombreCategoria) {
        categoriaOfertaRepository.deleteByNombre(nombreCategoria);
    }
}
