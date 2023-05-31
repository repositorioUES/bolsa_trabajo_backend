package com.bad115.SistemaBolsa.controller;

import com.bad115.SistemaBolsa.entity.CategoriaOferta;
import com.bad115.SistemaBolsa.service.CategoriaOfertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@CrossOrigin("*")
public class CategoriaController {
    @Autowired
    private CategoriaOfertaService categoriaOfertaService;

    @PostMapping
    public CategoriaOferta guardarCategoria(@RequestBody CategoriaOferta categoriaOferta) throws Exception{
        return categoriaOfertaService.guardarCategoria(categoriaOferta);
    }

    @GetMapping
    public List<CategoriaOferta> obtenerCategorias() {
        return categoriaOfertaService.obtenerCategorias();
    }

    @GetMapping("/{id}")
    public CategoriaOferta obtenerCategoria(@PathVariable("id") Long id) {
        return categoriaOfertaService.obtenerCategoria(id);
    }

    @PutMapping("/{id}")
    public CategoriaOferta actualizarCategoria(@PathVariable("id") Long id, @RequestBody CategoriaOferta categoriaOferta) {
        return categoriaOfertaService.actualizarCategoria(categoriaOferta, id);
    }

    @DeleteMapping("/{id}")
    public void eliminarCategoria(@PathVariable("id") Long id) {
        categoriaOfertaService.eliminarCategoria(id);
    }
}
