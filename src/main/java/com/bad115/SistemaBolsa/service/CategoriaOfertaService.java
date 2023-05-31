package com.bad115.SistemaBolsa.service;

import com.bad115.SistemaBolsa.entity.CategoriaOferta;

import java.util.List;


public interface CategoriaOfertaService {

    public CategoriaOferta guardarCategoria(CategoriaOferta categoriaOferta) throws Exception;

    public CategoriaOferta obtenerCategoria(Long id);

    public CategoriaOferta obtenerCategoria(String nombreCategoria);

    public List<CategoriaOferta> obtenerCategorias();

    public CategoriaOferta actualizarCategoria(CategoriaOferta categoriaOferta, Long id);

    public CategoriaOferta actualizarCategoria(CategoriaOferta categoriaOferta, String nombreCategoria);

    public void eliminarCategoria(Long id);

    public void eliminarCategoria(String nombreCategoria);
}
